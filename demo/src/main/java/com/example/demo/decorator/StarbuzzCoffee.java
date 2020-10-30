package com.example.demo.decorator;

import com.example.demo.decorator.decorate.Mocha;
import com.example.demo.decorator.decorate.Soy;
import com.example.demo.decorator.decorated.Espresso;
import com.example.demo.decorator.decorated.HouseBlend;

/**
 * @author 王明卿
 * @version 1.0
 * @since 2020/4/19 12:42
 **/
public class StarbuzzCoffee {

    public static void main(String[] args) {
        Beverage beverage = new Espresso(); //不加配料
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage2 = new HouseBlend();
        beverage2 =  new Mocha(beverage2); //1.加摩卡
        beverage2 = new Mocha(beverage2); //2.再加一份摩卡
        beverage2 = new Soy(beverage2); //3.加豆浆
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
    }
}
