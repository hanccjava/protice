package com.adapter;

/**
 * Created by txsk on 2018/8/16.
 */
public class Adapter extends DispatchingCake implements IEat {
    @Override
    public void eatCake() {
        String a = makeDispatchingCake();
        StringBuffer buffer = new StringBuffer(a);
        buffer.append("->");
        buffer.append("那你送到九龙山地铁站B口吧,我接到蛋糕，赶去五环外");
        buffer.append("->");
        buffer.append("啊！在五环以外及时吃到既好看，又好吃的蛋糕了");
        System.out.println(buffer);
    }

    public static void main(String[] args) {
        
    }
}
