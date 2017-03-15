package com.statusbar_alexleo.alexstatusbarutils;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.statusbar_alexleo.alexstatusbarutils.fragment.ImgFragment;
import com.statusbar_alexleo.alexstatusbarutils.fragment.TextFragment;
import com.statusbar_alexleo.alexstatusbarutilslib.AlexStatusBarUtils;

import java.util.ArrayList;
import java.util.List;

public class FragmentAct extends AppCompatActivity {

    private ViewPager frag_vp;
    private BottomNavigationView frag_navigation;
    private ArrayList<Fragment> fragments;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    frag_vp.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    frag_vp.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    frag_vp.setCurrentItem(2);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        frag_navigation = (BottomNavigationView) findViewById(R.id.frag_navigation);
        frag_vp = (ViewPager) findViewById(R.id.frag_vp);
        frag_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fragments = new ArrayList<>();
        fragments.add(new ImgFragment());
        fragments.add(new TextFragment());
        fragments.add(new TextFragment());

        MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager(),fragments);
        frag_vp.setAdapter(myViewPagerAdapter);

        frag_vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                frag_navigation.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //--------------------------------------
        AlexStatusBarUtils.setTranslucentForImageViewInFragment(this,122);

    }

    private class MyViewPagerAdapter extends FragmentStatePagerAdapter{

        private List<Fragment> fragments;

        public MyViewPagerAdapter(FragmentManager fm,List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }

}
