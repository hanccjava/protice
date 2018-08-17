package com.enums;

/**
 * 星期枚举类
 * Created by hpy on 2018/8/17.
 */
public enum Day {
    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期日");
    private String chinese;

    public String getChinese() {
        return this.chinese;
    }

    Day(String chinese) {
        this.chinese = chinese;
    }
}
