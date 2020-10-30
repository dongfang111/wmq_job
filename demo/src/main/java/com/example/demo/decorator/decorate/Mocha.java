package com.example.demo.decorator.decorate;

import com.example.demo.decorator.Beverage;
import com.example.demo.decorator.CondimentDecorator;

/**
 * 摩卡配料
 * @author 王明卿
 * @version 1.0
 * @since 2020/4/18 23:00
 **/
public class Mocha extends CondimentDecorator{

    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",Mocha";
    }

    @Override
    public double cost() {
        return 0.20 + beverage.cost();
    }
}
