package com.jems.tuckar.utils;

import android.view.View;

import com.jems.tuckar.R;

public class ChangeBackground {
    public static void onClickView(View viewBackgroundChange, View viewBackgroundTransparent)
    {
        viewBackgroundChange.setBackgroundResource(R.drawable.bg_view_on_click);
        viewBackgroundTransparent.setBackgroundResource(R.color.transparent);
    }
}
