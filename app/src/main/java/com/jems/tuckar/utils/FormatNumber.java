package com.jems.tuckar.utils;

import java.text.DecimalFormat;

public class FormatNumber {
    public static String toShortForm(float value) {
        String[] unitsArray = {"", "K", "M", "B", "T", "P", "E"};
        int index = 0;
        while ((value / 1000) >= 1) {
            value = value / 1000;
            index++;
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return String.format("%s %s", decimalFormat.format(value), unitsArray[index]);
    }
}
