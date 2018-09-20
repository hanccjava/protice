package com.threads;

/**
 * @Auther: ReXin
 * @Date: 2018/8/27 22:21
 * @Description: Runnable接口实现线程
 */
public class MyRunnable implements Runnable {
    private String title;
    private Integer ticket = 10;

    public MyRunnable(String title) {
        this.title = title;
    }

    //    @Override
//    public void run() {
//        for (int x = 0; x < 10; x++) {
//            System.out.println(this.title + ",x=" + x);
//        }
//    }
    @Override
    public void run() {
        for (int x = 0; x < 20; x++) {
//            synchronized (this) {
//                if (this.ticket > 0) {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("卖票：ticket=" + this.ticket--);
//
//                }
//            }
            this.sale();
        }
    }

    public synchronized void sale() {
        synchronized (this) {
            if (this.ticket > 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("卖票：ticket=" + this.ticket--);

            }
        }
    }


    public static void main(String[] args) {
        MyRunnable m = new MyRunnable("线程A");
//        MyRunnable m2 = new MyRunnable("线程B");
//        MyRunnable m3 = new MyRunnable("线程C");
        //多线程的启动永远都是Thread类的start方法
        new Thread(m).start();
        new Thread(m).start();
        new Thread(m).start();
    }
}
