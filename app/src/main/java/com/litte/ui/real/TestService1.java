package com.litte.ui.real;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class TestService1 extends Service {
    private static final String TAG = "TEST_SERVICE1";
    private int count;
    private boolean quit;

    public IBinder binder = new MyBinder();
    public class MyBinder extends Binder {
        public int getCount(){
            return count;
        }
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "调用onBind 方法");
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "调用onCreate 方法");
        new Thread() {
            @Override
            public void run() {
                while (!quit){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count++;
                }
            }
        }.start();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "调用onUnbind 方法 ");
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.quit = true;
        Log.i(TAG, "调用onDestroy 方法");
    }

    @Override
    public void onRebind(Intent intent) {
        Log.i(TAG, "调用onRebind 方法");
        super.onRebind(intent);
    }
}
