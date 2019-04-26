package com.jems.tuckar.utils;

import android.content.Context;
import android.widget.ImageView;

import com.jems.tuckar.R;
import com.squareup.picasso.Picasso;

public class ImageUtils {
    public static void setImage(Context context, String imgPath, ImageView imageView) {
        Picasso.with(context).
                load(imgPath).
                fit().
                centerCrop().
                placeholder(R.drawable.profile_default_image).
                error(R.drawable.profile_default_image).
                into(imageView);
    }
}
