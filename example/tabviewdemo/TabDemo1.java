package com.example.tabviewdemo;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.application1.R;

public class TabDemo1 extends AppCompatActivity implements TabLayout.OnTabSelectedListener{
    ViewPager viewpager;
    TabLayout tabLayout;
    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_demo1);

        viewpager = (ViewPager) findViewById(R.id.viewpage1);
        tabLayout = (TabLayout) findViewById(R.id.tablayout1);
        manager = getSupportFragmentManager();
        viewpager.setAdapter(new TabDemo1.adapter(manager));

        viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(this);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

        viewpager.setCurrentItem(tab.getPosition());

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    public class adapter extends FragmentPagerAdapter{

        public adapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment=null;
            if(i==0)
            {
                fragment = new TabFragmentDemo1();
            }
            if(i==1)
            {
                fragment = new TabFragmentDemo2();
            }
            if(i==2)
            {
                fragment = new TabFragmentDemo3();
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
