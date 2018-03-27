package com.litte.ui.real;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.litte.ui.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ServiceActivity extends Activity {

    @BindView(R.id.btn_start_service)
    Button btnStartService;
    @BindView(R.id.btn_stop_service)
    Button btnStopService;
    @BindView(R.id.bindService)
    Button bindService;
    @BindView(R.id.intentService)
    Button intentService;
    @BindView(R.id.btn_aidl)
    Button btnAidl;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        ButterKnife.bind(this);
        intent = new Intent(this, TestService.class);
        intent.setAction("com.litte.ui.real.TEST_SERVICE");
    }

    @OnClick({R.id.btn_start_service, R.id.btn_stop_service, R.id.bindService, R.id.intentService,R.id.btn_aidl})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_start_service:
                startService(intent);
                break;
            case R.id.btn_stop_service:
                stopService(intent);
                break;
            case R.id.bindService:
                startActivity(new Intent(this, BindServiceActivity.class));
                break;
            case R.id.intentService:
                startActivity(new Intent(this, IntentActivity.class));
                break;
            case R.id.btn_aidl:
                startActivity(new Intent(this,AIDLActivity.class));
                break;
        }
    }
}
