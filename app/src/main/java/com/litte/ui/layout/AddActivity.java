package com.litte.ui.layout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.litte.ui.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddActivity extends Activity {

    @BindView(R.id.iv_add)
    ImageView ivAdd;
    @BindView(R.id.iv_cancel)
    ImageView ivCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ButterKnife.bind(this);
        ivCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
