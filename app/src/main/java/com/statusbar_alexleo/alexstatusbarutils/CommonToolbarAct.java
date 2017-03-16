package com.statusbar_alexleo.alexstatusbarutils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.statusbar_alexleo.alexstatusbarutilslib.AlexStatusBarUtils;

public class CommonToolbarAct extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private RelativeLayout cmn_rl;
    private Toolbar cmn_toolbar;
    private TextView status_text;
    private SeekBar status_seek;
    private String progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_toolbar);

        cmn_rl = (RelativeLayout) findViewById(R.id.cmn_rl);
        cmn_toolbar = (Toolbar) findViewById(R.id.cmn_toolbar);
        status_text = (TextView) findViewById(R.id.status_text);
        status_seek = (SeekBar) findViewById(R.id.status_seek);
        setSupportActionBar(cmn_toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        progress = "" + status_seek.getProgress();
        status_text.setText(progress);

        status_seek.setOnSeekBarChangeListener(this);

        //------------------------------------
        AlexStatusBarUtils.setStatusColor(this, getResources().getColor(R.color.colorAccent), 122);
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

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        this.progress = progress + "";
        status_text.setText(this.progress);
        AlexStatusBarUtils.setStatusColor(this, getResources().getColor(R.color.colorAccent), progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

}
