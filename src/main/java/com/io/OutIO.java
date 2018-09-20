package com.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * 字节输出流
 * Created by hpy on 2018/8/27.
 */
public class OutIO {
    public static void main(String[] args) {
        File file = new File("e:" + File.separator + "hello" + File.separator + "hello.txt");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            //OutputStream是一个抽象类，需要子类实例化
            OutputStream outputStream = new FileOutputStream(file, true);
            String str = "hello,world";
            outputStream.write(str.getBytes());
            outputStream.write("\r\n".getBytes());
            String chinese = "hello,韩";
            outputStream.write(chinese.getBytes());
            outputStream.write("\r\n".getBytes());
            outputStream.write(str.getBytes(), 1, 3);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
