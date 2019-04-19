package com.jems.tuckar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jems.tuckar.utils.SwitchActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void createAccountOnClick(View view) {
        SwitchActivity.moveTo(this, SignupActivity.class);
    }

    public void backArrowOnClick(View view) {
        onBackPressed();
    }
}
