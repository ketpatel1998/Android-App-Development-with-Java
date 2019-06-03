package com.example.FragmentExample;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.application1.R;

public class Fragment_Activity1 extends AppCompatActivity {
    BlankFragment1 blankfragment1;
    BlankFragment2 blankFragment2;
    FragmentManager manager;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_1);
        manager = getSupportFragmentManager();


    }

    public void click1(View view) {
        blankfragment1 = new BlankFragment1();
        transaction = manager.beginTransaction();
        transaction.add(R.id.frame1,blankfragment1,"A");
        transaction.addToBackStack("click1");
        transaction.commit();
    }

    public void click2(View view) {
        blankFragment2 = new BlankFragment2();
        transaction = manager.beginTransaction();
        transaction.add(R.id.frame1,blankFragment2,"B");
        transaction.addToBackStack("click2");
        transaction.commit();

    }
}
