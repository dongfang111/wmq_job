package com.example.demo.pattern.factory;

/**
 * @author wmqing
 * @Date 2020/12/4 17:57
 **/
public class BlackHuman implements Human {

    @Override
    public void getColor() {
        System.out.println("黑色人种的皮肤颜色是黑色");
    }

    @Override
    public void talk() {
        System.out.println("黑色人种讲话");
    }
}
