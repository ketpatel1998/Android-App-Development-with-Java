package com.example.AnimationActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.application1.R;

public class AnimationDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_demo);

        ImageView img = (ImageView) findViewById(R.id.imgmove1);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
        img.setAnimation(animation);

    }
}
