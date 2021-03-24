package com.example.demo.agorithm;

import com.example.demo.agorithm.reverse.ListNode;

/**
 * 判断相交链表
 *  4-->1-->8-->4-->5和5-->0-->1-->8-->4-->5
 * @author wmqing
 * @Date 2021/3/24 15:01
 **/
public class IntersectionNode {
    /**
     * 1.暴力破解法
     */
    public static ListNode getIntersectionNode(ListNode l1, ListNode l2) {
        ListNode p = l1, q;
        while (p != null) {
            q = l2;
            while (q != null){
                if (p == q) {
                    return p;
                }
                q = q.next;
            }
            p = p.next;
        }
        return null;
    }

    public static void main(String[] args) {
        //创建相交那部分链表
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(5);
        //链表aa
        ListNode aa = new ListNode(4);
        aa.next = l1;
        //链表bb
        ListNode bb = new ListNode(5);
        bb.next = new ListNode(0);
        bb.next.next = l1;
        //找出相交链表
        ListNode intersectionNode = getIntersectionNode(aa, bb);
        ListNode p = intersectionNode;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
