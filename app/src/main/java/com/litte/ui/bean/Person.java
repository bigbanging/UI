package com.litte.ui.bean;

import java.io.Serializable;

/**
 * Created by litte on 2018/3/22.
 */

public class Person implements Serializable{
    private int person_icon;
    private String person_name;
    private String person_number;
    private boolean checkStatus;

    public Person() {
    }

    public Person(int person_icon, String person_name, String person_number, boolean checkStatus) {
        this.person_icon = person_icon;
        this.person_name = person_name;
        this.person_number = person_number;
        this.checkStatus = checkStatus;
    }

    public int getPerson_icon() {
        return person_icon;
    }

    public void setPerson_icon(int person_icon) {
        this.person_icon = person_icon;
    }

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public String getPerson_number() {
        return person_number;
    }

    public void setPerson_number(String person_number) {
        this.person_number = person_number;
    }

    public boolean isCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(boolean checkStatus) {
        this.checkStatus = checkStatus;
    }

    @Override
    public String toString() {
        return "Person{" +
                "person_icon=" + person_icon +
                ", person_name='" + person_name + '\'' +
                ", person_number='" + person_number + '\'' +
                ", checkStatus=" + checkStatus +
                '}';
    }
}
