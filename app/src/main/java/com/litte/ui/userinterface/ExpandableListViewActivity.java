package com.litte.ui.userinterface;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.litte.ui.R;
import com.litte.ui.adapter.MyExpandableListViewAdapter;
import com.litte.ui.bean.Group;
import com.litte.ui.bean.Item;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExpandableListViewActivity extends Activity {

    @BindView(R.id.expandableListView)
    ExpandableListView expandableListView;
    private ArrayList<Group>groupList;
    private ArrayList<ArrayList<Item>> itemList;
    private ArrayList<Item> items;
    MyExpandableListViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list_view);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        groupList = new ArrayList<>();
        groupList.add(new Group("射手"));
        groupList.add(new Group("法师"));
        groupList.add(new Group("坦克"));
        groupList.add(new Group("战士"));

        itemList = new ArrayList<>();

        items = new ArrayList<>();
        items.add(new Item(R.drawable.yuanfang,"李元芳"));
        itemList.add(items);

        items = new ArrayList<>();
        items.add(new Item(R.drawable.zhugeliang,"诸葛亮"));
        itemList.add(items);

        items = new ArrayList<>();
        items.add(new Item(R.drawable.baiqi, "白起"));
        items.add(new Item(R.drawable.chengyaojin, "程咬金"));
        items.add(new Item(R.drawable.donghuangtaiyi, "东皇太一"));
        items.add(new Item(R.drawable.lvbu, "吕布"));
        items.add(new Item(R.drawable.miyue, "芈月"));
        items.add(new Item(R.drawable.niumo, "牛魔"));
        items.add(new Item(R.drawable.zhangfei, "张飞"));
        items.add(new Item(R.drawable.zhongwuyan, "钟无艳"));
        items.add(new Item(R.drawable.zhuangzhou, "庄周"));
        itemList.add(items);

        items = new ArrayList<>();
        items.add(new Item(R.drawable.jing, "橘右京"));
        items.add(new Item(R.drawable.kai, "凯"));
        items.add(new Item(R.drawable.laofuzi, "老夫子"));
        items.add(new Item(R.drawable.monkey, "猴子"));
        items.add(new Item(R.drawable.wuzang, "宫本武藏"));
        items.add(new Item(R.drawable.yadianna, "雅典娜"));
        itemList.add(items);

        adapter = new MyExpandableListViewAdapter(this,groupList,itemList);
        expandableListView.setAdapter(adapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(ExpandableListViewActivity.this, "你点击了~~~"+itemList.get(groupPosition).get(childPosition).getItem_name(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}
