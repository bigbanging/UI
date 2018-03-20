package com.litte.ui.layout;

import android.app.Activity;
import android.os.Bundle;

import com.litte.ui.R;

public class AbsoluteActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absolute);
    }
}
