package com.example.demo.observer.push;

/**
 * 显示当前天气的仪器-观察者的具体类
 * @author 王明卿
 * @version 1.0
 * @since 2020/4/5 21:17
 **/
public class NowConditionDisplay implements Observer {

    private float temperature;
    private float humidity;
    private WeatherData weatherData;

    //通过构造器将主题注入，并把被观察者注册进去
    public NowConditionDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        //改变当前观察者气象数据
        this.temperature = temp;
        this.humidity = humidity;
        //显示气象数据
        display();
    }

    public void display() {
        System.out.println("[push] 当前温度:" + temperature + " 当前湿度: " + humidity);
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }
}
