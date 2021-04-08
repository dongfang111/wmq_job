package com.example.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * @author wmqing
 * @Date 2020/11/27 16:36
 **/
public class MainClass {

    public static void main(String[] args) throws ParseException {
        String date = "2017-10-23 15:37:20.0";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date parse = dateFormat.parse(date);
        System.out.println(parse);

        new HashMap<>();
    }
}
