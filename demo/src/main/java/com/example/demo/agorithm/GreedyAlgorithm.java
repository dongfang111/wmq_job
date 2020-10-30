package com.example.demo.agorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 贪婪算法
 *
 * @author 王明卿
 * @version 1.0
 * @since 2020/9/24 20:27
 **/
public class GreedyAlgorithm {

    public static void main(String[] args) {

        //存储所有广播台
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();
        //列出各个广播台所覆盖的地区
        HashSet<String> k1 = new HashSet<>();
        k1.add("北京");
        k1.add("上海");
        k1.add("天津");

        HashSet<String> k2 = new HashSet<>();
        k2.add("广州");
        k2.add("北京");
        k2.add("深圳");

        HashSet<String> k3 = new HashSet<>();
        k3.add("成都");
        k3.add("上海");
        k3.add("深圳");

        HashSet<String> k4 = new HashSet<>();
        k4.add("上海");
        k4.add("天津");

        HashSet<String> k5 = new HashSet<>();
        k5.add("杭州");
        k5.add("大连");

        broadcasts.put("k1", k1);
        broadcasts.put("k2", k2);
        broadcasts.put("k3", k3);
        broadcasts.put("k4", k4);
        broadcasts.put("k5", k5);

        //需要覆盖的地区
        HashSet<String> cities = new HashSet<>();
//        cities=getCities(broadcasts);
        cities.add("北京");
        cities.add("上海");
        cities.add("天津");
        cities.add("广州");
        cities.add("深圳");
        cities.add("成都");
        cities.add("杭州");
        cities.add("大连");

        //标记覆盖地区最多的广播台
        String maxKey = null;
        //存储“当前”广播台在“剩余”的地区中能覆盖的地区
        HashSet<String> tempSet = new HashSet<>();
        //存储每一次for循环，选取的广播台
        ArrayList<String> broadcastsList = new ArrayList<>();

        //当所有的地区都已经覆盖完，结束
        while (cities.size() != 0) {

            for (String key : broadcasts.keySet()) {
                //当前广播台覆盖的地区
                HashSet<String> curCities = broadcasts.get(key);
                //存储当前广播台覆盖的地区
                tempSet.addAll(curCities);
                //存储“当前”广播台在“剩余”的地区中能覆盖的地区==curCities与cities的交集
                tempSet.retainAll(cities);
                //检测到当前广播台包含的未覆盖的地区数量，比maxKey广播所包含的地区还多
                if (tempSet.size() > 0 && (maxKey == null || tempSet.size() > broadcasts.get(maxKey).size())) {
                    maxKey = key;
                }
                //清空当前广播台覆盖的地区，为下一次for循环
                tempSet.clear();
            }
            //选取到一个包含未覆盖地区最多的广播台
            if (maxKey != null) {
                broadcastsList.add(maxKey);
                //选取的广播已经覆盖了一部分未覆盖的地区，剩下的即为未覆盖的地区，用于下一次forEach循环
                cities.removeAll(broadcasts.get(maxKey));
            }
            //下一次wihle循环maxKey=null
            maxKey = null;
        }

        //打印选取的广播台
        System.out.println("选取的广播台：" + broadcastsList);
    }

    /**
     * 得到所有广播所覆盖的地区集合
     *
     * @param broadcasts
     * @return
     */
    public static HashSet<String> getCities(HashMap<String, HashSet<String>> broadcasts) {
        HashSet<String> cities = new HashSet<>();
        for (HashSet<String> curCities : broadcasts.values()) {
            cities.addAll(curCities);
        }
        return cities;
    }
}
