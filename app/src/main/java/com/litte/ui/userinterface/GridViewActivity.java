package com.litte.ui.userinterface;

import android.app.Activity;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.litte.ui.R;
import com.litte.ui.adapter.MyAdapter;
import com.litte.ui.bean.Icon;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GridViewActivity extends Activity {

    @BindView(R.id.grid_view)
    GridView gridView;
    //数据源
    private ArrayList<Icon> iconArrayList;
    BaseAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        ButterKnife.bind(this);
        iconArrayList = new ArrayList<>();
        iconArrayList.add(new Icon(R.drawable.iv_icon_1,"图标一"));
        iconArrayList.add(new Icon(R.drawable.iv_icon_2,"图标二"));
        iconArrayList.add(new Icon(R.drawable.iv_icon_3,"图标三"));
        iconArrayList.add(new Icon(R.drawable.iv_icon_4,"图标四"));
        iconArrayList.add(new Icon(R.drawable.iv_icon_5,"图标五"));
        iconArrayList.add(new Icon(R.drawable.iv_icon_6,"图标六"));
        iconArrayList.add(new Icon(R.drawable.iv_icon_7,"图标七"));
        adapter = new MyAdapter<Icon>(iconArrayList,R.layout.grid_item) {
            @Override
            public void bindView(ViewHolder holder, Icon obj) {
                holder.setImageResource(R.id.iv_grid_icon, obj.getmIcon());
                holder.setText(R.id.tv_describe,obj.getDescribe());
            }
        };
        gridView.setAdapter(adapter);
    }
}
