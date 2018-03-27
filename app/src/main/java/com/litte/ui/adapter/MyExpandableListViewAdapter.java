package com.litte.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.litte.ui.R;
import com.litte.ui.bean.Group;
import com.litte.ui.bean.Item;

import java.util.ArrayList;

/**
 * Created by litte on 2018/3/23.
 */

public class MyExpandableListViewAdapter extends BaseExpandableListAdapter {

    private Context mContext;
    private ArrayList<Group> groups;
    private ArrayList<ArrayList<Item>> items;

    public MyExpandableListViewAdapter(Context mContext, ArrayList<Group> groups, ArrayList<ArrayList<Item>> items) {
        this.mContext = mContext;
        this.groups = groups;
        this.items = items;
    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return items.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return items.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    //取得用于显示分组的视图，这个方法仅返回分组的视图对象
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ViewHolder1 holder1;
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.expand_item_group,parent,false);
            holder1 = new ViewHolder1();
            holder1.tv_group_name = convertView.findViewById(R.id.tv_expand_group_name);
            convertView.setTag(holder1);
        }else {
            holder1 = (ViewHolder1) convertView.getTag();
        }
        holder1.tv_group_name.setText(groups.get(groupPosition).getGroup_name());
        return convertView;
    }

    //取得显示分组子列表的数据
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolder2 holder2 ;
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.expand_item_child,parent,false);
            holder2 = new ViewHolder2();
            holder2.iv_item_icon = convertView.findViewById(R.id.iv_expand_child_icon);
            holder2.tv_item_name = convertView.findViewById(R.id.tv_expand_child_name);
            convertView.setTag(holder2);
        }else {
            holder2 = (ViewHolder2) convertView.getTag();
        }
        holder2.iv_item_icon.setImageResource(items.get(groupPosition).get(childPosition).getItem_icon());
        holder2.tv_item_name.setText(items.get(groupPosition).get(childPosition).getItem_name());
        return convertView;
    }

    //子列表是否可以被选中
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
    public static class ViewHolder1{
        TextView tv_group_name;
    }
    public static class ViewHolder2{
        ImageView iv_item_icon;
        TextView tv_item_name;
    }
}
