package com.example.demo.entity;

/**
 * 链表实体
 *
 * @author wmqing
 * @Date 2020/10/30 18:00
 **/
public class ListNode {

    int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
