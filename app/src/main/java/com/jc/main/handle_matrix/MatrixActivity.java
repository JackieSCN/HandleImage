package com.jc.main.handle_matrix;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.jc.main.R;

public class MatrixActivity extends Activity {
    private final int MATRIX_COUNT = 20;
    private ImageView mImageview;
    private GridLayout mGridGroup;
    private int mEdWidth, mEdHeight;
    private EditText[] mEdts = new EditText[20];
    private float[] mColorMatrix = new float[20];
    private Bitmap mBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix);
        init();
    }

    private void init() {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test2);
        mImageview = (ImageView) findViewById(R.id.matrix_image);
        mImageview.setImageBitmap(mBitmap);
        initGrid();
    }

    private void initGrid() {
        mGridGroup = (GridLayout) findViewById(R.id.matrix_grid);
        //矩阵分为4行5列总共20个格子
        mGridGroup.post(new Runnable() {
            @Override
            public void run() {
                mEdWidth = mGridGroup.getWidth() / 5;
                mEdHeight = mGridGroup.getHeight() / 4;
                addEdittexts();
                initMatrix();
            }
        });
    }

    public void btnChange(View view) {
        getMatrix();
        setImageMatrix();
    }

    public void btnReset(View view) {
        initMatrix();
        getMatrix();
        setImageMatrix();
    }

    /**
     * 动态添加 edittext 数组
     */
    private void addEdittexts() {
        for (int i = 0; i < MATRIX_COUNT; i++) {
            EditText edt = new EditText(MatrixActivity.this);
            mEdts[i] = edt;
            mGridGroup.addView(edt, mEdWidth, mEdHeight);
        }
    }

    /**
     * 初始化矩阵中的值
     */
    private void initMatrix() {
        for (int i = 0; i < MATRIX_COUNT; i++) {
            if (i % 6 == 0) {
                mEdts[i].setText(String.valueOf(1));
            } else {
                mEdts[i].setText(String.valueOf(0));
            }
        }
    }

    /**
     * 获得矩阵
     */
    private void getMatrix() {
        for (int i = 0; i < MATRIX_COUNT; i++) {
            mColorMatrix[i] = Float.valueOf(mEdts[i].getText().toString().trim());
        }
    }

    /**
     * 重新绘制
     */
    private void setImageMatrix() {
        Bitmap bmp = Bitmap.createBitmap(mBitmap.getWidth(), mBitmap.getHeight(),
                Bitmap.Config.ARGB_8888);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(mColorMatrix);

        Canvas canvas = new Canvas(bmp);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(mBitmap, 0, 0, paint);
        mImageview.setImageBitmap(bmp);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBitmap.recycle();
        mBitmap = null;
    }
}
