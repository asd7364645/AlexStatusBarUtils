package com.statusbar_alexleo.alexstatusbarutils;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.statusbar_alexleo.alexstatusbarutilslib.AlexStatusBarUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    private ActionBarDrawerToggle toggle;
    private NavigationView main_navigation;
    private DrawerLayout main_drawer;
    private Toolbar main_toolbar;
    private Button main_common_toolbar_btn, main_img_act_btn, main_scroll_tb_act_btn;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_common_toolbar_btn = (Button) findViewById(R.id.main_common_toolbar_btn);
        main_drawer = (DrawerLayout) findViewById(R.id.main_drawer);
        main_navigation = (NavigationView) findViewById(R.id.main_navigation);
        main_img_act_btn = (Button) findViewById(R.id.main_img_act_btn);
        main_scroll_tb_act_btn = (Button) findViewById(R.id.main_scroll_tb_act_btn);
        main_toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(main_toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toggle = new ActionBarDrawerToggle(this,main_drawer,main_toolbar,R.string.open,R.string.close);
        main_drawer.addDrawerListener(toggle);
        toggle.syncState();
        main_common_toolbar_btn.setOnClickListener(this);
        main_img_act_btn.setOnClickListener(this);
        main_scroll_tb_act_btn.setOnClickListener(this);
        main_navigation.setNavigationItemSelectedListener(this);

        //----------------------------------
        AlexStatusBarUtils.setDrawerStatusColor(this,122);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_common_toolbar_btn:
                intent = new Intent(this, CommonToolbarAct.class);
                startActivity(intent);
                break;
            case R.id.main_scroll_tb_act_btn:
                intent = new Intent(this, ScrollToolBarAct.class);
                startActivity(intent);
                break;
            case R.id.main_img_act_btn:
                intent = new Intent(this, ImgStatusAct.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }
}
