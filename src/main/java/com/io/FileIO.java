package com.io;

import java.io.File;
import java.io.IOException;

/**
 * IO操作
 * File只是创建文件本身，对其内容不负责
 * Created by hpy on 2018/8/24.
 */
public class FileIO {
    public static void listDir(File file) {
        //判断给出的是不是一个目录
        if (file.isDirectory()) {
            //继续列出该子目录的内容
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    //递归。继续列出
                    listDir(f);
                }
            }
        }
        System.out.println(file);
    }

    public static void main(String[] args) {
        //D:\KDR
        File file = new File("d:" + File.separator + "KDR" + File.separator + "study_io.txt");
        if (file.exists()) {
            file.delete();
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //   java.io.IOException: 系统找不到指定的路径。如果操作的文件不是直接放在根目录下面，一定要判断一下是否存在父目录，如不存在，会报IO异常
        File file1 = new File("e:" + File.separator + "hello" + File.separator + "hello.txt");
        if (!file1.getParentFile().exists()) {
            file1.getParentFile().mkdirs();
        }
        if (file1.exists()) {
            file1.delete();
        } else {
            try {
                file1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        File file2 = new File("d:" + File.separator);
        if (file2.exists() && file2.isDirectory()) {
            File result[] = file2.listFiles();
            for (File f : result) {
                System.out.println(f);
            }

        }

//        new Thread(() -> {
//            File file3 = new File("d:" + File.separator);
//            listDir(file3);
//        }, "列出线程").start();
//        new Thread(()-> System.out.println("Hello World!")).start();
//        System.out.println("···········现在开始进行文件的信息列出··········");
    }


}
