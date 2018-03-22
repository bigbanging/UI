package com.litte.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.litte.ui.R;
import com.litte.ui.bean.Animal;

import java.util.ArrayList;


/**
 * Created by litte on 2018/3/21.
 */

public class AnimalAdapter extends BaseAdapter {
    //数据源
    private ArrayList<Animal> animalArrayList;
    private Context mContext;

    public AnimalAdapter(ArrayList<Animal> animalArrayList, Context mContext) {
        this.animalArrayList = animalArrayList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return animalArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return animalArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_view_item, parent, false);
            holder = new ViewHolder();
            holder.iv_animal_icon = convertView.findViewById(R.id.iv_animal_icon);
            holder.tv_animal_name = convertView.findViewById(R.id.tv_animal_name);
            holder.tv_animal_speak = convertView.findViewById(R.id.tv_animal_speak);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.iv_animal_icon.setBackgroundResource(animalArrayList.get(position).getmIcon());
        holder.tv_animal_name.setText(animalArrayList.get(position).getmName());
        holder.tv_animal_speak.setText(animalArrayList.get(position).getmSpeak());
        return convertView;
    }

    public static class ViewHolder{
        ImageView iv_animal_icon;
        TextView tv_animal_name;
        TextView tv_animal_speak;
    }
}
