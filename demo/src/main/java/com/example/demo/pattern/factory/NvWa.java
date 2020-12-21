package com.example.demo.pattern.factory;

/**
 * @author wmqing
 * @Date 2020/12/4 18:09
 **/
public class NvWa {

    public static void main(String[] args) {
        AbstractHumanFactory YinYangLu = new HumanFactory();
        YellowHuman yellowHuman = YinYangLu.createHuman(YellowHuman.class);
        yellowHuman.getColor();
        yellowHuman.talk();
    }
}
