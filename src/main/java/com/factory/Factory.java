package com.factory;

import com.factory.interfaces.IFruit;
import com.factory.interfaces.IMessage;
import com.proxy.easy.interfaces.ISubject;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Factory {
    @SuppressWarnings("unchecked")
    public static <E> E getInstance(String className) {
        E object = null;
        try {
            object = (E) Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    /**
     * Class.newInstance方法只能调用无参构造，需使用Constructor.newInstance方法，调用有参构造
     *
     * @param className 包名
     * @param parameter 参数
     * @param <E>       返回类型
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <E,T> E getInstance(String className, T parameter) {
        E object = null;
        try {
            Class clazz = Class.forName(className);
            //通过Class.getConstructor()获取Constructor对象
            Constructor c = clazz.getDeclaredConstructor(ISubject.class);
            //通过Constructor.newInstance方法，获取有参构造
            object = (E) c.newInstance(parameter);
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
            Method setMethod = cls.getMethod("set" + initCap(attribute), String.class);
            setMethod.invoke(obj, value);
            Method getMethods = cls.getMethod("get" + initCap(attribute));
            Object ret = getMethods.invoke(obj);
            System.out.println(ret);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String initCap(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
