package com.jems.tuckar.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jems.tuckar.R;
import com.jems.tuckar.fragments.FragmentBuyCredits;
import com.jems.tuckar.fragments.FragmentCreditsHistory;

public class CreditsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);


    }

    public void showBuyCreditsFragment(View view) {
        FragmentBuyCredits fragment = new FragmentBuyCredits();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.ll_fragment_container, fragment).commit();
    }

    public void showCreditsHistoryFragment(View view) {
        FragmentCreditsHistory fragment = new FragmentCreditsHistory();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.ll_fragment_container, fragment).commit();
    }
}
