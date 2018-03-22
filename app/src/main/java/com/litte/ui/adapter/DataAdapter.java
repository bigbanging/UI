package com.litte.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.litte.ui.R;
import com.litte.ui.bean.Data;

import java.util.ArrayList;

/**
 * Created by litte on 2018/3/22.
 */

public class DataAdapter extends BaseAdapter {
    private ArrayList<Data> datas;
    private Context mContext;

    public DataAdapter(ArrayList<Data> datas, Context mContext) {
        this.datas = datas;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 增加一条数据
     * @param data
     */
    public void addData(Data data){
        if (datas == null){
            datas = new ArrayList<>();
        }
        datas.add(data);
        notifyDataSetChanged();
    }

    /**
     * 在某一点处插入数据
     * @param position
     * @param data
     */
    public void addData(int position,Data data){
        if (datas == null){
            datas = new ArrayList<>();
        }
        datas.add(position,data);
        notifyDataSetChanged();
    }

    /**
     * 删除一个对象
     * @param data
     */
    public void remove(Data data){
        if (datas != null){
            datas.remove(data);
        }
        notifyDataSetChanged();
    }

    /**
     * 删除某一处的数据
     * @param position
     */
    public void remove(int position){
        if (datas!=null){
            datas.remove(position);
        }
        notifyDataSetChanged();
    }

    /**
     * 清除数据
     */
    public void clear(){
        if (datas != null){
            datas.clear();
        }
        notifyDataSetChanged();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.listview_data, parent, false);
            holder = new ViewHolder();
            holder.ivData = convertView.findViewById(R.id.iv_data);
            holder.tvData = convertView.findViewById(R.id.tv_data);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.ivData.setImageResource(datas.get(position).getData_icon());
        holder.tvData.setText(datas.get(position).getData_content());
        return convertView;
    }

    static class ViewHolder {
        ImageView ivData;
        TextView tvData;
    }
}
