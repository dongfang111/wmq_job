package com.example.demo.agorithm.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现 LRUCache 类：
 * <p>
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * <p>
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wmqing
 * @Date 2021/3/17 16:40
 **/
public class LRUCache {

    class LinkedNode {
        int key;
        int value;
        LinkedNode prev;
        LinkedNode next;

        public LinkedNode() {
        }

        public LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, LinkedNode> cache = new HashMap<>();
    private LinkedNode head;
    private LinkedNode tail;
    private int size;
    private int capacity;

    public LRUCache(int capacity) {
        size = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        LinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        removeNode(node);
        removeToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        LinkedNode node = cache.get(key);
        if (node == null) {
            //此时需要创建新节点
            LinkedNode newNode = new LinkedNode(key, value);
            ++size;
            if (size > capacity) {
                //删除尾结点
                tail.prev.next = null;
                //删除哈希表中的tail节点
                cache.remove(tail.key);
                tail = tail.prev;
                removeToHead(newNode);
                --size;
            }
        } else {
            node.value = value;
            removeToHead(node);
        }
    }

    /**
     * 把节点移到头部
     */
    private void removeToHead(LinkedNode node) {
        //如果当前节点为头结点，则不用处理，反之则用处理
        if (head != node) {
            if (node.next == null) {
                //当前元素是尾结点
                //node前一个节点的指向下一个节点为空
                node.prev.next = null;
                tail = node.prev;
            } else {
                //当前节点是中间节点
                node.next.prev = node.prev;
                node.prev.next = node.next;
            }
            node.prev = null;
            node.next = head;
            head = node;
        }
    }

    /**
     * 删除节点
     */
    private void removeNode(LinkedNode node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    public static void main(String[] args) {

    }
}
