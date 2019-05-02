package com.jems.tuckar.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jems.tuckar.R;
import com.jems.tuckar.activities.MainActivity;
import com.jems.tuckar.activities.SplashScreenActivity;
import com.jems.tuckar.utils.CloseDialog;
import com.jems.tuckar.utils.SwitchActivity;

import static com.jems.tuckar.declarations.Tags.LOGOUT;

public class YesNoAlertDialogFragment extends DialogFragment implements View.OnClickListener {

    private Enum actionTag;
    private String alertMessage;

    public YesNoAlertDialogFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setting the dialog default min width
        setStyle(STYLE_NO_TITLE, R.style.Theme_AppCompat_Light_Dialog_MinWidth);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_yes_no_alert_dialog, null);
        TextView tvAlertMessage = view.findViewById(R.id.tv_alert_message);
        tvAlertMessage.setText(alertMessage);

        Button btNo, btYes;
        btNo = view.findViewById(R.id.bt_no);
        btYes = view.findViewById(R.id.bt_yes);

        btNo.setOnClickListener(this);
        btYes.setOnClickListener(this);

        setCancelable(false);
        CloseDialog.onBackKey(getDialog());
        getDialog().requestWindowFeature(STYLE_NO_TITLE);
        return view;
    }

    public void setActionTag(Enum actionTag) {
        this.actionTag = actionTag;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_no:
                SwitchActivity.moveTo(getActivity(), MainActivity.class);
                break;

            case R.id.bt_yes:
                if (actionTag == LOGOUT) {
                    SwitchActivity.moveTo(getActivity(), SplashScreenActivity.class);
                }
                break;
        }
    }
}
