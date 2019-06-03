package com.example.RegisterUsingDB;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.application1.R;

public class RegisterPage extends AppCompatActivity {

    EditText name;
    EditText email;
    EditText phone;
    EditText username;
    EditText password;
    Button btnreg;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        context = this;
        btnreg = (Button) findViewById(R.id.btnregister);
        name = (EditText) findViewById(R.id.etname);
        email = (EditText) findViewById(R.id.etemail);
        phone = (EditText) findViewById(R.id.etphone);
        username = (EditText) findViewById(R.id.etusername);
        password = (EditText) findViewById(R.id.etpassword);

        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String na = name.getText().toString();
                String em = email.getText().toString();
                String ph = phone.getText().toString();
                String us = username.getText().toString();
                String ps = password.getText().toString();
                String type = "register";
                BackgroundWorker bw = new BackgroundWorker(context);
                bw.execute(type,na,em,ph,us,ps);
            }
        });

    }
}
