package com.jems.tuckar.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jems.tuckar.R;
import com.jems.tuckar.utils.SwitchActivity;

public class UserDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);
    }

    /****************    *****************/
    public void buyCreditsOnClick(View view) {
        SwitchActivity.moveTo(this, CreditsActivity.class);
    }

    /****************    *****************/
    public void accountSettingOnClick(View view) {
        SwitchActivity.moveTo(this, UserAccountSettingActivity.class);
    }

    /****************    *****************/
    public void savedOnClick(View view) {
        SwitchActivity.moveTo(this, SavedPropertiesProjectsActivity.class);
    }

    /****************    *****************/
    public void listingsOnClick(View view) {
        SwitchActivity.moveTo(this, ListingsActivity.class);
    }


    /****************    *****************/


    /****************    *****************/


    /****************    *****************/
}
