package com.litte.ui.userinterface;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.litte.ui.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RadioCheckActivity extends Activity implements CompoundButton.OnCheckedChangeListener {

    @BindView(R.id.rb_basketball)
    RadioButton rbBasketball;
    @BindView(R.id.rb_football)
    RadioButton rbFootball;
    @BindView(R.id.rb_volleyball)
    RadioButton rbVolleyball;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;
    @BindView(R.id.btn_submit)
    Button btnSubmit;

    @BindView(R.id.cb_one)
    CheckBox cbOne;
    @BindView(R.id.cb_two)
    CheckBox cbTwo;
    @BindView(R.id.cb_three)
    CheckBox cbThree;
    @BindView(R.id.cb_four)
    CheckBox cbFour;
    @BindView(R.id.cb_five)
    CheckBox cbFive;
    @BindView(R.id.btn_submit2)
    Button btnSubmit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_check);
        ButterKnife.bind(this);
        cbOne.setOnCheckedChangeListener(this);
        cbTwo.setOnCheckedChangeListener(this);
        cbThree.setOnCheckedChangeListener(this);
        cbFour.setOnCheckedChangeListener(this);
        cbFive.setOnCheckedChangeListener(this);
        btnSubmit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String choose = "";
                if (cbOne.isChecked())choose+=cbOne.getText().toString()+"  ";
                if (cbTwo.isChecked())choose+=cbTwo.getText().toString()+"  ";
                if (cbThree.isChecked())choose+=cbThree.getText().toString()+"  ";
                if (cbFour.isChecked())choose+=cbFour.getText().toString()+"  ";
                if (cbFive.isChecked())choose+=cbFive.getText().toString()+"  ";
                Toast.makeText(RadioCheckActivity.this, "你的选择包含了："+choose, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.btn_submit)
    public void onViewClicked() {
        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            RadioButton radioButton = (RadioButton) radioGroup.getChildAt(i);
            if (radioButton.isChecked()) {
                Toast.makeText(this, "你选择了：`" + radioButton.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Toast.makeText(this, "你选择了"+buttonView.getText().toString(), Toast.LENGTH_SHORT).show();
    }
}
