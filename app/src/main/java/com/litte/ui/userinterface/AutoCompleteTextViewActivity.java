package com.litte.ui.userinterface;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import com.litte.ui.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AutoCompleteTextViewActivity extends Activity {

    @BindView(R.id.autoCompleteTextView)
    AutoCompleteTextView autoCompleteTextView;
    @BindView(R.id.multiAutoCompleteTextView)
    MultiAutoCompleteTextView multiAutoCompleteTextView;

    private String[] datas = new String[]{"小猪猪","小岳岳","幽默","快乐","jack","tom","Google","android","Java","python","php",
            "javaScript","MySql","..","0.0","C#","C","C++","HelloWorld"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_text_view);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,datas);
        autoCompleteTextView.setAdapter(adapter1);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,datas);
        multiAutoCompleteTextView.setAdapter(adapter2);
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());//设置分隔符
    }
}
