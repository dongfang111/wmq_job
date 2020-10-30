package com.example.demo.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author 王明卿
 * @version 1.0
 * @since 2019/4/15 16:57
 **/
@Component
@Aspect
public class SpringLogAspect {

    @Pointcut("execution(* com.example.aspectj.controller..*.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("AOP Before Advice...");
    }

    @After("pointCut()")
    public void doAfter(JoinPoint joinPoint) {
        System.out.println("AOP After Advice...");
    }

    @AfterReturning(pointcut = "pointCut()", returning = "returnVal")
    public void afterReturn(JoinPoint joinPoint, Object returnVal) {
        System.out.println("AOP AfterReturning Advice:" + returnVal);
    }

    @AfterThrowing(pointcut = "pointCut()", throwing = "error")
    public void afterThrowing(JoinPoint joinPoint, Throwable error) {
        System.out.println("AOP AfterThrowing Advice..." + error);
        System.out.println("AfterThrowing...");
    }

    // 环绕通知：此处有一个坑，当AfterReturning和Around共存时，AfterReturning是获取不到返回值的
    //@Around("pointCut()")
    //public void around(ProceedingJoinPoint pjp) {
    //    System.out.println("AOP Aronud before...");
    //    try {
    //        pjp.proceed();
    //    } catch (Throwable e) {
    //        e.printStackTrace();
    //    }
    //    System.out.println("AOP Aronud after...");
    //}
}
