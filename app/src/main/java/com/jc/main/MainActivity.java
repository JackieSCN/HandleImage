package com.jc.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jc.main.handle_argb.PrimaryClass;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handleArgb(View view){
        startActivity(new Intent(this, PrimaryClass.class));
    }
}
