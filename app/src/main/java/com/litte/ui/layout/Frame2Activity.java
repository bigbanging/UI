package com.litte.ui.layout;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import com.litte.ui.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Frame2Activity extends Activity {

    @BindView(R.id.frame2)
    FrameLayout frame2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame2);
        ButterKnife.bind(this);
        final MeiziView meiziView = new MeiziView(this);
        //为图片添加事件监听事件
        meiziView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                meiziView.bitmapX = event.getX()-150;
                meiziView.bitmapY = event.getY()-150;
                //调用重绘方法
                meiziView.invalidate();
                return true;
            }
        });
        frame2.addView(meiziView);
    }
}
