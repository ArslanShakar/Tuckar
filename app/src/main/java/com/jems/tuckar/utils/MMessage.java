package com.jems.tuckar.utils;

import android.content.Context;
import android.widget.Toast;

public class MMessage {
    //////////////////////////////    Show TOAST Message      //////////////////////////////
    public static void toastShow(Context context, String message) {
        Toast.makeText(context, "\n" + message + "\n", Toast.LENGTH_SHORT).show();
    }

    public static void toastShow(Context context, int resId) {
        Toast.makeText(context,  resId , Toast.LENGTH_SHORT).show();
    }
}
