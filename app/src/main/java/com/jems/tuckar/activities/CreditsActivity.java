package com.jems.tuckar.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jems.tuckar.R;
import com.jems.tuckar.fragments.FragmentBuyCredits;
import com.jems.tuckar.fragments.FragmentCreditsHistory;

public class CreditsActivity extends AppCompatActivity {

    private Button btBuyCredits, btCreditsHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        initViews();
        showBuyCreditsFragment(null);
    }

    private void initViews() {
        btBuyCredits = findViewById(R.id.bt_buy_credits);
        btCreditsHistory = findViewById(R.id.bt_credits_history);
    }

    /*********  Show Buy Credits Fragment **********/
    public void showBuyCreditsFragment(View view) {

        btCreditsHistory.setBackgroundResource(R.color.transparent);
        btBuyCredits.setBackgroundResource(R.drawable.bg_view_on_click);

        FragmentBuyCredits fragment = new FragmentBuyCredits();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.ll_fragment_container, fragment).commit();
    }

    /**********  Show Credits History Fragment  **********/
    public void showCreditsHistoryFragment(View view) {

        btBuyCredits.setBackgroundResource(R.color.transparent);
        btCreditsHistory.setBackgroundResource(R.drawable.bg_view_on_click);

        FragmentCreditsHistory fragment = new FragmentCreditsHistory();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.ll_fragment_container, fragment).commit();
    }
}
