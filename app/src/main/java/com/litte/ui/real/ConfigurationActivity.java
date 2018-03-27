package com.litte.ui.real;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.TextView;

import com.litte.ui.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ConfigurationActivity extends Activity {

    @BindView(R.id.tv_configuration)
    TextView txtResult ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        ButterKnife.bind(this);
        StringBuffer status = new StringBuffer();
        //①获取系统的Configuration对象
        Configuration cfg = getResources().getConfiguration();
        //②想查什么查什么
        status.append("densityDpi：屏幕密度" + cfg.densityDpi + "\n");
        status.append("fontScale：当前用户设置的字体的缩放因子" + cfg.fontScale + "\n");
        status.append("hardKeyboardHidden：判断硬键盘是否可见，有两个可选值：HARDKEYBOARDHIDDEN_NO,HARDKEYBOARDHIDDEN_YES，分别是十六进制的0和1" + cfg.hardKeyboardHidden + "\n");
        status.append(" keyboard：获取当前关联额键盘类型：该属性的返回值：KEYBOARD_12KEY（只有12个键的小键盘）、KEYBOARD_NOKEYS、KEYBOARD_QWERTY（普通键盘）" + cfg.keyboard + "\n");
        status.append("keyboardHidden：该属性返回一个boolean值用于标识当前键盘是否可用。该属性不仅会判断系统的硬件键盘，也会判断系统的软键盘（位于屏幕）。" + cfg.keyboardHidden + "\n");
        status.append("locale：获取用户当前的语言环境" + cfg.locale + "\n");
        status.append("mcc：获取移动信号的国家码" + cfg.mcc + "\n");
        status.append("mnc：获取移动信号的网络码 ps:国家代码和网络代码共同确定当前手机网络运营商" + cfg.mnc + "\n");
        status.append("navigation：判断系统上方向导航设备的类型。该属性的返回值：NAVIGATION_NONAV（无导航）、 NAVIGATION_DPAD(DPAD导航）NAVIGATION_TRACKBALL（轨迹球导航）、NAVIGATION_WHEEL（滚轮导航）" + cfg.navigation + "\n");
        status.append("navigationHidden:" + cfg.navigationHidden + "\n");
        status.append("orientation：获取系统屏幕的方向。该属性的返回值：ORIENTATION_LANDSCAPE（横向屏幕）、ORIENTATION_PORTRAIT（竖向屏幕）" + cfg.orientation + "\n");
        status.append("screenHeightDp：屏幕可用高，用dp表示" + cfg.screenHeightDp + "\n");
        status.append("screenWidthDp:屏幕可用宽" + cfg.screenWidthDp + "\n");
        status.append("screenLayout:" + cfg.screenLayout + "\n");
        status.append("smallestScreenWidthDp:" + cfg.densityDpi + "\n");
        status.append("touchscreen：获取系统触摸屏的触摸方式。该属性的返回值：TOUCHSCREEN_NOTOUCH（无触摸屏）、TOUCHSCREEN_STYLUS（触摸笔式触摸屏）、TOUCHSCREEN_FINGER（接收手指的触摸屏）" + cfg.densityDpi + "\n");
        status.append("uiMode:" + cfg.densityDpi + "\n");
        txtResult.setText(status.toString());
    }
}
