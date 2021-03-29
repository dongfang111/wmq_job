package com.example.demo.agorithm;

import com.example.demo.agorithm.reverse.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断是否是环形链表
 *
 * @author wmqing
 * @Date 2021/3/29 13:48
 **/
public class CycleList {

    /**
     * 利用set的key不允许重复的特性，如果放不进去说明有环
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode p = head;
        while (p != null) {
            //set不允许放重复元素，如果add不成功，代表是重复元素
            if (!set.add(p)) {
                return true;
            }
            p = p.next;
        }
        return false;
    }

    /**
     * 利用快慢指针
     *
     * @param head
     * @return
     */
    public static boolean hasCycleByFastSlowPointer(ListNode head) {

        ListNode slow = head.next;
        ListNode fast = head.next.next;

        return false;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode cycleNode = new ListNode(2);

        l1.next = cycleNode;
        cycleNode.next = new ListNode(0);
        cycleNode.next.next = new ListNode(-4);
        cycleNode.next.next.next = cycleNode;

        //利用set重复元素排除
        boolean hasCycle = hasCycle(l1);
        System.out.println(hasCycle);


    }
}
