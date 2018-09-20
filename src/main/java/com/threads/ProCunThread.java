package com.threads;

import com.vo.Person;

/**
 * 生产者消费者测试类
 * Created by hpy on 2018/9/20.
 */
public class ProCunThread {
    public static void main(String[] args) {
        Person person = new Person();
        ProduceThread p = new ProduceThread(person);
        ConsumerThread c = new ConsumerThread(person);
        Thread thread1 = new Thread(p);
        Thread thread2 = new Thread(c);
        thread1.start();
        thread2.start();
    }
}
