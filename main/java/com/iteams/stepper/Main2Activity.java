package com.iteams.stepper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        TextView e=findViewById(R.id.email);
        TextView p=findViewById(R.id.password);
        TextView v=findViewById(R.id.vcode);


        Intent intent = getIntent();

        e.setText(intent.getStringExtra("email"));
        p.setText(intent.getStringExtra("password"));
        v.setText(intent.getStringExtra("verificationcode"));

    }
}
