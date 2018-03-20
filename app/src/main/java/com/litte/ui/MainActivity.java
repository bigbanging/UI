package com.litte.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.litte.ui.layout.AbsoluteActivity;
import com.litte.ui.layout.FrameActivity;
import com.litte.ui.layout.GridActivity;
import com.litte.ui.layout.LinearActivity;
import com.litte.ui.layout.RelativeActivity;
import com.litte.ui.layout.TableActivity;
import com.litte.ui.userinterface.EditTextActivity;
import com.litte.ui.userinterface.TextViewActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @BindView(R.id.btn_linearlayout)
    Button btnLinearlayout;
    @BindView(R.id.btn_relativelayout)
    Button btnRelativelayout;
    @BindView(R.id.btn_tablelayout)
    Button btnTablelayout;
    @BindView(R.id.btn_framelayout)
    Button btnFramelayout;
    @BindView(R.id.btn_absolutelayout)
    Button btnAbsolutelayout;
    @BindView(R.id.btn_gridelayout)
    Button btnGridelayout;
    @BindView(R.id.btn_textView)
    Button btnTextView;
    @BindView(R.id.btn_editText)
    Button btnEditText;
    @BindView(R.id.btn_button)
    Button btnButton;
    @BindView(R.id.btn_imageView)
    Button btnImageView;
    @BindView(R.id.btn_radioButton_checkBox)
    Button btnRadioButtonCheckBox;
    @BindView(R.id.btn_toggleButton_switch)
    Button btnToggleButtonSwitch;
    @BindView(R.id.btn_progressBar)
    Button btnProgressBar;
    @BindView(R.id.btn_seekBar)
    Button btnSeekBar;
    @BindView(R.id.btn_ratingBar)
    Button btnRatingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_linearlayout, R.id.btn_relativelayout, R.id.btn_tablelayout, R.id.btn_framelayout, R.id.btn_absolutelayout, R.id.btn_gridelayout,
            R.id.btn_textView, R.id.btn_editText, R.id.btn_button, R.id.btn_imageView, R.id.btn_radioButton_checkBox, R.id.btn_toggleButton_switch, R.id.btn_progressBar, R.id.btn_seekBar, R.id.btn_ratingBar})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            /*Android 中的6大布局*/
            case R.id.btn_linearlayout:
                startActivity(new Intent(this, LinearActivity.class));
                break;
            case R.id.btn_relativelayout:
                startActivity(new Intent(this, RelativeActivity.class));
                break;
            case R.id.btn_tablelayout:
                startActivity(new Intent(this, TableActivity.class));
                break;
            case R.id.btn_framelayout:
                startActivity(new Intent(this, FrameActivity.class));
                break;
            case R.id.btn_absolutelayout:
                startActivity(new Intent(this, AbsoluteActivity.class));
                break;
            case R.id.btn_gridelayout:
                startActivity(new Intent(this, GridActivity.class));
                break;

            /*Android中的UI控件*/
            case R.id.btn_textView:
                startActivity(new Intent(this, TextViewActivity.class));
                break;
            case R.id.btn_editText:
                startActivity(new Intent(this, EditTextActivity.class));
                break;
            case R.id.btn_button:
                break;
            case R.id.btn_imageView:
                break;
            case R.id.btn_radioButton_checkBox:
                break;
            case R.id.btn_toggleButton_switch:
                break;
            case R.id.btn_progressBar:
                break;
            case R.id.btn_seekBar:
                break;
            case R.id.btn_ratingBar:
                break;
        }
    }

}
