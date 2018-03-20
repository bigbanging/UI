package com.litte.ui.layout;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.FrameLayout;

import com.litte.ui.R;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Frame3Activity extends Activity {

    @BindView(R.id.frame_animation)
    FrameLayout frameAnimation;

    Handler handler = new Handler() {
        int i = 0;
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 101){
                i++;
                change(i%24);
            }
            super.handleMessage(msg);
        }
    };
    //定义一个切换图片的方法
    void change(int picture){
        Drawable a = getResources().getDrawable(R.drawable.img01);
        Drawable b = getResources().getDrawable(R.drawable.img02);
        Drawable c = getResources().getDrawable(R.drawable.img03);
        Drawable d = getResources().getDrawable(R.drawable.img04);
        Drawable e = getResources().getDrawable(R.drawable.img05);
        Drawable f = getResources().getDrawable(R.drawable.img06);
        Drawable g = getResources().getDrawable(R.drawable.img07);
        Drawable h = getResources().getDrawable(R.drawable.img08);
        Drawable i = getResources().getDrawable(R.drawable.img09);
        Drawable j = getResources().getDrawable(R.drawable.img10);
        Drawable k = getResources().getDrawable(R.drawable.img11);
        Drawable l = getResources().getDrawable(R.drawable.img12);
        Drawable m = getResources().getDrawable(R.drawable.img13);
        Drawable n = getResources().getDrawable(R.drawable.img14);
        Drawable o = getResources().getDrawable(R.drawable.img15);
        Drawable p = getResources().getDrawable(R.drawable.img16);
        Drawable q = getResources().getDrawable(R.drawable.img17);
        Drawable s = getResources().getDrawable(R.drawable.img18);
        Drawable t = getResources().getDrawable(R.drawable.img19);
        Drawable u = getResources().getDrawable(R.drawable.img20);
        Drawable v = getResources().getDrawable(R.drawable.img21);
        Drawable x = getResources().getDrawable(R.drawable.img22);
        Drawable y = getResources().getDrawable(R.drawable.img23);
        Drawable z = getResources().getDrawable(R.drawable.img24);
        switch (picture){
            case 0:
                frameAnimation.setForeground(a);
                break;
            case 1:
                frameAnimation.setForeground(b);
                break;
            case 2:
                frameAnimation.setForeground(c);
                break;
            case 3:
                frameAnimation.setForeground(d);
                break;
            case 4:
                frameAnimation.setForeground(e);
                break;
            case 5:
                frameAnimation.setForeground(f);
                break;
            case 6:
                frameAnimation.setForeground(g);
                break;
            case 7:
                frameAnimation.setForeground(h);
                break;
            case 8:
                frameAnimation.setForeground(i);
                break;
            case 9:
                frameAnimation.setForeground(j);
                break;
            case 10:
                frameAnimation.setForeground(k);
                break;
            case 11:
                frameAnimation.setForeground(l);
                break;
            case 12:
                frameAnimation.setForeground(m);
                break;
            case 13:
                frameAnimation.setForeground(n);
                break;
            case 14:
                frameAnimation.setForeground(o);
                break;
            case 15:
                frameAnimation.setForeground(p);
                break;
            case 16:
                frameAnimation.setForeground(q);
                break;
            case 17:
                frameAnimation.setForeground(s);
                break;
            case 18:
                frameAnimation.setForeground(t);
                break;
            case 19:
                frameAnimation.setForeground(u);
                break;
            case 20:
                frameAnimation.setForeground(v);
                break;
            case 21:
                frameAnimation.setForeground(x);
                break;
            case 22:
                frameAnimation.setForeground(y);
                break;
            case 23:
                frameAnimation.setForeground(z);
                break;
            default:
                break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame3);
        ButterKnife.bind(this);
        //定义一个定时器 定时给handler发送消息，来改变图片
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                int what = 101;
                handler.sendEmptyMessage(what);
            }
        },0,200);
    }
}
