package com.example.PersonalSkillDevelopment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.application1.R;

public class registerFormPeskde extends AppCompatActivity {

    TextView etname;
    TextView etuname;
    TextView etpassword;
    TextView etphone;
    TextView etemail;
    TextView btnregister;
    Button btnhellyeah;
    String name;
    String uname;
    String phone;
    String pass;
    String email;
    PreferenceManagerPeskde preferenceManagerPeskde;
    SharedPreferences mshaSharedPreferences2;
    SharedPreferences.Editor meditEditor2;
    String uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_form_peskde);

//        Intent intent = new Intent(registerFormPeskde.this, home_peskde.class);
//        startActivity(intent);

        etname = (TextView) findViewById(R.id.etname1);
        etemail = (TextView) findViewById(R.id.etemail1);
        etuname = (TextView) findViewById(R.id.etuname1);
        etpassword = (TextView) findViewById(R.id.etpassword1);
        etphone =  (TextView) findViewById(R.id.etphone1);
        btnregister = (TextView) findViewById(R.id.btnregister1);
        btnhellyeah = (Button) findViewById(R.id.btnhellyeah);

        preferenceManagerPeskde = new PreferenceManagerPeskde(this);
        name = preferenceManagerPeskde.getNameSharedPrefrence();
        email = preferenceManagerPeskde.getEmailSharedPrefrence();
        uname = preferenceManagerPeskde.getUsernameSharePrefrence();
        pass = preferenceManagerPeskde.getPasswordSharedPrefrence();
        phone = preferenceManagerPeskde.getPhoneSharedPrefrence();
        uid = preferenceManagerPeskde.getUserIDSharedPrefrence();

//        mshaSharedPreferences2 = getSharedPreferences("PESKDE",MODE_PRIVATE);
//
//        name = mshaSharedPreferences2.getString("NAME","");
//        email = mshaSharedPreferences2.getString("EMAIL","");
//        uname = mshaSharedPreferences2.getString("USERNAME","");
//        pass = mshaSharedPreferences2.getString("PASSWORD","");
//        phone = mshaSharedPreferences2.getString("PHONE","");
//        uid = mshaSharedPreferences2.getString("USERID","");

        btnhellyeah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        etname.setText(name);
                        etemail.setText(email);
                        etuname.setText(uname);
                        etpassword.setText(pass);
                        etphone.setText(phone);


                        btnregister.setText(uid);

            }
        });


    }
}
