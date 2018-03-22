package com.litte.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.litte.ui.layout.AbsoluteActivity;
import com.litte.ui.layout.FrameActivity;
import com.litte.ui.layout.GridActivity;
import com.litte.ui.layout.LinearActivity;
import com.litte.ui.layout.RelativeActivity;
import com.litte.ui.layout.TableActivity;
import com.litte.ui.userinterface.DateAndTimeActivity;
import com.litte.ui.userinterface.EditTextActivity;
import com.litte.ui.userinterface.GridViewActivity;
import com.litte.ui.userinterface.ImageViewActivity;
import com.litte.ui.userinterface.ListViewActivity;
import com.litte.ui.userinterface.ProgressBarActivity;
import com.litte.ui.userinterface.RadioCheckActivity;
import com.litte.ui.userinterface.RatingBarActivity;
import com.litte.ui.userinterface.ScrollViewActivity;
import com.litte.ui.userinterface.SeekBarActivity;
import com.litte.ui.userinterface.SpinnerActivity;
import com.litte.ui.userinterface.TextViewActivity;
import com.litte.ui.userinterface.ToggleSwitchActivity;

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

    @BindView(R.id.btn_scrollView)
    Button btnScrollView;
    @BindView(R.id.btn_date_time)
    Button btnDateTime;
    @BindView(R.id.btn_listView)
    Button btnListView;
    @BindView(R.id.btn_gridView)
    Button btnGridView;
    @BindView(R.id.btn_spinner)
    Button btnSpinner;
    @BindView(R.id.btn_autoCompleteTextView)
    Button btnAutoCompleteTextView;
    @BindView(R.id.btn_expandableListView)
    Button btnExpandableListView;
    @BindView(R.id.btn_viewFlipper)
    Button btnViewFlipper;
    @BindView(R.id.btn_toast)
    Button btnToast;
    @BindView(R.id.btn_notification)
    Button btnNotification;
    @BindView(R.id.btn_alertDialog)
    Button btnAlertDialog;
    @BindView(R.id.btn_popupWindow)
    Button btnPopupWindow;
    @BindView(R.id.btn_menu)
    Button btnMenu;
    @BindView(R.id.btn_viewPager)
    Button btnViewPager;
    @BindView(R.id.btn_drawerLayout)
    Button btnDrawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_linearlayout, R.id.btn_relativelayout, R.id.btn_tablelayout, R.id.btn_framelayout, R.id.btn_absolutelayout, R.id.btn_gridelayout,
            R.id.btn_textView, R.id.btn_editText, R.id.btn_button, R.id.btn_imageView, R.id.btn_radioButton_checkBox, R.id.btn_toggleButton_switch, R.id.btn_progressBar, R.id.btn_seekBar, R.id.btn_ratingBar,
            R.id.btn_scrollView, R.id.btn_date_time, R.id.btn_listView, R.id.btn_gridView, R.id.btn_spinner, R.id.btn_autoCompleteTextView, R.id.btn_expandableListView, R.id.btn_viewFlipper, R.id.btn_toast,
            R.id.btn_notification, R.id.btn_alertDialog, R.id.btn_popupWindow, R.id.btn_menu, R.id.btn_viewPager, R.id.btn_drawerLayout})
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
                startActivity(new Intent(this, ImageViewActivity.class));
                break;
            case R.id.btn_radioButton_checkBox:
                startActivity(new Intent(this, RadioCheckActivity.class));
                break;
            case R.id.btn_toggleButton_switch:
                startActivity(new Intent(this, ToggleSwitchActivity.class));
                break;
            case R.id.btn_progressBar:
                startActivity(new Intent(this, ProgressBarActivity.class));
                break;
            case R.id.btn_seekBar:
                startActivity(new Intent(this, SeekBarActivity.class));
                break;
            case R.id.btn_ratingBar:
                startActivity(new Intent(this, RatingBarActivity.class));
                break;
            /*----------------------------------------------------------*/

            case R.id.btn_scrollView:
                startActivity(new Intent(this, ScrollViewActivity.class));
                break;
            case R.id.btn_date_time:
                startActivity(new Intent(this, DateAndTimeActivity.class));
                break;
            case R.id.btn_listView:
                startActivity(new Intent(this, ListViewActivity.class));
                break;
            case R.id.btn_gridView:
                startActivity(new Intent(this, GridViewActivity.class));
                break;
            case R.id.btn_spinner:
                startActivity(new Intent(this, SpinnerActivity.class));
                break;
            case R.id.btn_autoCompleteTextView:
                break;
            case R.id.btn_expandableListView:
                break;
            case R.id.btn_viewFlipper:
                break;
            case R.id.btn_toast:
                break;
            case R.id.btn_notification:
                break;
            case R.id.btn_alertDialog:
                break;
            case R.id.btn_popupWindow:
                break;
            case R.id.btn_menu:
                break;
            case R.id.btn_viewPager:
                break;
            case R.id.btn_drawerLayout:
                break;
        }
    }
}
