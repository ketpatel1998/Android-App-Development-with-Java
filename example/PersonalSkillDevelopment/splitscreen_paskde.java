package com.example.PersonalSkillDevelopment;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.application1.R;

public class splitscreen_paskde extends AppCompatActivity {


    ImageView imageView;
    TextView textViewheader;
    TextView textViewdescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splitscreen_paskde);

        imageView = (ImageView) findViewById(R.id.imglogosplit);
        textViewheader = (TextView) findViewById(R.id.titlesplit);
        textViewdescription = (TextView) findViewById(R.id.descriptionsplit);

        Animation moveanimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);

        textViewdescription.setAnimation(moveanimation);

        Animation blinkanimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);

        textViewheader.setAnimation(blinkanimation);

        Animation zoomanimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom);

        imageView.setAnimation(zoomanimation);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splitscreen_paskde.this,home_peskde.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }
}
