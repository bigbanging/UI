package com.litte.ui.userinterface;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.litte.ui.R;
import com.litte.ui.adapter.MyAdapter;
import com.litte.ui.bean.Hero;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {

    @BindView(R.id.spinner_segment)
    Spinner spinnerSegment;
    @BindView(R.id.spinner_hero)
    Spinner spinnerHero;
    @BindView(R.id.tv_choice)
    TextView tvChoice;
    //数据源
    private ArrayList<Hero> heros;
    //适配器
    BaseAdapter adapter;
    //判断标识符

    private boolean spinner_segment;
    private boolean spinner_hero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        ButterKnife.bind(this);
        bindSpinnerView();
    }

    private void bindSpinnerView() {
        heros = new ArrayList<>();
        heros.add(new Hero(R.drawable.kai, "凯"));
        heros.add(new Hero(R.drawable.jing, "橘右京"));
        heros.add(new Hero(R.drawable.laofuzi, "老夫子"));
        heros.add(new Hero(R.drawable.monkey, "齐天大圣"));
        heros.add(new Hero(R.drawable.wuzang, "宫本武藏"));
        heros.add(new Hero(R.drawable.yadianna, "雅典娜"));
        adapter = new MyAdapter<Hero>(heros, R.layout.spinner_item) {
            @Override
            public void bindView(ViewHolder holder, Hero obj) {
                holder.setImageResource(R.id.iv_hero, obj.getHero_icon());
                holder.setText(R.id.tv_hero_name, obj.getHero_name());
            }
        };
        spinnerHero.setAdapter(adapter);
        spinnerSegment.setOnItemSelectedListener(this);
        spinnerHero.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.spinner_segment:
                if (spinner_segment) {
                    Toast.makeText(this, "你的段位是:" + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                } else spinner_segment = true;
                break;
            case R.id.spinner_hero:
                if (spinner_hero) {
                    TextView tv_show_hero_name = findViewById(R.id.tv_hero_name);
                    Toast.makeText(this, "请选择你的拿手英雄："+tv_show_hero_name.getText().toString(), Toast.LENGTH_SHORT).show();
                }else spinner_hero = true;
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
