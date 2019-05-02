package com.jems.tuckar.utils;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.jems.tuckar.R;
import com.jems.tuckar.fragments.YesNoAlertDialogFragment;

public class DDialogShow {
    public static void yesOrNoDialogFragment(Context context, String message, Enum actionTag) {
        try {
            YesNoAlertDialogFragment fragment = new YesNoAlertDialogFragment();
            Activity activity = (Activity) context;
            FragmentManager manager = ((FragmentActivity) activity).getSupportFragmentManager();
            fragment.setActionTag(actionTag);
            fragment.setAlertMessage(message);
            fragment.show(manager, context.getString(R.string.tag));
        } catch (Exception ignored) {
        }
    }
}
