package com.litte.ui.real;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.litte.ui.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BindServiceActivity extends Activity {

    private static final String TAG = "BIND_SERVICE";
    @BindView(R.id.btn_bind_service)
    Button btnBindService;
    @BindView(R.id.btn_unbind_service)
    Button btnUnbindService;
    @BindView(R.id.btn_check_status)
    Button btnCheckStatus;
    private Intent intent;

    TestService1.MyBinder binder;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i(TAG, "onServiceConnected: ");
            binder = (TestService1.MyBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG, "onServiceDisconnected: ");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_service);
        ButterKnife.bind(this);
        intent = new Intent(this, TestService1.class);
        intent.setAction("com.litter.TEST_SERVICE1");
    }

    @OnClick({R.id.btn_bind_service, R.id.btn_unbind_service, R.id.btn_check_status})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_bind_service:
                bindService(intent, connection, BIND_AUTO_CREATE);
                break;
            case R.id.btn_unbind_service:
                unbindService(connection);
                break;
            case R.id.btn_check_status:
                Toast.makeText(this, "ServiceTest1的count值"+binder.getCount(), Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
