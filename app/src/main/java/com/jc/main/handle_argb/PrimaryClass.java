package com.jc.main.handle_argb;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.jc.main.R;
import com.jc.main.util.ImageHelper;

public class PrimaryClass extends Activity implements SeekBar.OnSeekBarChangeListener {
    private static final int MAX_VALUE = 255;
    private static final int MID_VALUE = 127;
    private ImageView mImageview;
    private SeekBar mHueSeekbar, mSatSeekbar, mLumSeekbar;
    private float mHue, mSat, mLum;
    private Bitmap mBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primary);
        init();
    }

    private void init() {
        initImageview();
        mHueSeekbar = (SeekBar) findViewById(R.id.primary_hue_seekbar);
        mSatSeekbar = (SeekBar) findViewById(R.id.primary_sat_seekbar);
        mLumSeekbar = (SeekBar) findViewById(R.id.primary_lum_seekbar);
        mHueSeekbar.setMax(MAX_VALUE);
        mSatSeekbar.setMax(MAX_VALUE);
        mLumSeekbar.setMax(MAX_VALUE);
        mHueSeekbar.setProgress(MID_VALUE);
        mSatSeekbar.setProgress(MID_VALUE);
        mLumSeekbar.setProgress(MID_VALUE);
        mHueSeekbar.setOnSeekBarChangeListener(this);
        mSatSeekbar.setOnSeekBarChangeListener(this);
        mLumSeekbar.setOnSeekBarChangeListener(this);
    }

    private void initImageview() {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test3);
        mImageview = (ImageView) findViewById(R.id.handle_image);
        mImageview.setImageBitmap(mBitmap);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.primary_hue_seekbar:
                mHue = (progress - MID_VALUE) * 1.0f / MID_VALUE * 180;
                break;
            case R.id.primary_sat_seekbar:
                mSat = progress * 1.0f / MID_VALUE;
                break;
            case R.id.primary_lum_seekbar:
                mLum = progress * 1.0f / MID_VALUE;
                break;
        }
        mImageview.setImageBitmap(ImageHelper.getHandleImageForARGB(mBitmap, mHue, mSat, mLum));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBitmap.recycle();
        mBitmap = null;
    }
}
