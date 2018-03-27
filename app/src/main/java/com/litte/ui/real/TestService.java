package com.litte.ui.real;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by litte on 2018/3/26.
 */

public class TestService extends Service {
    public static final String TAG = "SERVICE_TAG";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "调用onBind 方法");
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "调用onCreate 方法");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "调用onStartCommand 方法");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "调用onDestroy 方法");
    }
}
