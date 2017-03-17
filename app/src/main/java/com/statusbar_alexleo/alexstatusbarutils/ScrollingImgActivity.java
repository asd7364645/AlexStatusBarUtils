package com.statusbar_alexleo.alexstatusbarutils;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.statusbar_alexleo.alexstatusbarutilslib.AlexStatusBarUtils;

public class ScrollingImgActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private CoordinatorLayout scrolling_img_coor;
    private AppBarLayout scrolling_img_app_bar;
    private ImageView scrolling_img_img;

    private CollapsingToolbarLayout scrolling_img_coll_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling_img);
        toolbar = (Toolbar) findViewById(R.id.scrolling_img_toolbar);
        scrolling_img_coll_layout = (CollapsingToolbarLayout) findViewById(R.id.scrolling_img_coll_layout);
        scrolling_img_coor = (CoordinatorLayout) findViewById(R.id.scrolling_img_coor);
        scrolling_img_app_bar = (AppBarLayout) findViewById(R.id.scrolling_img_app_bar);
        scrolling_img_img = (ImageView) findViewById(R.id.scrolling_img_img);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });

        Glide.with(this).load(Constant.IMG_URL).into(scrolling_img_img);

        AlexStatusBarUtils.setCollapsingToolbar(this, scrolling_img_coor, scrolling_img_app_bar, scrolling_img_img, toolbar);

//        AlexStatusBarUtils.setCollapsingToolbar(this,toolbar,scrolling_img_coll_layout);



    }

    private static int getStatusBarHeight(Activity activity) {
        int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return activity.getResources().getDimensionPixelSize(resourceId);
    }
}
