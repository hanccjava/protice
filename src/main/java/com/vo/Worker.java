package com.vo;


import com.enums.Day;

import java.util.EnumSet;

/**
 * 值班人员VO
 * Created by hpy on 2018/8/17.
 */
public class Worker {
    private String name;
    private EnumSet<Day> availableDays;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnumSet<Day> getAvailableDays() {
        return availableDays;
    }

    public void setAvailableDays(EnumSet<Day> availableDays) {
        this.availableDays = availableDays;
    }

    public Worker(String name, EnumSet<Day> availableDays) {
        this.name = name;
        this.availableDays = availableDays;
    }

    public Worker() {
    }
}
