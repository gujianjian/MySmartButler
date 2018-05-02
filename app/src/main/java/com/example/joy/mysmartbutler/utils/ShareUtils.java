package com.example.joy.mysmartbutler.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.widget.TextView;

import com.example.joy.mysmartbutler.application.BaseApplication;

/**
 * Created by joy on 2018/5/2.
 * share工具类
 */

public class ShareUtils {

    public static boolean getBooleanShare(Context context,String key,boolean defValue) {
        SharedPreferences sp = context.getSharedPreferences(StaticClass.SHARE_NAME, Context.MODE_PRIVATE);
        return sp.getBoolean(key, defValue);
    }

    public static void putBooleanShare(Context context,String key,boolean value) {
        SharedPreferences sp = context.getSharedPreferences(StaticClass.SHARE_NAME, Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, value).apply();
    }



}
