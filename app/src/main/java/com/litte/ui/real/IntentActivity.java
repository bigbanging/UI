package com.litte.ui.real;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.litte.ui.R;

public class IntentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        Intent intent = new Intent(this,MyIntentService.class);
        intent.setAction("com.litter.intent_service");
        Bundle bundle = new Bundle();
        bundle.putString("param","s1");
        intent.putExtras(bundle);

        Intent intent1 = new Intent(this,MyIntentService.class);
        intent1.setAction("com.litter.intent_service");
        Bundle bundle1 = new Bundle();
        bundle.putString("param","s2");
        intent.putExtras(bundle1);

        Intent intent2 = new Intent(this,MyIntentService.class);
        intent2.setAction("com.litter.intent_service");
        Bundle bundle2 = new Bundle();
        bundle.putString("param","s3");
        intent.putExtras(bundle2);

        startService(intent);
        startService(intent1);
        startService(intent2);
    }
}
