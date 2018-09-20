package com.threads;

import com.vo.Person;

/**
 * 生产者创建
 * Created by hpy on 2018/9/19.
 */
public class ProduceThread implements Runnable {
    Person person = null;

    public ProduceThread(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        //生产对象
        for (int x = 0; x < 50; x++) {
            if (x % 2 == 0) {
                person.push("韩沛毅", "男");
            } else {
                person.push("袁安然", "女");
            }
        }

    }
}
