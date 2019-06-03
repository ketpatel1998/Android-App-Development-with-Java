package com.example.PersonalSkillDevelopment;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.application1.R;

public class AnswersActivity extends AppCompatActivity {

    TextView tvquesion;
    Context context;
    TextView tvop1;
    TextView tvop2;
    TextView tvop3;
    TextView tvop4;
    TextView tvop5;
    TextView show1,show2;
    ImageView true1,true2,true3,true4,true5,false1,false2,false3,false4,false5;
    Button btnnextlvl;
    SharedPreferences sharedPreferences;
    PreferenceManagerPeskde preferenceManagerPeskde;
    TextView tvlevel;
    AsynctaskManagetScinceKnowledge asynctaskManagetScinceKnowledge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers);

        context = this;
        tvop1 = (TextView) findViewById(R.id.tvoption1);
        tvop2 = (TextView) findViewById(R.id.tvoption2);
        tvop3 = (TextView) findViewById(R.id.tvoption3);
        tvop4 = (TextView) findViewById(R.id.tvoption4);
        tvop5 = (TextView) findViewById(R.id.tvoption5);
        tvlevel = (TextView) findViewById(R.id.tvlevel);
        btnnextlvl = (Button) findViewById(R.id.btnnextlevel);
        show1 = (TextView) findViewById(R.id.tvshow1);
        show2 = (TextView) findViewById(R.id.tvshow2);

        true1 = (ImageView) findViewById(R.id.true1);
        true2 = (ImageView) findViewById(R.id.true2);
        true3 = (ImageView) findViewById(R.id.true3);
        true4 = (ImageView) findViewById(R.id.true4);
        true5 = (ImageView) findViewById(R.id.true5);
        false1 = (ImageView) findViewById(R.id.false1);
        false2 = (ImageView) findViewById(R.id.false2);
        false3 = (ImageView) findViewById(R.id.false3);
        false4 = (ImageView) findViewById(R.id.false4);
        false5 = (ImageView) findViewById(R.id.false5);

        preferenceManagerPeskde = new PreferenceManagerPeskde(this);
        String level = preferenceManagerPeskde.getLevelSharedPreference();
        tvlevel.setText("Level : "+level);


        sharedPreferences = getSharedPreferences("ANSWERS", Context.MODE_PRIVATE);
        String ans5 = sharedPreferences.getString("answer5","");
        String ans1 =sharedPreferences.getString("answer1","");
        String ans2 =sharedPreferences.getString("answer2","");
        String ans3 =sharedPreferences.getString("answer3","");
        String ans4 =sharedPreferences.getString("answer4","");




        String prefname = "QUESTION";
        final String[] canswer = new String[5];

        for(int j=0;j<5;j++)
        {
            String temp1 = prefname+j;

            sharedPreferences = getSharedPreferences(temp1, Context.MODE_PRIVATE);
            canswer[j] =sharedPreferences.getString("Answer","");
        }

        if(ans1.equals(canswer[0]))
        {
            true1.setVisibility(View.VISIBLE);
            tvop1.setText("1. "+ans1);
            tvop1.setTextColor(Color.parseColor("#3498db"));
            false1.setVisibility(View.GONE);
        }
        else
        {
            false1.setVisibility(View.VISIBLE);
            true1.setVisibility(View.GONE);
            tvop1.setText("1. "+ans1);
            tvop1.setTextColor(Color.RED);
            tvop1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tvop1.setText("1. "+canswer[0]);
                    tvop1.setTextColor(Color.parseColor("#3498db"));
                    false1.setVisibility(View.GONE);
                    true1.setVisibility(View.VISIBLE);

                }
            });
        }
        if(ans2.equals(canswer[1]))
        {
            tvop2.setText("2. "+ans2);
            tvop2.setTextColor(Color.parseColor("#3498db"));
            true2.setVisibility(View.VISIBLE);
            false2.setVisibility(View.GONE);


        }
        else
        {
            false2.setVisibility(View.VISIBLE);
            true2.setVisibility(View.GONE);
            tvop2.setText("2. "+ans2);
            tvop2.setTextColor(Color.RED);
            tvop2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tvop2.setText("2. "+canswer[1]);
                    tvop2.setTextColor(Color.parseColor("#3498db"));
                    false2.setVisibility(View.GONE);
                    true2.setVisibility(View.VISIBLE);

                }
            });
        }
        if(ans3.equals(canswer[2]))
        {
            tvop3.setText("3. "+ans1);
            tvop3.setTextColor(Color.parseColor("#3498db"));
            true3.setVisibility(View.VISIBLE);
            false3.setVisibility(View.GONE);
        }
        else
        {
            false3.setVisibility(View.VISIBLE);
            true3.setVisibility(View.GONE);
            tvop3.setText("3. "+ans3);
            tvop3.setTextColor(Color.RED);
            tvop3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tvop3.setText("3. "+canswer[2]);
                    tvop3.setTextColor(Color.parseColor("#3498db"));
                    false3.setVisibility(View.GONE);
                    true3.setVisibility(View.VISIBLE);

                }
            });
        }
        if(ans4.equals(canswer[3]))
        {
            tvop4.setText("4. "+ans4);
            tvop4.setTextColor(Color.parseColor("#3498db"));
            true4.setVisibility(View.VISIBLE);
            false4.setVisibility(View.GONE);
        }
        else
        {
            false4.setVisibility(View.VISIBLE);
            true4.setVisibility(View.GONE);
            tvop4.setText("4. "+ans4);
            tvop4.setTextColor(Color.RED);
            tvop4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tvop4.setText("4. "+canswer[3]);
                    tvop4.setTextColor(Color.parseColor("#3498db"));
                    false4.setVisibility(View.GONE);
                    true4.setVisibility(View.VISIBLE);

                }
            });
        }
        if(ans5.equals(canswer[4]))
        {
            tvop5.setText("5. "+ans5);
            tvop5.setTextColor(Color.parseColor("#3498db"));
            true5.setVisibility(View.VISIBLE);
            false5.setVisibility(View.GONE);
        }
        else
        {
            false5.setVisibility(View.VISIBLE);
            true5.setVisibility(View.GONE);
            tvop5.setText("5. "+ans5);
            tvop5.setTextColor(Color.RED);
            tvop5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tvop5.setText("5. "+canswer[4]);
                    tvop5.setTextColor(Color.parseColor("#3498db"));
                    false5.setVisibility(View.GONE);
                    true5.setVisibility(View.VISIBLE);

                }
            });
        }

        btnnextlvl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tvop1.getText().toString().equals(canswer[0]) && tvop2.getText().toString().equals(canswer[1]) && tvop3.getText().toString().equals(canswer[2]) && tvop4.getText().toString().equals(canswer[3]) && tvop5.getText().toString().equals(canswer[4]))
                {
                    asynctaskManagetScinceKnowledge = new AsynctaskManagetScinceKnowledge(context);
                    String level = preferenceManagerPeskde.getLevelSharedPreference();
                    String id = preferenceManagerPeskde.getUserIDSharedPrefrence();
                    int l = Integer.parseInt(level);
                    l = l + 1;
                    String lev = l+"";
                    asynctaskManagetScinceKnowledge.execute("updatelevel",lev,id);

                }
                else
                {
                    show2.setVisibility(View.VISIBLE);
                    show1.setVisibility(View.VISIBLE);
                }
            }
        });



    }
}
