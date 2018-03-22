package com.litte.ui.userinterface;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.litte.ui.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListViewActivity extends Activity implements AdapterView.OnItemClickListener {

    @BindView(R.id.listView)
    ListView listView;
    @BindView(R.id.listView1)
    ListView listView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ButterKnife.bind(this);
        String[] data = {"进入SimpleAdapter的应用", "android", "C++", "python", "C#", "MYSQL"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.MyListViewArray,android.R.layout.simple_list_item_multiple_choice);
        listView1.setAdapter(adapter1);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "你点击了" + position, Toast.LENGTH_SHORT).show();
        if (position == 0){
            startActivity(new Intent(this,ListView2Activity.class));
        }else if (position == 1){
            startActivity(new Intent(this,ListAndAdapterActivity.class));
        }else if (position == 2){
            startActivity(new Intent(this,ListViewWithCheckBoxActivity.class));
        }else if (position == 3){
            startActivity(new Intent(this,UpdateListViewActivity.class));
        }else if (position == 4){
            startActivity(new Intent(this,MutiListViewActivity.class));
        }
    }
}
