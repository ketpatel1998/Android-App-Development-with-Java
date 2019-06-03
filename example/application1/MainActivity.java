package com.example.application1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtname ;
    Button btnclick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnclick = (Button) findViewById(R.id.btnclick);
        txtname = (EditText) findViewById(R.id.txtname);

        btnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = txtname.getText().toString();
                if(txtname.length()==0)
                {
                    txtname.setError("Please Enter the Name Field");
                }
                else
                {
                    Intent intent = new Intent(MainActivity.this,Intent2Activity.class);
                    intent.putExtra("name",data);
                    startActivity(intent);
                }
                //Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
