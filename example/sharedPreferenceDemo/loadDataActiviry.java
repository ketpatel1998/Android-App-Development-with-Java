package com.example.sharedPreferenceDemo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.application1.R;

public class loadDataActiviry extends AppCompatActivity {
    TextView txt;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_data_activiry);

        txt = (TextView) findViewById(R.id.txtusername);
        btn = (Button) findViewById(R.id.btn_getdata);
    }

    public void getDAta(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPref",MODE_PRIVATE);
        String stl = sharedPreferences.getString("key1","")+sharedPreferences.getString("key2","");

        txt.setText(stl);

    }
}
