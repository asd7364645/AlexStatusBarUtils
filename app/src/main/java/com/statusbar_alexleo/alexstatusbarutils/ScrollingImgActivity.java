package com.statusbar_alexleo.alexstatusbarutils;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling_img);
        toolbar = (Toolbar) findViewById(R.id.scrolling_img_toolbar);
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

    }
}
