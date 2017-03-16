package com.statusbar_alexleo.alexstatusbarutils;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;

import com.statusbar_alexleo.alexstatusbarutilslib.AlexStatusBarUtils;

public class TranDrawerStatusAct extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, CompoundButton.OnCheckedChangeListener {

    private DrawerLayout tran_drawer_drawer;
    private Toolbar tran_drawer_toolbar;
    private ActionBarDrawerToggle toggle;
    private CheckBox tran_drawer_cb;
    private SeekBar tran_drawer_A_seek,
            tran_drawer_R_seek,
            tran_drawer_G_seek,
            tran_drawer_B_seek;
    private int a,r,g,b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tran_drawer_status);
        findviews();

        toggle = new ActionBarDrawerToggle(this, tran_drawer_drawer, tran_drawer_toolbar, R.string.open, R.string.close);
        toggle.syncState();
        bindEvent();
        AlexStatusBarUtils.setStatusAlphaForDrawer(this, tran_drawer_drawer, tran_drawer_toolbar, 122);

    }

    private void bindEvent() {
        tran_drawer_drawer.addDrawerListener(toggle);
        tran_drawer_cb.setOnCheckedChangeListener(this);
        tran_drawer_A_seek.setOnSeekBarChangeListener(this);
        tran_drawer_R_seek.setOnSeekBarChangeListener(this);
        tran_drawer_G_seek.setOnSeekBarChangeListener(this);
        tran_drawer_B_seek.setOnSeekBarChangeListener(this);
    }

    private void findviews() {
        tran_drawer_drawer = (DrawerLayout) findViewById(R.id.tran_drawer_drawer);
        tran_drawer_toolbar = (Toolbar) findViewById(R.id.tran_drawer_toolbar);
        tran_drawer_cb = (CheckBox) findViewById(R.id.tran_drawer_cb);
        tran_drawer_A_seek = (SeekBar) findViewById(R.id.tran_drawer_A_seek);
        tran_drawer_R_seek = (SeekBar) findViewById(R.id.tran_drawer_R_seek);
        tran_drawer_G_seek = (SeekBar) findViewById(R.id.tran_drawer_G_seek);
        tran_drawer_B_seek = (SeekBar) findViewById(R.id.tran_drawer_B_seek);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()){
            case R.id.tran_drawer_A_seek:
                a = progress;
                AlexStatusBarUtils.setStatusARGBForDrawer(this,tran_drawer_drawer,tran_drawer_toolbar,r,g,b,a);
                break;
            case R.id.tran_drawer_R_seek:
                r = progress;
                AlexStatusBarUtils.setStatusARGBForDrawer(this,tran_drawer_drawer,tran_drawer_toolbar,r,g,b,a);
                break;
            case R.id.tran_drawer_G_seek:
                g = progress;
                AlexStatusBarUtils.setStatusARGBForDrawer(this,tran_drawer_drawer,tran_drawer_toolbar,r,g,b,a);
                break;
            case R.id.tran_drawer_B_seek:
                b = progress;
                AlexStatusBarUtils.setStatusARGBForDrawer(this,tran_drawer_drawer,tran_drawer_toolbar,r,g,b,a);
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked){
            AlexStatusBarUtils.setTransparentStatusForDrawer(this,tran_drawer_drawer,tran_drawer_toolbar);
            tran_drawer_A_seek.setEnabled(false);
                    tran_drawer_R_seek.setEnabled(false);
            tran_drawer_G_seek.setEnabled(false);
                    tran_drawer_B_seek.setEnabled(false);
        }else {
            AlexStatusBarUtils.setStatusARGBForDrawer(this,tran_drawer_drawer,tran_drawer_toolbar,r,g,b,a);
            tran_drawer_A_seek.setEnabled(true);
            tran_drawer_R_seek.setEnabled(true);
            tran_drawer_G_seek.setEnabled(true);
            tran_drawer_B_seek.setEnabled(true);
        }
    }
}
