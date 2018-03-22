package com.litte.ui.userinterface;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.litte.ui.R;
import com.litte.ui.adapter.DataAdapter;
import com.litte.ui.bean.Data;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UpdateListViewActivity extends Activity {

    @BindView(R.id.btn_add_data)
    Button btnAddData;
    @BindView(R.id.lv_update)
    ListView lvUpdate;
    @BindView(R.id.btn_add)
    Button btnAdd;
    @BindView(R.id.btn_remove_data)
    Button btnRemoveData;
    @BindView(R.id.btn_remove)
    Button btnRemove;

    private ArrayList<Data> datas;
    DataAdapter adapter;
    private int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_list_view);
        ButterKnife.bind(this);
        datas = new ArrayList<>();
        adapter = new DataAdapter(datas, this);
        lvUpdate.setAdapter(adapter);
    }

    @OnClick({R.id.btn_add_data, R.id.btn_add,R.id.btn_remove_data,R.id.btn_remove})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_add_data:
                adapter.addData(new Data(R.drawable.fun, "有意思了yo" + i));
                i++;
                break;
            case R.id.btn_add:
                adapter.addData(4, new Data(R.drawable.fun, "这是插入的数据````~~" + i));
                i--;
                break;
            case R.id.btn_remove_data:
//                adapter.remove(new Data());
                adapter.clear();
                break;
            case R.id.btn_remove:
                adapter.remove(6);
                break;
        }
    }
}
