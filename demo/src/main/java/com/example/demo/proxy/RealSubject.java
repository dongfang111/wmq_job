package com.example.demo.proxy;

import org.springframework.stereotype.Component;

/**
 * @author 王明卿
 * @version 1.0
 * @since 2019/4/16 15:20
 **/
@Component
public class RealSubject implements Subject{

    public void request() {
        System.out.println("RealSubject request sout");
    }

    public void hello() {
        System.out.println("RealSubject hello sout");
    }
}
