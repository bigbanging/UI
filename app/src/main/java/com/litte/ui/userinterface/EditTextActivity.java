package com.litte.ui.userinterface;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.litte.ui.R;
import com.litte.ui.view.MyEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EditTextActivity extends Activity {

    @BindView(R.id.username)
    MyEditText username;
    @BindView(R.id.password)
    MyEditText password;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_show_password)
    Button btnShowPassword;
    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        ButterKnife.bind(this);
        etPassword.setHorizontallyScrolling(true);//设置EditText不换行
        btnShowPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag == true){
                    etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    flag = false;
                    btnShowPassword.setText("密码不可见");
                }else {
                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    flag = true;
                    btnShowPassword.setText("密码可见");
                }
            }
        });
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        if (TextUtils.isEmpty(username.getText())) {
            //设置晃动---------------------------没有效果
            username.setShakeAnimation();
            //设置提示
            Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password.getText())) {
            password.setShakeAnimation();
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
    }
}
