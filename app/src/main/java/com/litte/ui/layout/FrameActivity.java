package com.litte.ui.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.litte.ui.R;

public class FrameActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
    }
    public void animationFragment(View view){
        startActivity(new Intent(this,Frame2Activity.class));
    }
    public void frameLayoutAnimation(View view){
        startActivity(new Intent(this,Frame3Activity.class));
    }
}
