package com.example.PersonalSkillDevelopment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.application1.R;

public class Question5Activity extends AppCompatActivity {

    TextView tvquesion;
    RadioButton tvop1;
    RadioButton tvop2;
    RadioButton tvop3;
    RadioButton tvop4;
    Button btnque1;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    RadioGroup radioGroup;
    RadioButton radioanswer;
    PreferenceManagerPeskde preferenceManagerPeskde;
    TextView tvlevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);
        tvquesion = (TextView)findViewById(R.id.tvquestion1);
        tvop1 = (RadioButton) findViewById(R.id.tvoption1);
        tvop2 = (RadioButton) findViewById(R.id.tvoption2);
        tvop3 = (RadioButton) findViewById(R.id.tvoption3);
        tvop4 = (RadioButton) findViewById(R.id.tvoption4);
        btnque1 = (Button)findViewById(R.id.btnquestion1);
        tvlevel = (TextView) findViewById(R.id.tvlevel);

        radioGroup = (RadioGroup) findViewById(R.id.rdgoption);

        preferenceManagerPeskde = new PreferenceManagerPeskde(this);
        String level = preferenceManagerPeskde.getLevelSharedPreference();
        tvlevel.setText("Level : "+level);


        sharedPreferences = getSharedPreferences("QUESTION4", Context.MODE_PRIVATE);
        tvquesion.setText(sharedPreferences.getString("Question",""));
        tvop1.setText(sharedPreferences.getString("Option1",""));
        tvop2.setText(sharedPreferences.getString("Option2",""));
        tvop3.setText(sharedPreferences.getString("Option3",""));
        tvop4.setText(sharedPreferences.getString("Option4",""));

        btnque1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int answerid = radioGroup.getCheckedRadioButtonId();
                radioanswer = (RadioButton) findViewById(answerid);
                SharedPreferences sharedPreferences2 = getSharedPreferences("ANSWERS", Context.MODE_PRIVATE);
                editor = sharedPreferences2.edit();
                editor.putString("answer5",radioanswer.getText().toString());
                editor.commit();

                Intent intent = new Intent(Question5Activity.this,AnswersActivity.class);
                startActivity(intent);

            }
        });
    }
}
