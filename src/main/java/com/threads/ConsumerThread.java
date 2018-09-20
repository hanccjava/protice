package com.threads;

import com.vo.Person;

/**
 * 消费者
 * Created by hpy on 2018/9/19.
 */
public class ConsumerThread implements Runnable {
    //共享资源对象
    Person person = null;

    public ConsumerThread(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        for (int x = 0; x < 50; x++) {
            //消费对象
            person.pop();
        }

    }
}
