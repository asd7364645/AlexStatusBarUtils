package com.statusbar_alexleo.alexstatusbarutils;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.statusbar_alexleo.alexstatusbarutilslib.AlexStatusBarUtils;

public class ScrollToolBarAct extends AppCompatActivity {

    private Toolbar scroll_tb_tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_tool_bar);
        scroll_tb_tb = (Toolbar) findViewById(R.id.scroll_tb_tb);
        setSupportActionBar(scroll_tb_tb);

        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }

        AlexStatusBarUtils.setStatusColor(this, ContextCompat.getColor(this,R.color.colorPrimary));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
