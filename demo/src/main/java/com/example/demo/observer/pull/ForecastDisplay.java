package com.example.demo.observer.pull;

import java.util.Observable;
import java.util.Observer;

/**
 * @author 王明卿
 * @version 1.0
 * @since 2020/4/5 22:09
 **/
public class ForecastDisplay implements Observer{

    Observable observable;
    private float currentPressure = 29.92f;
    private float lastPressure;

    public ForecastDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (observable instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            //改变当前观察者气象数据
            lastPressure = currentPressure;
            currentPressure = weatherData.getPressure();
            //显示气象数据
            display();
        }
    }

    public void display() {
        System.out.println("[pull] 本次压力:" + currentPressure + " 上次压力: " + lastPressure);
    }
}
