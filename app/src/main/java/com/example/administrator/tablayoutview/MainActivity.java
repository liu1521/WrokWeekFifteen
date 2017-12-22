package com.example.administrator.tablayoutview;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    String[] mTitle = new String[30];
    String[] mData = new String[30];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initData() {
        for (int i = 0; i < 30; i++) {
            mTitle[i] = "第" + (i + 1) + "个TAB";
            mData[i] = "第" + (i + 1) + "个TAB";
        }
    }

    private void initView() {
        TabLayout mTabLayout = findViewById(R.id.main_tablelayout);
        final ViewPager mViewPager = findViewById(R.id.viewpager);
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public CharSequence getPageTitle(int position) {
                return mTitle[position % mTitle.length];
            }

            @Override
            public Fragment getItem(int position) {
                TabFragment fragment = new TabFragment();
                fragment.setTitle(mData[position % mTitle.length]);
                return fragment;
            }

            @Override
            public int getCount() {
                return mTitle.length;
            }
        });
        mTabLayout.setupWithViewPager(mViewPager);

        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}