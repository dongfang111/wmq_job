package com.example.demo.observer.push;

/**
 * 观察者超类
 */
public interface Observer {

    void update(float temp, float humidity, float pressure);
}
