package com.statusbar_alexleo.alexstatusbarutils;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.statusbar_alexleo.alexstatusbarutilslib.AlexStatusBarUtils;

public class ImgStatusAct extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private boolean isImg1 = true;
    private CheckBox img_status_checkbox;
    private ImageView img_status_img;
    private Button img_status_change_img_btn, img_status_load_img_btn;
    private Toolbar img_status_toolbar;
    private TextView status_text;
    private SeekBar status_seek;
    private String progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_status);

        img_status_img = (ImageView) findViewById(R.id.img_status_img);
        img_status_toolbar = (Toolbar) findViewById(R.id.img_status_toolbar);
        img_status_change_img_btn = (Button) findViewById(R.id.img_status_change_img_btn);
        img_status_checkbox = (CheckBox) findViewById(R.id.img_status_checkbox);
        img_status_load_img_btn = (Button) findViewById(R.id.img_status_load_img_btn);
        status_text = (TextView) findViewById(R.id.status_text);
        status_seek = (SeekBar) findViewById(R.id.status_seek);
        setSupportActionBar(img_status_toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        progress = "" + status_seek.getProgress();
        status_text.setText(progress);
        status_seek.setOnSeekBarChangeListener(this);
        img_status_checkbox.setOnCheckedChangeListener(this);
        img_status_change_img_btn.setOnClickListener(this);
        img_status_load_img_btn.setOnClickListener(this);
        //--------------------------
        AlexStatusBarUtils.setImageViewTranslucent(this, 122);

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

        AlexStatusBarUtils.setImageViewTranslucent(this, progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_status_change_img_btn:
                isImg1 = !isImg1;
                if (isImg1)
                    img_status_img.setImageResource(R.mipmap.hzw2);
                else
                    img_status_img.setImageResource(R.mipmap.hzw1);
                break;
            case R.id.img_status_load_img_btn:
                Glide.with(this).load(Constant.IMG_URL).into(img_status_img);
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            AlexStatusBarUtils.setImageViewTransparent(this);
            status_seek.setEnabled(false);
        } else {
            AlexStatusBarUtils.setImageViewTranslucent(this, 122);
            status_seek.setEnabled(true);
        }
    }
}
