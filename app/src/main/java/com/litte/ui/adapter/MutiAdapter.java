package com.litte.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.litte.ui.R;
import com.litte.ui.bean.APP;
import com.litte.ui.bean.Book;

import java.util.ArrayList;

/**
 * Created by litte on 2018/3/22.
 */

public class MutiAdapter extends BaseAdapter {

    public static final int TYPE_BOOK = 0;
    public static final int TYPE_APP = 1;

    private Context mContext;
    private ArrayList<Object> datas = null;

    public MutiAdapter(Context mContext, ArrayList<Object> datas) {
        this.mContext = mContext;
        this.datas = datas;
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

    //多布局的核心，通过这个判断类别
    @Override
    public int getItemViewType(int position) {
        if (datas.get(position) instanceof APP){
            return TYPE_APP;
        }else {
            return TYPE_BOOK;
        }
    }
    //类别数目


    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        ViewHolder1 holder1 = null;
        ViewHolder2 holder2 = null;
        if (convertView == null){
            switch (type){
                case TYPE_APP:
                    holder1 = new ViewHolder1();
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.item_app,parent,false);
                    holder1.iv_app_icon = convertView.findViewById(R.id.iv_app_icon);
                    holder1.tv_app_name = convertView.findViewById(R.id.tv_app_name);

                    convertView.setTag(R.id.Tag_APP,holder1);
                    break;
                case TYPE_BOOK:
                    holder2 = new ViewHolder2();
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.item_book,parent,false);
                    holder2.tv_book_name = convertView.findViewById(R.id.tv_book_name);
                    holder2.tv_bool_author = convertView.findViewById(R.id.tv_book_author);

                    convertView.setTag(R.id.Tag_Book,holder2);
                    break;
            }
        }else {
            switch (type){
                case TYPE_APP:
                    holder1 = (ViewHolder1) convertView.getTag();
                    break;
                case TYPE_BOOK:
                    holder2 = (ViewHolder2) convertView.getTag();
                    break;
            }
        }
        Object object = datas.get(position);
        switch (type){
            case TYPE_APP:
                APP app = (APP) object;
                holder1.iv_app_icon.setImageResource(app.getApp_icon());
                holder1.tv_app_name.setText(app.getApp_name());
                break;
            case TYPE_BOOK:
                Book book = (Book) object;
                holder2.tv_book_name.setText(book.getBook_name());
                holder2.tv_bool_author.setText(book.getBook_author());
                break;
        }
        return convertView;
    }
    static class ViewHolder1{
        ImageView iv_app_icon;
        TextView tv_app_name;
    }
    static class ViewHolder2{
        TextView tv_book_name;
        TextView tv_bool_author;
    }
}
