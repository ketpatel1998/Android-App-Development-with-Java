package com.example.PersonalSkillDevelopment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.application1.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class AsynctaskManagetScinceKnowledge  extends AsyncTask<String,Void,String> {

    Context context;
    public static String serverresponse;
  PreferenceManagerPeskde preferenceManagerPeskde;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;


    public AsynctaskManagetScinceKnowledge(Context ctx) {
        context = ctx;
    }

    @Override
    protected void onPreExecute() {

    }


    @Override
    protected void onPostExecute(String s) {

        serverresponse = "["+s+"]";
        System.out.println("Data serverresponse is "+serverresponse);
        try {
            //JSONObject obj = new JSONObject(serverresponse);
            JSONArray jsonArray = new JSONArray(serverresponse);
            String que =  "QUESTION";
            for (int i=0;i<jsonArray.length();i++)
            {
                JSONObject object = jsonArray.getJSONObject(i);
                String prefname = que+i;

                SharedPreferences sharedPreferences = context.getSharedPreferences(prefname,Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("Question",object.getString("question"));
                editor.putString("Option1",object.getString("option1"));
                editor.putString("Option2",object.getString("option2"));
                editor.putString("Option3",object.getString("option3"));
                editor.putString("Option4",object.getString("option4"));
                editor.putString("Answer",object.getString("answer"));
                editor.putString("Level",object.getString("level"));
                editor.putString("Queid",object.getString("que_id"));

                editor.commit();
                System.out.println("Data line "+i+" : "+object);

            }





            Intent intent = new Intent(context, Qustion1Activity.class);
            context.startActivity(intent);



        }
        catch (Exception e)
        {
            e.printStackTrace();
        }




    }

    @Override
    protected String doInBackground(String... params) {

        String type = params[0];
//        String register_url = "http://192.168.0.105/AndroidAPI/registerform.php";
//        String register_url = "https://ketpatelhostingsite.000webhostapp.com/registerpeskde.php";
//        String login_url = "https://ketpatelhostingsite.000webhostapp.com/loginpeskde.php";
        String questions_url = "https://ketpatelhostingsite.000webhostapp.com/questionsgetpeskde.php";
        if(type.equals("questions")) {
            try {
                String level = params[1];



                URL url = new URL(questions_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("level", "UTF-8") + "=" + URLEncoder.encode(level, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                System.out.print("result : "+result);
                serverresponse = result;
//                preferenceManagerPeskde = new PreferenceManagerPeskde(context);
//                preferenceManagerPeskde.setUserIDSharedPreference(result);

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
