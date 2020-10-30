package com.example.demo.proxy;/**
 * Created by hkrt on 2019/4/16.
 */

import java.lang.reflect.Proxy;

/**
 * @author 王明卿
 * @version 1.0
 * @since 2019/4/16 15:30
 **/
public class TestProxy {

    public static void main(String[] args) {
        Subject  subject  = (Subject)Proxy.newProxyInstance(TestProxy.class.getClassLoader(), new Class[]{Subject.class}, new JdkProxySubject(new RealSubject()));
        subject.request();
        subject.hello();
    }
}
