package com.factory;

import com.factory.impl.Apple;
import com.factory.interfaces.IFruit;
import com.factory.interfaces.IMessage;

import java.lang.reflect.Method;

public class Factory {
    @SuppressWarnings("unchecked")
    public static <E> E getInstance(String className) {
        E object = null;
        try {
            object = (E) Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    public static void main(String[] args) {
        IFruit fruit = Factory.getInstance("com.factory.impl.Apple");
        fruit.eat();
        IMessage message = Factory.getInstance("com.factory.impl.MessageImpl");

        message.print();
       // System.out.println(Apple.class.getPackage().getName());
        String attribute = "name";
        String value = "YAR";
        try {
            Class<?> cls = Class.forName("com.factory.impl.Apple");
            Object obj = cls.getDeclaredConstructor().newInstance();
            Method setMethod = cls.getMethod("set" + initCap(attribute),String.class);
            setMethod.invoke(obj,value);
            Method getMethods = cls.getMethod("get" + initCap(attribute));
            Object ret = getMethods.invoke(obj);
            System.out.println(ret);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String initCap(String str){
        return str.substring(0,1).toUpperCase() + str.substring(1);
    }
}
