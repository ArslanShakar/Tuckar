package com.jems.tuckar.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialogFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jems.tuckar.R;
import com.jems.tuckar.utils.CloseDialog;
import com.jems.tuckar.utils.MMessage;

public class PriceRangeFragment extends BottomSheetDialogFragment implements View.OnClickListener {

    public interface PriceRangeListener {
        void setPriceRange(long minPrice, long maxPrice);
    }

    private PriceRangeListener priceRangeListener;
    private EditText etMinPrice, etMaxPrice;

    public PriceRangeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        priceRangeListener = (PriceRangeListener) context;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_price_range, container, false);
        etMinPrice = view.findViewById(R.id.et_min_price);
        etMaxPrice = view.findViewById(R.id.et_max_price);

        TextView tvClose = view.findViewById(R.id.tv_close);
        tvClose.setOnClickListener(this);

        Button btDone = view.findViewById(R.id.bt_done);
        btDone.setOnClickListener(this);

        getDialog().requestWindowFeature(STYLE_NO_TITLE);
        setCancelable(false);
        CloseDialog.onBackKey(getDialog());
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_done: {
                long minPrice = 0;
                long maxPrice = 0;
                if (!TextUtils.isEmpty(etMinPrice.getText().toString())) {
                    minPrice = Long.parseLong(etMinPrice.getText().toString().trim());
                }
                if (!TextUtils.isEmpty(etMaxPrice.getText().toString())) {
                    maxPrice = Long.parseLong(etMaxPrice.getText().toString().trim());
                }
                if (minPrice > 0 && minPrice > maxPrice) {
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


}
