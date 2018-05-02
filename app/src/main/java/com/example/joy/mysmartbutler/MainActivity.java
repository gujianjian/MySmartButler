package com.example.joy.mysmartbutler;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.joy.mysmartbutler.fragment.ButlerFragment;
import com.example.joy.mysmartbutler.fragment.GirlFragment;
import com.example.joy.mysmartbutler.fragment.UserFragment;
import com.example.joy.mysmartbutler.fragment.WeChatFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<String> mListTitle = new ArrayList<>();
    private List<Fragment> mListFragment = new ArrayList<>();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //去除阴影
        getSupportActionBar().setElevation(0);

        initData();
        initView();
    }


    private void initData() {
        //添加tablayout的标签
        mListTitle.add(getString(R.string.string_butler));
        mListTitle.add(getString(R.string.string_girl));
        mListTitle.add(getString(R.string.string_wechat));
        mListTitle.add(getString(R.string.string_user));

        //添加各个fragment
        mListFragment.add(new ButlerFragment());
        mListFragment.add(new GirlFragment());
        mListFragment.add(new WeChatFragment());
        mListFragment.add(new UserFragment());
    }

    private void initView() {
        mViewPager = findViewById(R.id.mViewPager);
        mTabLayout = findViewById(R.id.mTabLayout);

        //预加载
        mViewPager.setOffscreenPageLimit(mListFragment.size());

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mListFragment.get(position);
            }

            @Override
            public int getCount() {
                return mListFragment.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mListTitle.get(position);
            }
        });

        mTabLayout.setupWithViewPager(mViewPager);
    }

}
