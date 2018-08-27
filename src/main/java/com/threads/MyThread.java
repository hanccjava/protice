package com.threads;

/**
 * @Auther: ReXin
 * @Date: 2018/8/27 22:
 * @Description: Thread类实现多线程
 */
public class MyThread extends Thread {
    private String title;
    private Integer ticket = 10;

    public MyThread(String title) {
        this.title = title;
    }

//    @Override
//    public void run() {
//        for (int x = 0; x < 10; x++) {
//            System.out.println(this.title + ",x=" + x);
//        }
//    }

    public MyThread() {
    }

    @Override
    public void run() {
        for (int x = 0; x < 20; x++) {
            if (this.ticket > 0)
                System.out.println( "卖票：ticket=" + this.ticket--);

        }
    }

    public static void main(String[] args) {
//        MyThread m1 = new MyThread("线程A");
//        MyThread m2 = new MyThread("线程B");
//        MyThread m3 = new MyThread("线程C");
////        m1.run();
////        m2.run();
////        m3.run();
//        //启动多线程应使用start方法
//        m1.start();
//        m2.start();
//        m3.start();

        //测试卖票
        new MyThread().start();
        new MyThread().start();
        new MyThread().start();
    }

}
