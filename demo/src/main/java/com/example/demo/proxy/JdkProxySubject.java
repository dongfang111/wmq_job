package com.example.demo.proxy;

import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author 王明卿
 * @version 1.0
 * @since 2019/4/16 15:23
 **/
@Component
public class JdkProxySubject implements InvocationHandler{

    private RealSubject realSubject;

    public JdkProxySubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object invoke = method.invoke(realSubject, args);
        System.out.println("after");
        return invoke;
    }
}
