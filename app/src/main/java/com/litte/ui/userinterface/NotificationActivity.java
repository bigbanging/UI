package com.litte.ui.userinterface;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.litte.ui.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NotificationActivity extends Activity {

    @BindView(R.id.btn_show_notification)
    Button btnShowNotification;
    @BindView(R.id.btn_close_notification)
    Button btnCloseNotification;
    private Bitmap largeBitmap;
    private NotificationManager notificationManager;
    private Notification notification;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);
        initNotification();
    }

    private void initNotification() {
        //创建提示框的大图标
        largeBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.fun1);
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

    }

    @OnClick({R.id.btn_show_notification, R.id.btn_close_notification})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_show_notification:
                //定义一个PendingIntent点击Notification后启动一个Activity
                Intent intent = new Intent(this,ShowNotificationActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
                //设置通知栏的一些属性
                Notification.Builder builder = new Notification.Builder(this);
                builder.setContentTitle("妖精")                          //标题
                        .setContentText("哪里跑，速手就擒，饶你不死")     //内容
                        .setSubText("——降魔军团口号")                  //内容下面的一段字
                        .setTicker("降魔军团的短信")                     //收到提示后状态栏显示的文字
                        .setWhen(System.currentTimeMillis())            //收到通知的时间
                        .setSmallIcon(R.drawable.fun)                   //通知变小后的图标
                        .setLargeIcon(largeBitmap)                      //通知的大图标
                        .setDefaults(Notification.DEFAULT_LIGHTS|Notification.DEFAULT_VIBRATE)
                        .setSound(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.biaobiao))
                        .setAutoCancel(true)
                        .setContentIntent(pendingIntent);
                notification = builder.build();
                notificationManager.notify(1,notification);
                break;
            case R.id.btn_close_notification:
                notificationManager.cancel(1);
                break;
        }
    }
}
