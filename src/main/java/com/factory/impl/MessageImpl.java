package com.factory.impl;

import com.factory.interfaces.IMessage;

public class MessageImpl implements IMessage {
    public void print() {
        System.out.println("工厂模式执行成功了");
    }
}
