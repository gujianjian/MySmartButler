package com.example.joy.mysmartbutler.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

import com.example.joy.mysmartbutler.application.BaseApplication;

/**
 * Created by joy on 2018/5/2.
 * 项目名   MySmartButler
 * 简介     通用方法类
 */

public class Util {

    //设置字体
    public static void setTypeface(TextView textView) {
        Typeface typeface = Typeface.createFromAsset(BaseApplication.getInstance().getAssets(), "fonts/FONT.TTF");
        textView.setTypeface(typeface);
    }
}
