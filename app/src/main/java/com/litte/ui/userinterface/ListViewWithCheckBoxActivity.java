package com.litte.ui.userinterface;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.litte.ui.R;
import com.litte.ui.adapter.PersonAdapter;
import com.litte.ui.bean.Person;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListViewWithCheckBoxActivity extends Activity {

    @BindView(R.id.lv_list)
    ListView lvList;

    ArrayList<Person> personArrayList;
    PersonAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_with_check_box);
        ButterKnife.bind(this);
        personArrayList = new ArrayList<>();
        personArrayList.add(new Person(R.drawable.person_2,"Person1","let's talk",false));
        personArrayList.add(new Person(R.drawable.person_3,"Person2","I am Watching",false));
        personArrayList.add(new Person(R.drawable.person_4,"Person3","I am Listening",false));
        personArrayList.add(new Person(R.drawable.person_5,"Person4","I am wounded",false));
        adapter = new PersonAdapter(personArrayList,this);
        lvList.setAdapter(adapter);
    }
}
