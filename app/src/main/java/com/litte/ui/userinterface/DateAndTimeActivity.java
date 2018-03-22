package com.litte.ui.userinterface;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.Toast;

import com.litte.ui.R;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DateAndTimeActivity extends Activity implements Chronometer.OnChronometerTickListener {

    @BindView(R.id.chronometer)
    Chronometer chronometer;
    @BindView(R.id.start)
    Button start;
    @BindView(R.id.stop)
    Button stop;
    @BindView(R.id.reset)
    Button reset;
    @BindView(R.id.format)
    Button format;
    @BindView(R.id.datePicker)
    DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_and_time);
        ButterKnife.bind(this);
        chronometer.setOnChronometerTickListener(this);
        initDatePicker();
    }

    private void initDatePicker() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int monthOfYear = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        datePicker.init(year, monthOfYear, dayOfMonth, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Toast.makeText(DateAndTimeActivity.this, "你选择的日期是："+year+"年"+(monthOfYear+1)+"月"+dayOfMonth+"日", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick({R.id.start, R.id.stop, R.id.reset, R.id.format})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.start:
                chronometer.start();
                break;
            case R.id.stop:
                chronometer.stop();
                break;
            case R.id.reset:
                chronometer.setBase(SystemClock.elapsedRealtime());//复位
                break;
            case R.id.format:
                chronometer.setFormat("%s");//更改时间显示格式
                break;
        }
    }

    @Override
    public void onChronometerTick(Chronometer chronometer) {
        String time = chronometer.getText().toString();
        if (time.equals("00:00")) {
            Toast.makeText(this, "时间归置", Toast.LENGTH_SHORT).show();
        }
    }
}
