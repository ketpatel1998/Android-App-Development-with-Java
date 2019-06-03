package com.example.sharedPreferenceDemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.application1.R;

public class SetDataActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button btnsave;
    Button btnmove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_data);

        password = (EditText)findViewById(R.id.txt_password);
        username = (EditText) findViewById(R.id.txt_username);
        btnsave = (Button) findViewById(R.id.btnsave);
        btnmove = (Button) findViewById(R.id.btnmove);

    }

    public void move(View view) {
        Intent intent = new Intent(SetDataActivity.this,loadDataActiviry.class);
        startActivity(intent);
    }

    public void save(View view) {

        if(username.getText().toString().equals(""))
        {
            username.setError("Enter Username");
            Toast.makeText(this, "Enter the Username first", Toast.LENGTH_SHORT).show();

        }
        else {
            SharedPreferences sharedPreferences = getSharedPreferences("MyPref", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("key1", username.getText().toString());
            editor.putString("key2", password.getText().toString());
            editor.commit();

        }
    }
}
