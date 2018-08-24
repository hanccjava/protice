package com.resources;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * 配置文件的读取
 * Created by hpy on 2018/8/23.
 */
public class ResourceRead {
    public static void main(String[] args) throws IOException {
        //第一种方式：ResourceBundle读取。该类基于类读取属性文件：将属性文件当作类，不加后缀
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Han");
        System.out.println(resourceBundle.getString("cn.welcome.info"));


        //第二种方式：通过Properties类借助IO流读取配置文件
        InputStream inputStream = ResourceRead.class.getClassLoader().getResourceAsStream("han.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        inputStream.close();
        System.out.println(properties.getProperty("cn.welcome.info"));


        //ResourceBundle类只能读取内容，如果想要编辑内容，还需要使用properties
        Properties pro = new Properties();
        pro.setProperty("bj", "我生存工作的地方");
        pro.setProperty("yc", "生我养我的地方");
        pro.setProperty("cq", "我魂牵梦萦想要生活的地方");
        System.out.println(pro.getProperty("bj"));
        System.out.println(pro.getProperty("yc"));
        System.out.println(pro.getProperty("cq"));

        //把属性保存到配置文件中
        //D:\protice_test\protice\src\main
        //    pro.store(new FileOutputStream(new File("D:" + File.separator + "protice_test" + File.separator + "protice" + File.separator + "src" + File.separator + "main" + File.separator + "resource" + File.separator + "Han.properties")), "Supplement Info");
        //可以写绝对路径，和src下写，两种方式
        pro.store(new FileOutputStream(new File("src" + File.separator + "main" + File.separator + "resource" + File.separator + "Han.properties")), "Supplement Info");

    }
}
