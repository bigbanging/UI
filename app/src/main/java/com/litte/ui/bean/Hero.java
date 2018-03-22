package com.litte.ui.bean;

/**
 * Created by litte on 2018/3/22.
 */

public class Hero {
    private int hero_icon;
    private String hero_name;

    public Hero() {
    }

    public Hero(int hero_icon, String hero_name) {
        this.hero_icon = hero_icon;
        this.hero_name = hero_name;
    }

    public String getHero_name() {
        return hero_name;
    }

    public void setHero_name(String hero_name) {
        this.hero_name = hero_name;
    }

    public int getHero_icon() {
        return hero_icon;
    }

    public void setHero_icon(int hero_icon) {
        this.hero_icon = hero_icon;
    }
}
