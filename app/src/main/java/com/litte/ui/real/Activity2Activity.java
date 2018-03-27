package com.litte.ui.real;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.litte.ui.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Activity2Activity extends Activity {

    @BindView(R.id.tv_show_register_information)
    TextView tvShowRegisterInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String username = bundle.getString("username");
        String sex = bundle.getString("sex");
        tvShowRegisterInformation.setText("恭喜"+username+sex+"注册成功");
    }
}
