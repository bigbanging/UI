package com.litte.ui.userinterface;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ViewFlipper;

import com.litte.ui.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewFlipperActivity extends Activity {

    @BindView(R.id.viewFlipper)
    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flipper);
        ButterKnife.bind(this);
        viewFlipper.startFlipping();
    }
}
