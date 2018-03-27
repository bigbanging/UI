package com.litte.ui.userinterface;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.litte.ui.R;
import com.litte.ui.adapter.MutiAdapter;
import com.litte.ui.bean.APP;
import com.litte.ui.bean.Book;
import com.litte.ui.bean.Data;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MutiListViewActivity extends Activity {

    @BindView(R.id.muti_list_view)
    ListView mutiListView;
    //数据源
    ArrayList<Object> datas = null;
    //适配器
    MutiAdapter adapter = null;
    //复杂布局的标识
    private static final int TYPE_APP = 0;
    private static final int TYPE_BOOK = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muti_list_view);
        ButterKnife.bind(this);
        //数据准备
        datas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            switch ((int)(Math.random()*2)){
                case TYPE_APP:
                    datas.add(new APP(R.drawable.a,"备忘录"));
//                    datas.add(new APP(R.drawable.b,"音乐"));
//                    datas.add(new APP(R.drawable.c,"游戏"));
                    break;
                case TYPE_BOOK:
                    datas.add(new Book("《第一行代码》", "郭霖"));
//                    datas.add(new Book("《Thinking in JAVA》", "Ｂruce Eckel"));
//                    datas.add(new Book("《端到端QoS网络设计》", "Tim Szigeti"));
//                    datas.add(new Book("《鸟哥的LINUX》", "鸟哥"));
            }
        }
        adapter = new MutiAdapter(this,datas);
        mutiListView.setAdapter(adapter);
    }
}
