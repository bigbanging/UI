package com.litte.ui.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.litte.ui.R;

public class RelativeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);
        final Intent intent = new Intent(this,AddActivity.class);
        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    sleep(2000);
                    startActivity(intent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}
