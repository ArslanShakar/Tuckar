package com.jems.tuckar.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jems.tuckar.R;
import com.jems.tuckar.utils.CloseDialog;

public class BuyOrRentPropertyDialogFragment extends BottomSheetDialogFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_buy_or_rent_property, container, false);
        getDialog().requestWindowFeature(STYLE_NO_TITLE);
        setCancelable(false);

        CloseDialog.onBackKey(getDialog());

      /*  Window window = getDialog().getWindow();
        window.setGravity(Gravity.BOTTOM);*/
       /* getDialog().getWindow().setGravity(Gravity.BOTTOM);  */

        return view;
    }

}
