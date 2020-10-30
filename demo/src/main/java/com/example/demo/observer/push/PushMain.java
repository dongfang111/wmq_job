package com.example.demo.observer.push;

/**
 * @author 王明卿
 * @version 1.0
 * @since 2020/4/5 21:23
 **/
public class PushMain {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        NowConditionDisplay nowConditionDisplay = new NowConditionDisplay(weatherData);

        //气象台改变参数
        weatherData.setMeasurements(20, 10, 30);
    }
}
