package com.example.Switch.Toggle.SeekBar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.application1.R;

public class Scroll_Seek_Switch extends AppCompatActivity {

    TextView txttoggle, txtseek, txtswitch;
    SeekBar seekbar;
    Switch switch1;
    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll__seek__switch);

        txtswitch = (TextView) findViewById(R.id.txtswitch);
        switch1 = (Switch) findViewById(R.id.switch1);
        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch1.isChecked()) {
                    txtswitch.setText("Switch is ON");
                }
                else
                {
                    txtswitch.setText("Switch is OFF");
                }

            }
        });
        txttoggle = (TextView) findViewById(R.id.txttoggle);
        toggleButton = (ToggleButton) findViewById(R.id.toggle1);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggleButton.isChecked())
                {
                    txttoggle.setText("Toggle is ON");
                }
                else
                {
                    txttoggle.setText("Toggle is OFF");
                }
            }
        });
        txtseek = (TextView) findViewById(R.id.txtseek);
        txtseek.setText("Hello There!");
        seekbar = (SeekBar) findViewById(R.id.seekbar1);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtseek.setTextSize(progress);
                Toast.makeText(Scroll_Seek_Switch.this, "Seekbar Progress", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
