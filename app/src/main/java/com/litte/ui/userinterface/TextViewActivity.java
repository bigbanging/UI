package com.litte.ui.userinterface;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.litte.ui.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TextViewActivity extends Activity {

    @BindView(R.id.tv_textView_jay)
    TextView tvTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        ButterKnife.bind(this);
        Drawable[] drawables = tvTextView.getCompoundDrawables();
//        drawables[1].setBounds(100,0,200,200);
        tvTextView.setCompoundDrawables(drawables[0],drawables[1],drawables[2],drawables[3]);

//        String s1 = "<font color='yellow'><b>周杰伦</b></font><br>";
        String s1 = "<a href = 'https://baike.baidu.com/item/%E5%91%A8%E6%9D%B0%E4%BC%A6/129156?fr=aladdin'>周杰伦</a>";
        tvTextView.setText(Html.fromHtml(s1));
        tvTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }

}
