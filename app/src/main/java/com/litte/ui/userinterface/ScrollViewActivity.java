package com.litte.ui.userinterface;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.litte.ui.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ScrollViewActivity extends Activity {

    @BindView(R.id.btn_top)
    Button btnTop;
    @BindView(R.id.btn_bottom)
    Button btnBottom;
    @BindView(R.id.tv_show)
    TextView tvShow;
    @BindView(R.id.scrollView)
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);
        ButterKnife.bind(this);

        addDate();
    }

    private void addDate() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            stringBuilder.append("哈哈*"+i+"\n");
        }
        tvShow.setText(stringBuilder.toString());
    }

    @OnClick({R.id.btn_top, R.id.btn_bottom})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_top:
                scrollView.fullScroll(ScrollView.FOCUS_UP);
                break;
            case R.id.btn_bottom:
                scrollView.fullScroll(View.FOCUS_DOWN);
                break;
        }
    }
}
