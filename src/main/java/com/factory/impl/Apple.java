package com.factory.impl;

import com.factory.interfaces.IFruit;

public class Apple implements IFruit {
    @Override
    public void eat() {
        System.out.println("吃苹果");
    }
}
