package com.jems.tuckar.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jems.tuckar.R;
import com.jems.tuckar.utils.CloseDialog;

public class InvestDialogFragment extends BottomSheetDialogFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setStyle(DialogFragment.STYLE_NO_TITLE, R.style.Animation_Design_BottomSheetDialog);
        //setStyle(DialogFragment.STYLE_NO_TITLE, R.style.Theme_Design_BottomSheetDialog);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_invest, container, false);
        getDialog().requestWindowFeature(STYLE_NO_TITLE);
        setCancelable(false);
        CloseDialog.onBackKey(getDialog());
        return view;
    }
}
