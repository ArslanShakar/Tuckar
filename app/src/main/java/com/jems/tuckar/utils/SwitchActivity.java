package com.jems.tuckar.utils;

import android.content.Context;
import android.content.Intent;

public class SwitchActivity {
    public static void moveTo(Context context, Class<?> T) {
        Intent intent = new Intent(context, T);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }
}
