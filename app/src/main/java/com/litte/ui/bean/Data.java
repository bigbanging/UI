package com.litte.ui.bean;

/**
 * Created by litte on 2018/3/22.
 */

public class Data {
    private int data_icon;
    private String data_content;

    public Data() {
    }

    public Data(int data_icon, String data_content) {
        this.data_icon = data_icon;
        this.data_content = data_content;
    }

    public int getData_icon() {
        return data_icon;
    }

    public void setData_icon(int data_icon) {
        this.data_icon = data_icon;
    }

    public String getData_content() {
        return data_content;
    }

    public void setData_content(String data_content) {
        this.data_content = data_content;
    }

    @Override
    public String toString() {
        return "Data{" +
                "data_icon=" + data_icon +
                ", data_content='" + data_content + '\'' +
                '}';
    }
}
