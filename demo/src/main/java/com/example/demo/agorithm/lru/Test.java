package com.example.demo.agorithm.lru;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        LRU lru = new LRU(2);
        lru.set(1, 99);
        lru.set(2, 98);
        lru.set(3, 96);
        lru.get(2);
        System.out.println(lru.get(1));
        HashMap<Integer, Node> map = lru.map;
        System.out.println(map.toString());
    }
}
