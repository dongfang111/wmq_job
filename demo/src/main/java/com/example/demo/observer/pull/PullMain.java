package com.example.demo.observer.pull;

/**
 * @author 王明卿
 * @version 1.0
 * @since 2020/4/5 21:48
 **/
public class PullMain {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        NowConditionDisplay nowConditionDisplay = new NowConditionDisplay(weatherData);

        weatherData.setMeasurements(30, 30, 20);
    }

}
