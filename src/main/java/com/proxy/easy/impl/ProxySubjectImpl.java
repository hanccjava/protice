package com.proxy.easy.impl;

import com.factory.Factory;
import com.proxy.easy.interfaces.ISubject;

/**
 * 代理对象
 * Created by txsk on 2018/8/15.
 */
public class ProxySubjectImpl implements ISubject {
    /**
     * 真正的操作业务
     */
    private ISubject subject;

    /**
     * 在创建代理类对象的时候，必须设置要代理的真实主题
     *
     * @param subject
     */
    public  ProxySubjectImpl(ISubject subject) {
        this.subject = subject;
    }
    public ProxySubjectImpl(){

    }

    public void broke() {
        System.out.println("打开思路");
    }

    public void get() {
        System.out.println("拿下代理模式");
    }

    /**
     * 接口子类实现抽象方法
     */
    @Override
    public void save() {
        this.broke();
        this.subject.save();
        this.get();
    }

    public static void main(String[] args) {
        ISubject subject = Factory.getInstance("com.proxy.easy.impl.ProxySubjectImpl",new RealImpl());
        subject.save();
    }
}
