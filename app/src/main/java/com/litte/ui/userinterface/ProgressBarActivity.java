package com.litte.ui.userinterface;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.litte.ui.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProgressBarActivity extends Activity {

    @BindView(R.id.iv_progressbar)
    ImageView ivProgressbar;

    private AnimationDrawable animationDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        ButterKnife.bind(this);
        animationDrawable = (AnimationDrawable) ivProgressbar.getDrawable();
        ivProgressbar.postDelayed(new Runnable() {
            @Override
            public void run() {
               animationDrawable.start();
            }
        },170);
    }
}
