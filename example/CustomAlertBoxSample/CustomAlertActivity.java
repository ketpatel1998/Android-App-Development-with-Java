package com.example.CustomAlertBoxSample;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.application1.R;

public class CustomAlertActivity extends AppCompatActivity {

    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_alert);
        context = this;

;    }

    public void custom_dialog(View view) {
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View myview = inflater.inflate(R.layout.raw_activity,null);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setView(myview);
        builder.setTitle("Dialog Box");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "Yes", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void taskcalled(View view) {

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View myview = inflater.inflate(R.layout.custombox_task1,null);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(myview);
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    public void perfectone(View view) {

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View myview = inflater.inflate(R.layout.activity_custom_alert_perfect,null);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(myview);
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }
}
