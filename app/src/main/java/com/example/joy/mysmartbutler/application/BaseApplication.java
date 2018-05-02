package com.example.joy.mysmartbutler.application;

import android.app.Application;
import android.content.Context;
import android.content.MutableContextWrapper;

/**
 * Created by joy on 2018/5/2.
 * 项目名   MySmartButler
 * 简介
 */

public class BaseApplication extends Application {
    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext=getApplicationContext();
    }

    public static Context getInstance(){
        return mContext;
    }
}
