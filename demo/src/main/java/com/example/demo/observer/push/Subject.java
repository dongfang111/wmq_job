package com.example.demo.observer.push;

/**
 * push模式，由被观察者推送给观察者
 */
public interface Subject {

    //添加观察者
    void registerObserver(Observer o);

    //删除观察者
    void removeObserver(Observer o);

    //通知观察者
    void notifyObservers();
}
