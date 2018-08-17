package com.enums;

/**
 * 颜色枚举类
 * Created by hpy on 2018/8/17.
 */
public enum Color {
    RED(1, "红色"),
    GREEN(2, "绿色"),
    BLUE(3, "蓝色"),
    WHITE(4, "白色"),
    BLACK(5, "黑色"),
    YELLOW(6, "黄色"),
    PINK(7, "粉色");
    private String description;
    private Integer id;

    public Integer getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    Color(Integer id, String description) {
        this.description = description;
        this.id = id;
    }
}
