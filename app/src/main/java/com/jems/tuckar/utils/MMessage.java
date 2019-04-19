package com.jems.tuckar.utils;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jems.tuckar.R;

public class MMessage {
    //////////////////////////////    Show TOAST Message      //////////////////////////////
    public static void toastShow(Context context, String message) {
        Toast.makeText(context, "\n" + message + "\n", Toast.LENGTH_SHORT).show();
    }

    public static void toastShow(Context context, int resId) {
        Toast.makeText(context, resId, Toast.LENGTH_SHORT).show();
    }

    public static void snackBarShow(Context context, View view, String message) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG).setAction(R.string.dismiss, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do nothing
            }
        }).setActionTextColor(context.getResources().getColor(R.color.colorAccent));

        setSnackBarTextColor(context, snackbar);
    }

    public static void snackBarShow(Context context, View view, int messageResId) {
        Snackbar snackbar = Snackbar.make(view, messageResId, Snackbar.LENGTH_LONG).setAction(R.string.dismiss, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do nothing
            }
        }).setActionTextColor(context.getResources().getColor(R.color.colorAccent));

        setSnackBarTextColor(context, snackbar);
    }

    private static void setSnackBarTextColor(Context context, Snackbar snackBar)
    {
        //Change snackBar text color
        View snackBarView = snackBar.getView();
        TextView textView = snackBarView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(context.getResources().getColor(R.color.white));
        snackBar.show();
    }
}
