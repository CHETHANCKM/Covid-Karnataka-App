package com.cs.covid_19karnataka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.content.Context;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    private  static  int SPLASHSCREEN = 800;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

            ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

                if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                        connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED)
                {
                    Intent home = new Intent(MainActivity.this, home.class);
                    startActivity(home);
                }
                else
                {
                    Intent home = new Intent(MainActivity.this, no_connection.class);
                    startActivity(home);
                }

            }
        },SPLASHSCREEN);


    }
}