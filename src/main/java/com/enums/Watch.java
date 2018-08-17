package com.enums;

import com.vo.Worker;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * 值班表反馈信息操作
 * Created by hpy on 2018/8/17.
 */
public class Watch {
    public static void main(String[] args) {
        //将所有值班人员信息放入集合中
        List<Worker> workers = new ArrayList<Worker>(3);
        workers.add(new Worker("张三", EnumSet.of(
                Day.MONDAY, Day.TUESDAY, Day.WEDNESDAY, Day.FRIDAY)));
        workers.add(new Worker("李四", EnumSet.of(
                Day.TUESDAY, Day.THURSDAY, Day.SATURDAY)));
        workers.add(new Worker("王五", EnumSet.of(
                Day.TUESDAY, Day.THURSDAY)));

        //找出没有人值班的时间
        EnumSet<Day> enumSetDay = EnumSet.allOf(Day.class);
        for (Worker worker : workers) {
            enumSetDay.removeAll(worker.getAvailableDays());
        }
        System.out.println("没有人值班的是：" + enumSetDay);
        EnumSet<Day> dayEnumSet = EnumSet.noneOf(Day.class);
        for (Worker dayWorker : workers) {
          //  dayEnumSet = EnumSet;

        }
        System.out.println("至少有一人值班的是：" + dayEnumSet);
    }
}
