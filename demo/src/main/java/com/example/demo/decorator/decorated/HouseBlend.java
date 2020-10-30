package com.example.demo.decorator.decorated;

import com.example.demo.decorator.Beverage;

/**
 * 综合咖啡
 * @author 王明卿
 * @version 1.0
 * @since 2020/4/18 22:58
 **/
public class HouseBlend extends Beverage{

    public HouseBlend(){
        description = "House Blend coffee";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
