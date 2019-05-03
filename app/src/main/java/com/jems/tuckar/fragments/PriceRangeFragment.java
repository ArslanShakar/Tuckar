package com.jems.tuckar.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialogFragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jems.tuckar.R;
import com.jems.tuckar.utils.CloseDialog;
import com.jems.tuckar.utils.FormatNumber;
import com.jems.tuckar.utils.MMessage;

public class PriceRangeFragment extends BottomSheetDialogFragment implements View.OnClickListener, TextWatcher {

    private TextView tvMinPrice, tvMaxPrice;

    public interface PriceRangeListener {
        void setPriceRange(float minPrice, float maxPrice);
    }

    private PriceRangeListener priceRangeListener;
    private EditText etMinPrice, etMaxPrice;

    public PriceRangeFragment() {
        // Required empty public constructor
    }


    /**********  on Attach  **********/
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        priceRangeListener = (PriceRangeListener) context;
    }

    /**********  on Create View  **********/
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_price_range, container, false);
        etMinPrice = view.findViewById(R.id.et_min_price);
        etMaxPrice = view.findViewById(R.id.et_max_price);

        TextView tvClose = view.findViewById(R.id.tv_close);
        tvMinPrice = view.findViewById(R.id.tv_min_price);
        tvMaxPrice = view.findViewById(R.id.tv_max_price);

        Button btDone = view.findViewById(R.id.bt_done);

        etMinPrice.addTextChangedListener(this);
        etMaxPrice.addTextChangedListener(this);
        tvClose.setOnClickListener(this);
        btDone.setOnClickListener(this);

        getDialog().requestWindowFeature(STYLE_NO_TITLE);
        setCancelable(false);
        CloseDialog.onBackKey(getDialog());
        return view;
    }

    /**********  Override onClick method  **********/
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_done: {
                float minPrice = 0;
                float maxPrice = 0;
                if (!TextUtils.isEmpty(etMinPrice.getText().toString())) {
                    minPrice = Float.parseFloat(etMinPrice.getText().toString().trim());
                }
                if (!TextUtils.isEmpty(etMaxPrice.getText().toString())) {
                    maxPrice = Float.parseFloat(etMaxPrice.getText().toString().trim());
                }
                if (maxPrice > 0 && minPrice > maxPrice) {
                    MMessage.toastShow(getContext(), R.string.minimum_price_cannot_greater);
                } else {
                    priceRangeListener.setPriceRange(minPrice, maxPrice);
                    dismiss();
                }
            }
            break;
            case R.id.tv_close:
                dismiss();
                break;
        }
    }


    /********** Implements Methods of TextWatcher ***********/
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    public void afterTextChanged(Editable s) {

        if(etMinPrice.isFocused())
        {
            if (etMinPrice.getText().length() > 0) {
                String convertedValue = FormatNumber.toShortForm(Float.parseFloat(etMinPrice.getText().toString()));
                tvMinPrice.setText(String.format("%s: %s", getString(R.string.rs), convertedValue));
            } else {
                tvMinPrice.setText("");
            }
        }else
        {
            if (etMaxPrice.getText().length() > 0) {
                String convertedValue = FormatNumber.toShortForm(Float.parseFloat(etMaxPrice.getText().toString()));
                tvMaxPrice.setText(String.format("%s: %s", getString(R.string.rs), convertedValue));
            } else {
                tvMaxPrice.setText("");
            }
        }

    }


}
