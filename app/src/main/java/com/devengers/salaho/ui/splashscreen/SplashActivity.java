package com.devengers.salaho.ui.splashscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import com.devengers.salaho.MainActivity;
import com.devengers.salaho.R;

public class SplashActivity extends Activity {

    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashfile);
        handler=new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this, MainActivity.class);
                SplashActivity.this.startActivity(intent);
                SplashActivity.this.finish();
            }
        },1000);


    }
}