package com.vo;

import java.io.Serializable;

/**
 * 继承了Comparable接口
 * Created by hpy on 2018/8/16.
 */
public class Person implements Serializable, Comparable {
    private String name;
    private Integer age;
    private String sex;
    //表示共享资源对象是否为空，如果为 true，表示需要生产，如果为 false，则有数据了，不要生产
    private Boolean isEmpty = true;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        return 1;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }

    public Person() {
    }

    /**
     * 生产数据
     *
     * @param name 姓名
     * @param sex  性别
     */
    public synchronized void push(String name, String sex) {
        try {
            //不能用if，因为有多个线程
            while (!isEmpty) {
                //共享资源对象有数据，不需要生产
                this.wait();
            }
            //----------生产数据开始--------------
            this.name = name;

            //这段延时代码的作用是可能只生产了 name，sex为null，消费者就拿去消费了
            Thread.sleep(10);

            this.sex = sex;
            //----------生产数据结束----------
            isEmpty = false;
            this.notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 提取数据
     */
    public synchronized void pop() {
        try {
            //不能用if，因为有多个线程
            while (isEmpty) {
                // isEmpty==true,表示为空，等待生产者生产数据，消费者要进入等待池中
                this.wait();
            }
            //----------消费开始----------
            Thread.sleep(10);
            System.out.println(this.name + "------" + this.sex);
            //-----------消费结束-----------
            //表示共享资源对象没有了，需要生产者生产
            isEmpty = true;
            //消费完毕，唤醒所有生产者
            this.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
