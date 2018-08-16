package com.collection;

import com.vo.Person;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Set接口子类操作
 * Created by txsk on 2018/8/16.
 */
public class ObserveSet {
    public static void ObserveHashSet() {
        Set<Person> set = new HashSet<Person>();
        set.add(new Person("张三", 20));
        set.add(new Person("李四", 50));
        set.add(new Person("王五", 10));
        System.out.println(set);
    }
    public static void ObserveTreeSet(){
        Set<Person> set = new TreeSet<Person>();
        set.add(new Person("张三", 20));
        set.add(new Person("李四", 50));
        set.add(new Person("王五", 10));
        System.out.println(set);
        Set<String> strings = new TreeSet<String>();
        strings.add("张三");
        strings.add("王五");
        strings.add("李四");
        System.out.println(strings);
    }

    public static void main(String[] args) {
        ObserveHashSet();
        ObserveTreeSet();
    }
}
