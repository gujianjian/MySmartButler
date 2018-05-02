package com.example.joy.mysmartbutler.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.joy.mysmartbutler.MainActivity;
import com.example.joy.mysmartbutler.R;
import com.example.joy.mysmartbutler.application.BaseApplication;
import com.example.joy.mysmartbutler.utils.ShareUtils;
import com.example.joy.mysmartbutler.utils.StaticClass;
import com.example.joy.mysmartbutler.utils.Util;

import org.w3c.dom.Text;

/**
 * Created by joy on 2018/5/2.
 */

public class SplashActivity extends AppCompatActivity {

    private TextView splash_tv;
    private Handler mHandler=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case StaticClass.SPLASH_HANDLER__DELAY_MSG:
                    if(isFirst()){
                        Toast.makeText(SplashActivity.this, "aa", Toast.LENGTH_SHORT).show();
                        Intent guide = new Intent(SplashActivity.this, GuideActivity.class);
                        startActivity(guide);
                    }else{
                        Intent main = new Intent(SplashActivity.this, GuideActivity.class);
                        startActivity(main);
                    }
                    break;
            }
            return true;
        }
    });


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_layout);

        init();
    }

    private void init() {
        mHandler.sendEmptyMessageDelayed(StaticClass.SPLASH_HANDLER__DELAY_MSG, 2000);

        splash_tv = findViewById(R.id.splash_tv);
        Util.setTypeface(splash_tv);
    }




    /**
     * 判断是否是第一次启动app
     * @return
     */
    private boolean isFirst() {
        boolean isFirstIn = ShareUtils.getBooleanShare(this, StaticClass.SPLASH_IS_FIRST_IN, true);
        if (isFirstIn) {
            ShareUtils.putBooleanShare(this,StaticClass.SPLASH_IS_FIRST_IN,false);
            return true;
        }else{
            return false;
        }
    }

}
