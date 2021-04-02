package com.example.demo.agorithm.list.reverse;

/**
 * 链表节点
 *
 * @author wmqing
 * @Date 2021/3/23 10:56
 **/
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    /**
     * 添加新的节点
     *
     * @param newVal 新的key值
     */
    public void add(int newVal) {
        ListNode listNode = new ListNode(newVal);
        if (this.next == null) {
            this.next = listNode;
        } else {
            this.next.add(newVal);
        }
    }
}
