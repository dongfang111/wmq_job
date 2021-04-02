package com.example.demo.agorithm.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 用LinkedHashMap实现LRU算法
 *
 * @author wmqing
 * @Date 2021/3/14 21:44
 **/
public class LRU<K, V> extends LinkedHashMap<K, V> implements Map<K, V> {

    /**
     * 构造器
     * @param initialCapacity 容量
     * @param loadFactor 负载因子
     * @param accessOrder true代表访问顺序，false代表插入顺序
     */
    public LRU(int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
    }

    /**
     * 重写removeEldestEntry方法，当元素超过6个时，删除最不经常使用的元素，最不经常使用是双向链表里面before后面的第一个元素
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Entry<K, V> eldest) {
        return size() > 6;
    }

    public static void main(String[] args) {
        //按照访问顺序排序
        LRU<Character, Integer> lru = new LRU<>(6, 0.75f, true);
        String s = "abcdefghijk";
        for (int i = 0; i < s.length(); i++) {
            lru.put(s.charAt(i), i);
        }
        System.out.println(lru.get('h'));
        System.out.println(lru.size());
        System.out.println(lru);
    }
}
