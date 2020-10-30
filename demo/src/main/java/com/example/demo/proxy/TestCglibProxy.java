package com.example.demo.proxy;


import org.springframework.cglib.proxy.Enhancer;

/**
 * @author 王明卿
 * @version 1.0
 * @since 2019/4/16 17:38
 **/
public class TestCglibProxy {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject.class);
        enhancer.setCallback(new DemoMethodInterceptor());
        RealSubject realSubject = (RealSubject)enhancer.create();
        realSubject.request();
    }
}
