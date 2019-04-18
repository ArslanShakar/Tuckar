package com.jems.tuckar;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.jems.tuckar.utils.SwitchActivity;

public class SplashScreenActivity extends AppCompatActivity {

    private static boolean isLoggedIn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

    }

    private void checkUserSession() {
        if (isLoggedIn) {
            SwitchActivity.moveTo(SplashScreenActivity.this, MainActivity.class);
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    isLoggedIn = true;
                    SwitchActivity.moveTo(SplashScreenActivity.this, MainActivity.class);
                }
            }, 200);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        SwitchActivity.moveTo(SplashScreenActivity.this, SignupActivity.class);
        //checkUserSession();
    }
}
