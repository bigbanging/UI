package com.litte.ui.bean;

/**
 * Created by litte on 2018/3/21.
 */

public class Animal {
    private int mIcon;
    private String mName;
    private String mSpeak;

    public Animal() {
    }

    public Animal(int mIcon, String mName, String mSpeak) {
        this.mIcon = mIcon;
        this.mName = mName;
        this.mSpeak = mSpeak;
    }

    public int getmIcon() {
        return mIcon;
    }

    public void setmIcon(int mIcon) {
        this.mIcon = mIcon;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmSpeak() {
        return mSpeak;
    }

    public void setmSpeak(String mSpeak) {
        this.mSpeak = mSpeak;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "mIcon=" + mIcon +
                ", mName='" + mName + '\'' +
                ", mSpeak='" + mSpeak + '\'' +
                '}';
    }
}
