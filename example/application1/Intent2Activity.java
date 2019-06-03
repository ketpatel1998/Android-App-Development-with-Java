package com.example.application1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Intent2Activity extends AppCompatActivity {
    TextView txtshowname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent2);

        txtshowname = (TextView) findViewById(R.id.txtshowname);
        Intent in = getIntent();
        String data = in.getStringExtra("name");
        txtshowname.setText(data);
    }
}
