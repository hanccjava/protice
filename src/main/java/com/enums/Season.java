package com.enums;

/**
 * 季节枚举类
 * Created by hpy on 2018/8/17.
 */
public enum Season {
    SPRING("春季"),
    SUMMER("夏季"),
    FALL("秋季"),
    WINTER("冬季");
    private String chinese;

    public String getChinese() {
        return this.chinese;
    }

    Season(String chinese) {
        this.chinese = chinese;
    }
}
