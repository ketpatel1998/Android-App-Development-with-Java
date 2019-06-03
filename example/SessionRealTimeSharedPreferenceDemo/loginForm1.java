package com.example.SessionRealTimeSharedPreferenceDemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.application1.R;

public class loginForm1 extends AppCompatActivity {

    EditText uname;
    EditText pass;
    Button login;
    Intent intent;
    PreferenceManager preferenceManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form1);

        preferenceManager = new PreferenceManager(this);

        if(preferenceManager.getLoginSession())
        {
            intent = new Intent(loginForm1.this,MainActivityHome.class);
            startActivity(intent);
        }

        uname = (EditText) findViewById(R.id.txt_uname);
        pass = (EditText) findViewById(R.id.txt_pass);
        login = (Button) findViewById(R.id.btn_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                preferenceManager.setUserIDandPasswordID(uname.getText().toString(),pass.getText().toString());
                preferenceManager.setLoginSession();
                intent = new Intent(loginForm1.this,MainActivityHome.class);
                startActivity(intent);

            }
        });
        

    }
}
