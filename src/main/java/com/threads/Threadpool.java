package com.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * Created by hpy on 2018/8/30.
 */
public class Threadpool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int x = 0; x < 10; x++) {
            try {
                int index = x;
                Thread.sleep(200);
                executorService.submit(() -> {new Thread(()->{System.out.println(Thread.currentThread().getName() + "x:" + index);});

                });
                executorService.shutdown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {

            }
        }

    }
}
