package com.litte.ui.bean;

/**
 * Created by litte on 2018/3/22.
 */

public class Icon {
    private int mIcon;
    private String describe;

    public Icon() {
    }

    public Icon(int mIcon, String describe) {
        this.mIcon = mIcon;
        this.describe = describe;
    }

    public int getmIcon() {
        return mIcon;
    }

    public void setmIcon(int mIcon) {
        this.mIcon = mIcon;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
