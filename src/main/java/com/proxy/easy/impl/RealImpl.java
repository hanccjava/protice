package com.proxy.easy.impl;

import com.proxy.easy.interfaces.ISubject;

/**
 * 负责真实业务实现
 * Created by hpy on 2018/8/15.
 */
public class RealImpl implements ISubject {

    @Override
    public void save() {
        System.out.println("我闯进了代理模式的大门");
    }
}
