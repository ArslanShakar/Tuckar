package com.jems.tuckar.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;

import com.jems.tuckar.R;

public class OpenDefaultActivities {

    /************** Phone Number Validation ****************/
    private static boolean isPhoneNumberValid(Context context, View view, String phoneNumber) {
        if (!TextUtils.isEmpty(phoneNumber)) {
            if (Patterns.PHONE.matcher(phoneNumber).matches()) {
                return true;
            } else {
                MMessage.snackBarShow(context, view, R.string.incorrect_phone_format);
            }
        } else {
            MMessage.snackBarShow(context, view, R.string.mobile_not_found);
        }
        return false;
    }

    public static void showNumberOnDialPad(Context context, View view, String phoneNumber) {
        if (isPhoneNumberValid(context, view, phoneNumber)) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_DIAL);
            intent.setData(Uri.parse(context.getString(R.string.uri_phone_call) + phoneNumber));
            context.startActivity(intent);
        }
    }
}
