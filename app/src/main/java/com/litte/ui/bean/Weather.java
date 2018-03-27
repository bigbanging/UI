package com.litte.ui.bean;

/**
 * Created by litte on 2018/3/24.
 */

public class Weather {
    private int weather_icon;

    public Weather() {
    }

    public Weather(int weather_icon) {
        this.weather_icon = weather_icon;
    }

    public int getWeather_icon() {
        return weather_icon;
    }

    public void setWeather_icon(int weather_icon) {
        this.weather_icon = weather_icon;
    }
}
