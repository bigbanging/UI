package com.litte.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.litte.ui.R;
import com.litte.ui.bean.Person;

import java.util.ArrayList;

/**
 * Created by litte on 2018/3/22.
 */

public class PersonAdapter extends BaseAdapter implements CompoundButton.OnCheckedChangeListener {

    private ArrayList<Person> persons ;
    private Context mContext;

    public PersonAdapter(ArrayList<Person> persons, Context mContext) {
        this.persons = persons;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Object getItem(int position) {
        return persons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //定义一个刷新数据的方法
    public void changeData(ArrayList<Person> data){
        persons = data;
        notifyDataSetChanged();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int index = position;
        ViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.listview_check_box,parent,false);
            holder = new ViewHolder();
            holder.iv_person_icon = convertView.findViewById(R.id.iv_person_icon);
            holder.tv_person_name = convertView.findViewById(R.id.tv_person_name);
            holder.tv_person_speak = convertView.findViewById(R.id.tv_person_speak);
            holder.cb_checkStatus = convertView.findViewById(R.id.cb_person);
            convertView.setTag(holder);
            holder.cb_checkStatus.setTag(index);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.iv_person_icon.setImageResource(persons.get(index).getPerson_icon());
        holder.tv_person_name.setText(persons.get(index).getPerson_name());
        holder.tv_person_speak.setText(persons.get(index).getPerson_number());
        holder.cb_checkStatus.setOnCheckedChangeListener(this);
        holder.cb_checkStatus.setChecked(persons.get(position).isCheckStatus());
        return convertView;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int index = (int) buttonView.getTag();
        if (isChecked){
            persons.get(index).setCheckStatus(true);
            Toast.makeText(mContext, "选中"+index, Toast.LENGTH_SHORT).show();
        }else {
            persons.get(index).setCheckStatus(false);
            Toast.makeText(mContext, "取消选中"+index, Toast.LENGTH_SHORT).show();
        }
    }

    public static class ViewHolder{
        ImageView iv_person_icon;
        TextView tv_person_name;
        TextView tv_person_speak;
        CheckBox cb_checkStatus;
    }
}
