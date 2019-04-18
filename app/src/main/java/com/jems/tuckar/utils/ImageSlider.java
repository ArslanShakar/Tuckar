package com.jems.tuckar.utils;

import android.content.Context;

import com.jems.tuckar.MainActivity;
import com.jems.tuckar.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

public class ImageSlider {
    public static void show(final Context mContext, SliderLayout sliderLayout)
    {
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.SLIDE);
        sliderLayout.setScrollTimeInSec(4);

        int[] imagesArray = {R.drawable.demo_img_one, R.drawable.demo_img_two, R.drawable.demo_img_one};

        for (int i = 0; i < imagesArray.length; i++) {
            DefaultSliderView sliderView = new DefaultSliderView(mContext);
            sliderView.setImageDrawable(imagesArray[i]);
            sliderView.setDescription("Image Description : " + (i + 1));

            final int finalI = i;
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    MMessage.toastShow(mContext, "Image : " + finalI);
                }
            });

            sliderLayout.addSliderView(sliderView);
        }
    }
}
