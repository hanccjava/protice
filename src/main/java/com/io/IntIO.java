package com.io;

/**
 * 字节输入流
 * Created by hpy on 2018/8/27.
 */
public class IntIO {
    public static void main(String[] args) {
//        File file = new File("e:" + File.separator + "hello" + File.separator + "hello.txt");
//        try {
//            if(file.exists()){
//                InputStream inputStream = new FileInputStream(file);
//                byte[] bytes = new byte[1024];
//                int len = inputStream.read(bytes);
//                System.out.println("输出的内容为：" + new String(bytes,0,len));
//                inputStream.close();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//
//      }
        System.out.println(Thread.currentThread().getPriority());
    }

}
