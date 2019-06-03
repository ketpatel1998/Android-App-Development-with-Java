package com.example.SplitScreenDemo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.NavigationDrowerDemo.Navi_Demo1;
import com.example.application1.R;

public class SplitScreenDemo1 extends AppCompatActivity {

    int time = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_split_screen_demo1);

         Handler handler = new Handler();
         handler.postDelayed(new Runnable() {
             @Override
             public void run() {
                 Intent intent = new Intent(SplitScreenDemo1.this, Navi_Demo1.class);
                 startActivity(intent);
                 finish();
             }
         },2000);
    }
}
