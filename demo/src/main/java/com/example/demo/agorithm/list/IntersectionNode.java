package com.example.demo.agorithm.list;

import com.example.demo.agorithm.list.reverse.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 判断相交链表
 * 4-->1-->8-->4-->5和5-->0-->1-->8-->4-->5
 *
 * @author wmqing
 * @Date 2021/3/24 15:01
 **/
public class IntersectionNode {
    /**
     * 1.暴力破解法
     * 复杂度分析
     * <p>
     * 时间复杂度 : (mn)双层循环
     * 空间复杂度 : O(1)
     */
    public static ListNode getIntersectionNode(ListNode l1, ListNode l2) {
        ListNode p = l1, q;
        while (p != null) {
            q = l2;
            while (q != null) {
                if (p == q) {
                    return p;
                }
                q = q.next;
            }
            p = p.next;
        }
        return null;
    }

    /**
     * 2.哈希表法
     * 复杂度分析
     * <p>
     * 时间复杂度 : O(m+n) 两个while循环
     * 空间复杂度 : O(m)或 O(n)。lMap的创建
     */
    public static ListNode getIntersectionNode2(ListNode l1, ListNode l2) {

        ListNode p = l1;
        Map<ListNode, ListNode> lMap = new HashMap<>();
        while (p != null) {
            lMap.put(p, p);
            p = p.next;
        }
        ListNode q = l2;
        while (q != null) {
            if (lMap.get(q) != null) {
                return q;
            }
            q = q.next;
        }
        return null;
    }

    /**
     * 3.A+B=B+A方法
     */
    public static ListNode getIntersectionNode3(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        while (p != q) {
           //如果当前链表为空了，则指向另外一个链表
           p = p == null ? l2 : p.next;
           q = q == null ? l1 : q.next;
        }
        return p;
    }

    public static void main(String[] args) {
        //创建相交那部分链表
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(5);
        //链表aa
        ListNode aa = new ListNode(4);
//        aa.next = l1;
        //链表bb
        ListNode bb = new ListNode(5);
        bb.next = new ListNode(0);
//        bb.next.next = l1;
        //找出相交链表
        ListNode intersectionNode = getIntersectionNode3(aa, bb);
        ListNode p = intersectionNode;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
