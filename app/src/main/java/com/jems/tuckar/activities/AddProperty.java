package com.jems.tuckar.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jems.tuckar.R;

public class AddProperty extends AppCompatActivity {
    private TextView tvAddCustomTitle;
    private LinearLayout linearLayoutCustomTitle;
    private EditText etCustomTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_property);

        initViews();
    }

    /******************  Init View  ******************/
    private void initViews() {

        linearLayoutCustomTitle = findViewById(R.id.ll_custom_title);

        tvAddCustomTitle = findViewById(R.id.tv_add_custom_title);

        etCustomTitle = findViewById(R.id.et_custom_title);

    }

    /******************  Add Custom Title On Click  ******************/
    public void addCustomTitleOnClick(View view) {

        if (tvAddCustomTitle.getText().equals(getString(R.string.add_a_custom_title))) {
            tvAddCustomTitle.setText(R.string.use_tuckar_generated_title);
            linearLayoutCustomTitle.setVisibility(View.VISIBLE);
        } else {
            etCustomTitle.setText("");
            linearLayoutCustomTitle.setVisibility(View.GONE);
            tvAddCustomTitle.setText(R.string.add_a_custom_title);
        }
    }
}