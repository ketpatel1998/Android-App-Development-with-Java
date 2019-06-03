package com.example.PersonalSkillDevelopment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

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

public class LoginAsynctaskManager extends AsyncTask<String,Void,String> {

    Context context;
    PreferenceManagerPeskde preferenceManagerPeskde;

    public static String serverresponse;

    public LoginAsynctaskManager(Context ctx)
    {
        context=ctx;
    }
    @Override
    protected void onPreExecute() {

    }

    @Override
    protected void onPostExecute(String s) {

        System.out.print(s);
        serverresponse = s;

        if(serverresponse.equals("fail"))
        {
            Toast.makeText(context, "Invalid Username or Password", Toast.LENGTH_SHORT).show();

        }
        else{
            try {
                String data = serverresponse;
                JSONObject obj = new JSONObject(data);
                String id = obj.getString("id");
                String name = obj.getString("name");
                String username = obj.getString("username");
                String password = obj.getString("password");
                String phone = obj.getString("phone");
                String email = obj.getString("email");
                String level = obj.getString("level");

                preferenceManagerPeskde = new PreferenceManagerPeskde(context);
                preferenceManagerPeskde.setUserIDSharedPreference(id);
                preferenceManagerPeskde.setLevelSharedPreference(level);
                preferenceManagerPeskde.setRegisterInfo(name, username, email, phone, password);

                preferenceManagerPeskde.setLoginSharedPrefrence();

                Intent intent = new Intent(context, home_peskde.class);
                context.startActivity(intent);


            } catch (Exception e) {


                //e.printStackTrace();
            }
        }


    }

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];


        String login_url = "https://ketpatelhostingsite.000webhostapp.com/loginpeskde.php";
        if(type.equals("loginform")) {
            try {
//                String name = params[1];
//                String email = params[2];
//                String phone = params[3];
                String username = params[1];
                String password = params[2];

                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8") + "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
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
