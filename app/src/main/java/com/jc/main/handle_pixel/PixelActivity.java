package com.jc.main.handle_pixel;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import com.jc.main.R;
import com.jc.main.util.ImageHelper;

public class PixelActivity extends Activity {
    private ImageView mImageview1, mImageview2, mImageview3, mImageview4;
    private Bitmap mBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pixel);
        init();
    }

    private void init() {
        mImageview1 = (ImageView) findViewById(R.id.pixel_image1);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test2);
        mImageview1.setImageBitmap(mBitmap);
        mImageview2 = (ImageView) findViewById(R.id.pixel_image2);
        mImageview2.setImageBitmap(ImageHelper.handleImageNegative(mBitmap));
        mImageview3 = (ImageView) findViewById(R.id.pixel_image3);
        mImageview3.setImageBitmap(ImageHelper.handleImagePixelsOldPhoto(mBitmap));
        mImageview4 = (ImageView) findViewById(R.id.pixel_image4);
        mImageview4.setImageBitmap(ImageHelper.handleImagePixelsRelief(mBitmap));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBitmap.recycle();
        mBitmap = null;
    }
}
