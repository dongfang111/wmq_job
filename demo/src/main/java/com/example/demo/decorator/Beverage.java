package com.example.demo.decorator;

/**
 * 饮料被装饰者
 * @author 王明卿
 * @version 1.0
 * @since 2020/4/18 22:47
 **/
public abstract class Beverage {

    public String description = "Unknown Beverage";

    public String getDescription(){
        return description;
    }

    public abstract double cost();
}
