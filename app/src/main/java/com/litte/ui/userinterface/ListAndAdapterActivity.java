package com.litte.ui.userinterface;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.litte.ui.R;
import com.litte.ui.adapter.AnimalAdapter;
import com.litte.ui.bean.Animal;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListAndAdapterActivity extends Activity {

    @BindView(R.id.lv_listView)
    ListView lvListView;
    private ArrayList<Animal> animals;
    AnimalAdapter adapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_and_adapter);
        ButterKnife.bind(this);
        animals = new ArrayList<>();
        animals.add(new Animal(R.drawable.bird,"鸟说","你是鸟么？"));
        animals.add(new Animal(R.drawable.chicken,"鸡说","你是鸡么？"));
        animals.add(new Animal(R.drawable.deer,"鹿说","你是鹿么？"));
        animals.add(new Animal(R.drawable.dog,"狗说","你是狗么？"));
        animals.add(new Animal(R.drawable.lion,"狮子说","你是狮子么？"));
        animals.add(new Animal(R.drawable.monkey,"猴说","你是猴么？"));
        adapter = new AnimalAdapter(animals,this);
        lvListView.setAdapter(adapter);
    }
}
