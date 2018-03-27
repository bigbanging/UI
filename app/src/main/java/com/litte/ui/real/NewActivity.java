package com.litte.ui.real;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.litte.ui.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewActivity extends Activity {

    @BindView(R.id.btn_handler)
    Button btnHandler;
    @BindView(R.id.btn_ansyncTask)
    Button btnAnsyncTask;
    @BindView(R.id.btn_actvity)
    Button btnActvity;
    @BindView(R.id.btn_service)
    Button btnService;
    @BindView(R.id.btn_configuration)
    Button btnConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题拦
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_new);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_handler, R.id.btn_ansyncTask, R.id.btn_actvity, R.id.btn_service,R.id.btn_configuration})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_handler:
                startActivity(new Intent(this, HandlerActivity.class));
                break;
            case R.id.btn_ansyncTask:
                startActivity(new Intent(this,AsyncTaskActivity.class));
                break;
            case R.id.btn_actvity:
                startActivity(new Intent(this,ActivityActivity.class));
                break;
            case R.id.btn_service:
                startActivity(new Intent(this,ServiceActivity.class));
                break;

            case R.id.btn_configuration:
                startActivity(new Intent(this,ConfigurationActivity.class));
                break;
        }
    }
}
