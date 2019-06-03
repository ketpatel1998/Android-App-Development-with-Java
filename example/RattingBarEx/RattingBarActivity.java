package com.example.RattingBarEx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.application1.R;

public class RattingBarActivity extends AppCompatActivity {

    RatingBar rt ;
    Button bt ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratting_bar);
        rt = (RatingBar) findViewById(R.id.rtb1);
        bt = (Button) findViewById(R.id.btnsubmit);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = String.valueOf(rt.getRating());
                Toast.makeText(RattingBarActivity.this, data, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
