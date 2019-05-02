package com.jems.tuckar.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;

import com.jems.tuckar.R;
import com.jems.tuckar.fragments.PriceRangeFragment;

import java.util.Locale;

public class NewSearchActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, PriceRangeFragment.PriceRangeListener {

    private LinearLayout linearLayoutPropertyType;
    private TableLayout tableLayoutSelectPropertyType;
    private RadioGroup rgPropertyType;
    private TextView tvPropertyType, tvPropertySubType, tvPriceRange;
    private String selectedPropertyType;
    private Spinner spinnerPropertySubtype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_search);
        initViews();
        setViewsListeners();
    }

    /************* Init Views  *************/
    private void initViews() {
        linearLayoutPropertyType = findViewById(R.id.ll_property_type);
        tableLayoutSelectPropertyType = findViewById(R.id.table_layout_select_property_type);

        rgPropertyType = findViewById(R.id.rg_property_type);

        tvPropertyType = findViewById(R.id.tv_property_type);
        tvPropertySubType = findViewById(R.id.tv_property_subtype);
        tvPriceRange = findViewById(R.id.tv_price_range);

        spinnerPropertySubtype = findViewById(R.id.sp_property_subtype);
    }

    /************* Set Views Listeners *************/
    private void setViewsListeners() {
        rgPropertyType.setOnCheckedChangeListener(this);
    }

    /*************  linear layout Property Type OnClick *************/
    public void llPropertyTypeOnClick(View view) {
        linearLayoutPropertyType.setVisibility(View.GONE);
        tableLayoutSelectPropertyType.setVisibility(View.VISIBLE);
    }

    /************* Done Property Type Selection OnClick  *************/
    public void propertyTypeSelectionDoneOnClick(View view) {

        linearLayoutPropertyType.setVisibility(View.VISIBLE);

        if (selectedPropertyType.equals(getString(R.string.all_types))) {
            tvPropertyType.setText(R.string.any);
            tvPropertySubType.setText(R.string.any);
        } else {
            tvPropertyType.setText(selectedPropertyType);
            tvPropertySubType.setText(spinnerPropertySubtype.getSelectedItem().toString());
        }

        tableLayoutSelectPropertyType.setVisibility(View.GONE);
    }

    /************* Radio Group on Checked Changed *************/
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        spinnerPropertySubtype.setVisibility(View.VISIBLE);

        String[] propertySubtypeArray = new String[0];

        RadioButton radioButton = findViewById(checkedId);
        selectedPropertyType = radioButton.getText().toString();

        switch (checkedId) {
            case R.id.rb_residential:
                propertySubtypeArray = getResources().getStringArray(R.array.residential_property_types_array);
                break;

            case R.id.rb_plot:
                propertySubtypeArray = getResources().getStringArray(R.array.plot_property_types_array);
                break;

            case R.id.rb_commercial:
                propertySubtypeArray = getResources().getStringArray(R.array.commercial_property_types_array);
                break;

            case R.id.rb_all_types:
                spinnerPropertySubtype.setVisibility(View.GONE);
                break;
        }

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, propertySubtypeArray);
        spinnerPropertySubtype.setAdapter(spinnerArrayAdapter);
    }

    /************* Price Range On Click Show Price Range Fragment *************/
    public void priceRangeOnClick(View view) {
        FragmentManager manager = getSupportFragmentManager();
        PriceRangeFragment fragment = new PriceRangeFragment();
        fragment.show(manager, getString(R.string.tag));
    }

    /************* Implement Price Range Listener Method  *************/
    @Override
    public void setPriceRange(long minPrice, long maxPrice) {
        if (minPrice == 0 && maxPrice > 0) {
            tvPriceRange.setText(String.format(Locale.US, "%s: %d", getString(R.string.max), maxPrice));
        } else if (minPrice > 0 && maxPrice == 0) {
            tvPriceRange.setText(String.format(Locale.US, "%s: %d", getString(R.string.min), minPrice));
        } else if (minPrice > 0 || maxPrice > 0) {
            tvPriceRange.setText(String.format(Locale.US, "%s: %d \t%s: %d", getString(R.string.min), minPrice, getString(R.string.max), maxPrice));
        } else {
            tvPriceRange.setText(R.string.any);
        }
    }


    /*************   *************/

    /*************   *************/

    /*************   *************/

    /*************   *************/
}
