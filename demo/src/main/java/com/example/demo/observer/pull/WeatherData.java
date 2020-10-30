package com.example.demo.observer.pull;

import java.util.Observable;

/**
 * 利用java自带的Observable，这种只能继承
 * @author 王明卿
 * @version 1.0
 * @since 2020/4/5 21:28
 **/
public class WeatherData extends Observable{

    //三个数据
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
    }

    /**
     * 当天气数据更新时，通知观察者
     */
    public void measurementsChanged(){
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure){
        //更改气象数据
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        //通知观察者
        measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
