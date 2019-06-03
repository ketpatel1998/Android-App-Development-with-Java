package com.example.IntentPackage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.application1.R;




public class Intent2Activity extends AppCompatActivity {

/*
    @BindView(R.id.txtname2)
    TextView txtname2;
    @BindView(R.id.txtpassword2)
    TextView txtpassword2;
    @Override

    */
    TextView txtname2;
    TextView txtpassword2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent3);
        //ButterKnife.bind(this);
        txtname2 = (TextView) findViewById(R.id.txtname2);
        txtpassword2 = (TextView) findViewById(R.id.txtpassword2);
        Intent in = getIntent();
        String data1 = in.getStringExtra("Uname");
        String data2 = in.getStringExtra("Pname");
        txtname2.setText(data1);
        txtpassword2.setText(data2);
    }
}
