package com.example.demo.decorator.decorated;

import com.example.demo.decorator.Beverage;

/**
 * 意大利浓咖啡
 * @author 王明卿
 * @version 1.0
 * @since 2020/4/18 22:55
 **/
public class Espresso extends Beverage{

    public Espresso(){
        description = "Espresso coffee";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
