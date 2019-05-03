package com.jems.tuckar.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jems.tuckar.R;

public class SavedPropertiesProjectsActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btProjects, btProperties;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_properties_projects);

        initViews();
        setViewsListeners();
    }

    /******* Init Views *********/
    private void initViews() {
        btProjects = findViewById(R.id.bt_projects);
        btProperties = findViewById(R.id.bt_properties);
    }

    /******* Set Views Listeners *********/
    private void setViewsListeners() {
        btProperties.setOnClickListener(this);
        btProjects.setOnClickListener(this);
    }

    /*********** Implement View On Click Method ************/
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_properties:
                btProjects.setBackgroundResource(R.color.transparent);
                btProperties.setBackgroundResource(R.drawable.bg_view_on_click);
                break;

            case R.id.bt_projects:
                btProperties.setBackgroundResource(R.color.transparent);
                btProjects.setBackgroundResource(R.drawable.bg_view_on_click);
                break;
        }
    }
}
