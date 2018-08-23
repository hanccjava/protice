package com.proxy.act;

import com.proxy.easy.impl.RealImpl;
import com.proxy.easy.interfaces.ISubject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * Created by hpy on 2018/8/23.
 */
public class ActProxy implements InvocationHandler {

    private Object realSubject;

    /**
     * 绑定真是接口子类对象，动态创建此对象
     *
     * @param realSubject 真是主题
     * @return Object 真是主题对象
     */
    public Object bind(Object realSubject) {
        this.realSubject = realSubject;
        //Proxy类的newProxyInstance方法，可绑定目标接口子类对象，该对象为动态创建
        return Proxy.newProxyInstance(realSubject.getClass().getClassLoader(), realSubject.getClass().getInterfaces(), this);
    }

    public void prepare() {
        System.out.println("准备开始了，测试这套代码能不能行得通");
    }

    public void conclusion() {
        System.out.println("走到这一步，证明动态代理是实现了的");
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.prepare();
        //关于method,invoke()方法，如果反射的是静态方法，第一个参数可以传为null
        Object ret = method.invoke(this.realSubject, args);
        this.conclusion();
        return ret;
    }

    public static void main(String[] args) {
        ISubject subject = (ISubject) new ActProxy().bind(new RealImpl());
        subject.save();
        subject.eat();
    }
}
