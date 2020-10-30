package com.example.demo.decorator.decorate;

import com.example.demo.decorator.Beverage;
import com.example.demo.decorator.CondimentDecorator;

/**
 * 豆浆
 * @author 王明卿
 * @version 1.0
 * @since 2020/4/19 12:40
 **/
public class Soy extends CondimentDecorator{

    Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",soy";
    }

    @Override
    public double cost() {
        return 0.15 + beverage.cost();
    }
}
