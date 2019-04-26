package com.jems.tuckar.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.jems.tuckar.R;
import com.jems.tuckar.fragments.RequestInfoFragment;
import com.jems.tuckar.utils.OpenDefaultActivities;

public class ContactUsActivity extends AppCompatActivity implements View.OnClickListener {

    private FragmentManager manager;
    private TextView tvPhoneNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        initView();
        setViewsListeners();

        manager = getSupportFragmentManager();
    }

    /****************    Init View    ****************/
    private void initView() {
        tvPhoneNumber = findViewById(R.id.tv_phone_number);
    }

    /****************    Set Views Listeners    ****************/
    private void setViewsListeners()
    {
        tvPhoneNumber.setOnClickListener(this);
    }

    /****************         ****************/


    /****************         ****************/


    /****************          ****************/

    /****************     Request Info OnClick     ****************/
    public void requestInfoOnClick(View view) {
        RequestInfoFragment fragment = new RequestInfoFragment();
        fragment.show(manager, getString(R.string.tag));
    }

    /****************     Views onClick     ****************/
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_phone_number:
                OpenDefaultActivities.showNumberOnDialPad(this, view, tvPhoneNumber.getText().toString());
                break;
        }
    }
}
