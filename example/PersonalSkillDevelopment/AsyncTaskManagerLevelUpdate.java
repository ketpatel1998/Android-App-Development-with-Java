package com.example.PersonalSkillDevelopment;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

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

public class AsyncTaskManagerLevelUpdate extends AsyncTask<String,Void,String> {


    Context context;
    String level;
    public static String serverresponse;
    PreferenceManagerPeskde preferenceManagerPeskde;

    public AsyncTaskManagerLevelUpdate(Context ctx) {
        context = ctx;
    }

    @Override
    protected void onPreExecute() {




    }

    @Override
    protected void onPostExecute(String s) {
        serverresponse = s;
        System.out.println("serverresponse is : "+s);

        if(serverresponse.equals("success"))
        {
            preferenceManagerPeskde = new PreferenceManagerPeskde(context);


            preferenceManagerPeskde.setLevelSharedPreference(level);


            Intent intent = new Intent(context, ScinceKnowledgeActivity.class);
            context.startActivity(intent);
        }
        else
        {
            Toast.makeText(context, "Error IN Updation", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    protected String doInBackground(String... params) {

        String type = params[0];
//        String register_url = "http://192.168.0.105/AndroidAPI/registerform.php";
        String level_update = "https://ketpatelhostingsite.000webhostapp.com/updatelevelpeskde.php";

        if(type.equals("updatelevel")) {
            try {
                level = params[1];
                String id = params[2];

                URL url = new URL(level_update);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(id, "UTF-8") + "&" + URLEncoder.encode("level", "UTF-8") + "=" + URLEncoder.encode(level, "UTF-8");
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
