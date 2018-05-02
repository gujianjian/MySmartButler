package com.example.joy.mysmartbutler.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.example.joy.mysmartbutler.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joy on 2018/5/2.
 * 项目名   MySmartButler
 * 简介
 */

public class GuideActivity extends AppCompatActivity{

    private ViewPager mViewPager;
    private View view1,view2,view3;
    private List<View> mListView = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_layout);

        initView();
    }

    private void initView() {
        view1 = View.inflate(this, R.layout.guide_viewpage_item1, null);
        view2 = View.inflate(this, R.layout.guide_viewpage_item2, null);
        view3 = View.inflate(this, R.layout.guide_viewpage_item3, null);

        mListView.add(view1);
        mListView.add(view2);
        mListView.add(view3);


        mViewPager = findViewById(R.id.viewPager_guide);

        mViewPager.setAdapter(new GuideAdapter());
    }


    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }

    private class GuideAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return mListView.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mListView.get(position));
            return mListView.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mListView.get(position));
        }
    }
}
