package com.example.demo.pattern.factory;

/**
 * @author wmqing
 * @Date 2020/12/4 17:59
 **/
public class YellowHuman implements Human{

    @Override
    public void getColor() {
        System.out.println("黄色人种的皮肤颜色是黄色");
    }

    @Override
    public void talk() {
        System.out.println("黄色人种讲话");
    }
}
