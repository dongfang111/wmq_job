package com.example.demo.observer.pull;

import java.util.Observable;
import java.util.Observer;

/**
 * @author 王明卿
 * @version 1.0
 * @since 2020/4/5 21:41
 **/
public class NowConditionDisplay implements Observer{

    Observable observable;
    private float temperature;
    private float humidity;

    /**
     * 构造器参数是被观察者，然后将观察者注册
     * @param observable
     */
    public NowConditionDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            //改变当前观察者气象数据
            this.humidity = weatherData.getHumidity();
            this.temperature = weatherData.getTemperature();
            //显示气象数据
            display();
        }
    }

    public void display() {
        System.out.println("[pull] 当前温度:" + temperature + " 当前湿度: " + humidity);
    }
}
