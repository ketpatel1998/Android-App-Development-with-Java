package com.example.AlertDialogBoxExample;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.application1.R;

public class CustomAlertBoxActivity extends AppCompatActivity {

    Button btnalert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnalert = (Button) findViewById(R.id.btnalert);
        btnalert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CustomAlertBoxActivity.this);
                builder.setTitle("Alert Box");
                builder.setMessage("Choose Yes or No ");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(CustomAlertBoxActivity.this, "Yes selected", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(CustomAlertBoxActivity.this, "NO selected", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog ale = builder.create();
                ale.show();

            }
        });
    }
}
