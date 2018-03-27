package com.litte.ui.real;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.litte.ui.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityActivity extends Activity {

    @BindView(R.id.ed_input_user)
    EditText edInputUser;
    @BindView(R.id.rb_man)
    RadioButton rbMan;
    @BindView(R.id.rb_woman)
    RadioButton rbWoman;
    @BindView(R.id.btn_register)
    Button btnRegister;
    @BindView(R.id.rg_gender)
    RadioGroup rgGender;

    RadioButton radioButton;
    @BindView(R.id.iv_weather)
    ImageView ivWeather;
    @BindView(R.id.btn_choice_weather)
    Button btnChoiceWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btn_register, R.id.btn_choice_weather})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_register:
                Intent intent = new Intent(this,Activity2Activity.class);
                String register = edInputUser.getText().toString();
                String gender = "";
                for (int i = 0; i < rgGender.getChildCount(); i++) {
                    radioButton = (RadioButton) rgGender.getChildAt(i);
                    if (radioButton.isChecked()){
                        gender = radioButton.getText().toString();
                        break;
                    }
                }
                Bundle bundle = new Bundle();
                bundle.putString("username",register);
                bundle.putString("sex",gender);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
                break;
            case R.id.btn_choice_weather:
                Intent intent1 = new Intent(this, WeatherIconActivity.class);
                int requestCode = 0x123;
                startActivityForResult(intent1,requestCode);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0x123 && resultCode == 0x123) {
            Bundle bundle = data.getExtras();
            int imgId = bundle.getInt("imgId");
            ivWeather.setImageResource(imgId);
        }
    }
}
