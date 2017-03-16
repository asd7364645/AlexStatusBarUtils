package com.statusbar_alexleo.alexstatusbarutils;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.statusbar_alexleo.alexstatusbarutilslib.AlexStatusBarUtils;

public class ScrollTbAndDlAct extends AppCompatActivity {

    private DrawerLayout scroll_tb_dl_drawer_layout;
    private CoordinatorLayout scroll_tb_dl_coor;
    private Toolbar scroll_tb_dl_toolbar;
    private NavigationView scroll_tb_dl_nv_view;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private TabLayout scroll_tb_dl_tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_tb_and_dl);
        scroll_tb_dl_toolbar = (Toolbar) findViewById(R.id.scroll_tb_dl_toolbar);
        scroll_tb_dl_tab = (TabLayout) findViewById(R.id.scroll_tb_dl_tab);
        scroll_tb_dl_drawer_layout = (DrawerLayout) findViewById(R.id.scroll_tb_dl_drawer_layout);
        scroll_tb_dl_nv_view = (NavigationView) findViewById(R.id.scroll_tb_dl_nv_view);
        scroll_tb_dl_coor = (CoordinatorLayout) findViewById(R.id.scroll_tb_dl_coor);

        setSupportActionBar(scroll_tb_dl_toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, scroll_tb_dl_drawer_layout, scroll_tb_dl_toolbar, R.string.open, R.string.close);
        scroll_tb_dl_drawer_layout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


        AlexStatusBarUtils.setDyeDrawerStatusTransparent(this, scroll_tb_dl_coor);

        scroll_tb_dl_tab.addTab(scroll_tb_dl_tab.newTab().setText("one"));
        scroll_tb_dl_tab.addTab(scroll_tb_dl_tab.newTab().setText("two"));
        scroll_tb_dl_tab.addTab(scroll_tb_dl_tab.newTab().setText("three"));
        scroll_tb_dl_tab.addTab(scroll_tb_dl_tab.newTab().setText("four"));

    }










}
