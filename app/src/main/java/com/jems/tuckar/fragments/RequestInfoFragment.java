package com.jems.tuckar.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jems.tuckar.R;
import com.jems.tuckar.utils.CloseDialog;

public class RequestInfoFragment extends DialogFragment {

    public RequestInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /* set style for open fragment in full screen just like an activity */
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.Animation_Design_BottomSheetDialog);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_request_info, container, false);
        //getDialog().requestWindowFeature(STYLE_NO_TITLE);
        setCancelable(false);
        CloseDialog.onBackKey(getDialog());
        return view;
    }

}
