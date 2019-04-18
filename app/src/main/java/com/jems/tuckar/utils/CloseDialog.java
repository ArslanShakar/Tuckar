package com.jems.tuckar.utils;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;

public class CloseDialog {
    public static void onBackKey(Dialog mDialog) {
        mDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if (KeyEvent.KEYCODE_BACK == keyCode) {
                    dialog.dismiss();
                }
                return false;
            }
        });
    }
}
