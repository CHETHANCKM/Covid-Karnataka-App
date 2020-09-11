package com.cs.covid_19karnataka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.TextureView;
import android.view.View;
import android.widget.TextView;

public class no_connection extends AppCompatActivity {
    TextView tryagain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_connection);
        tryagain = findViewById(R.id.tryagain);


        tryagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(no_connection.this, MainActivity.class);
                startActivity(home);
            }
        });

    }
}