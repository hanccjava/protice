package com.resources;

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

    }
}
