package com.example.demo.pattern.factory;

/**
 * @author wmqing
 * @Date 2020/12/4 18:02
 **/
public abstract class AbstractHumanFactory {

    public abstract <T extends Human> T createHuman(Class<T> c);
}
