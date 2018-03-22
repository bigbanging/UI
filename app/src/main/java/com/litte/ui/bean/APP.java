package com.litte.ui.bean;

/**
 * Created by litte on 2018/3/22.
 */

public class APP {
    //APP图标
    private int app_icon;
    //app名称
    private String app_name;

    public APP() {
    }

    public APP(int app_icon, String app_name) {
        this.app_icon = app_icon;
        this.app_name = app_name;
    }

    public int getApp_icon() {
        return app_icon;
    }

    public void setApp_icon(int app_icon) {
        this.app_icon = app_icon;
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    @Override
    public String toString() {
        return "APP{" +
                "app_icon=" + app_icon +
                ", app_name='" + app_name + '\'' +
                '}';
    }
}
