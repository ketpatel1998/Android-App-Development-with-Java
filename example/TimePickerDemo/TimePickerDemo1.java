package com.example.TimePickerDemo;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.application1.R;

import java.util.Calendar;

public class TimePickerDemo1 extends AppCompatActivity {
    EditText timepicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker_demo1);
        timepicker = (EditText) findViewById(R.id.timepicker1);


        timepicker.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {

                    Calendar calendar = Calendar.getInstance();
                    int hour = calendar.get(Calendar.HOUR_OF_DAY);
                    int min = calendar.get(Calendar.MINUTE);

                    TimePickerDialog timePickerDialog = new TimePickerDialog(TimePickerDemo1.this, new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            timepicker.setText(hourOfDay+":"+minute);
                        }
                    },hour,min,true);


                    timePickerDialog.setTitle("Pick Time");
                    timePickerDialog.show();
                }
            }
        });

    }
}
