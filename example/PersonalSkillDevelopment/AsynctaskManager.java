package com.example.PersonalSkillDevelopment;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.SessionRealTimeSharedPreferenceDemo.PreferenceManager;

import org.json.JSONArray;
import org.json.JSONException;
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
import java.util.ArrayList;

public class AsynctaskManager extends AsyncTask<String,Void,String> {


    Context context;
    public static String serverresponse;
    PreferenceManagerPeskde preferenceManagerPeskde;
    AsynctaskManager(Context ctx)
    {
        context = ctx;
    }
    @Override
    protected String doInBackground(String... params) {

        String type = params[0];
//        String register_url = "http://192.168.0.105/AndroidAPI/registerform.php";
        String register_url = "https://ketpatelhostingsite.000webhostapp.com/registerpeskde.php";
        String login_url = "https://ketpatelhostingsite.000webhostapp.com/loginpeskde.php";
        if(type.equals("register")) {
            try {
                String name = params[1];
                String email = params[2];
                String phone = params[3];
                String username = params[4];
                String password = params[5];

                URL url = new URL(register_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&" + URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&" + URLEncoder.encode("phone", "UTF-8") + "=" + URLEncoder.encode(phone, "UTF-8") + "&" + URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8") + "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
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
    public void setServerresponse(String re)
    {
        serverresponse=re;
    }
    public String getServerresponse()
    {
        return serverresponse;
    }
    @Override
    protected void onPreExecute() {
    }

    @Override
    protected void onPostExecute(String s) {


        serverresponse = s;

        if(serverresponse.equals("fail"))
        {
            Toast.makeText(context, "Phone Number may already Registerd", Toast.LENGTH_SHORT).show();
        }
        else {
            System.out.println("serverresponse is : " + s);
            preferenceManagerPeskde = new PreferenceManagerPeskde(context);
            preferenceManagerPeskde.setUserIDSharedPreference(serverresponse);
            preferenceManagerPeskde.setLoginSharedPrefrence();
            //preferenceManagerPeskde.setUserIDSharedPreference(userid);
            preferenceManagerPeskde.setLevelSharedPreference("1");


            Intent intent = new Intent(context, home_peskde.class);
            context.startActivity(intent);
        }


    }

    @Override
    protected void finalize() throws Throwable {

        super.finalize();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
