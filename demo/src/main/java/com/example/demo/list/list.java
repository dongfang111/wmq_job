package com.example.demo.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王明卿
 * @version 1.0
 * @since 2020/5/15 18:01
 **/
public class list {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        for (String s : list) {
            if ("2".equals(s)) {
                list.remove(s);
            }
        }
        System.out.println(list.toString());
    }
}
