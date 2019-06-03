package com.example.PersonalSkillDevelopment;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.application1.R;

public class ScinceKnowledgeActivity extends AppCompatActivity {

    PreferenceManagerPeskde preferenceManagerPeskde;

    Button button;
    Context context;
    TextView tvlevel;


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,home_peskde.class);
        startActivity(intent);
        finish();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scince_knowledge);

        context = this;
        preferenceManagerPeskde = new PreferenceManagerPeskde(this);

        tvlevel = (TextView) findViewById(R.id.lvlscince);

        String level2 = preferenceManagerPeskde.getLevelSharedPreference();
        tvlevel.setText("Level : "+level2);


        button = (Button) findViewById(R.id.btnscincequiz);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String level = preferenceManagerPeskde.getLevelSharedPreference();
                AsynctaskManagetScinceKnowledge asynctaskManagetScinceKnowledge = new AsynctaskManagetScinceKnowledge(context);
                asynctaskManagetScinceKnowledge.execute("questions",level);

            }
        });

    }
}
