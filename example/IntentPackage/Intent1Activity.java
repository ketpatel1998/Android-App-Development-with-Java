package com.example.IntentPackage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.application1.R;

public class Intent1Activity extends AppCompatActivity {
    Button btnlogin;
    EditText txtusername;
    EditText txtpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent1);

        btnlogin = (Button) findViewById(R.id.btnsetlogin);
        txtusername = (EditText) findViewById(R.id.txtusername);
        txtpassword = (EditText) findViewById(R.id.txtpassword);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = txtusername.getText().toString();
                String pname = txtpassword.getText().toString();
                if(uname.length()==0)
                {
                    Toast.makeText(Intent1Activity.this, "Enter Username first", Toast.LENGTH_SHORT).show();

                }
                else if(pname.length()==0)
                {
                    Toast.makeText(Intent1Activity.this, "Enter Password", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent(Intent1Activity.this,Intent2Activity.class);
                    intent.putExtra("Uname",uname);
                    intent.putExtra("Pname",pname);
                    startActivity(intent);
                }

            }
        });
    }
}
