package com.enums;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * EnumSet
 * Created by hpy on 2018/8/17.
 */
public class EnumSetDemo {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        //第一种：创建一个EnumSet集合，集合元素就是Color的全部枚举值
        EnumSet enumSet = EnumSet.allOf(Color.class);
        System.out.println("创建一个EnumSet集合，集合元素就是Color的全部枚举值" + enumSet);

        //第二种：创建一个EnumSet空集合，指定其集合元素是Color类的枚举值。
        enumSet = EnumSet.noneOf(Color.class);
        System.out.println("创建一个EnumSet空集合" + enumSet);
        //插入数据，观察输出排列顺序
        enumSet.add(Color.BLACK);
        enumSet.add(Color.RED);
        System.out.println("EnumSet是有序的" + enumSet);

        //第三种：以指定枚举值创建EnumSet集合
        enumSet = EnumSet.of(Color.BLUE, Color.WHITE);
        System.out.println("以指定枚举值创建EnumSet集合" + enumSet);

        //第四种：指定元素的范围
        enumSet = EnumSet.range(Color.GREEN, Color.YELLOW);
        System.out.println("指定元素的范围" + enumSet);

        //第五种:集合中包含EnumSet参数集合中所有元素
        EnumSet enumSet1 = EnumSet.copyOf(enumSet);
        enumSet1.add(Color.PINK);
        System.out.println("集合中包含EnumSet参数集合中所有元素" + enumSet1);

        //第六种：集合中包含Collections子类的元素
        List<Color> list = new ArrayList<Color>(2);
        list.add(Color.RED);
        enumSet1 = EnumSet.copyOf(list);
        System.out.println("集合中包含Collections子类的元素" + enumSet1);


    }
}
