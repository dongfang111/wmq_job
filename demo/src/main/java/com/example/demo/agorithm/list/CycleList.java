package com.example.demo.agorithm.list;

import com.example.demo.agorithm.list.reverse.ListNode;

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
            //p为入环处
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
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 求出环的长度
     *
     * @param head
     * @return
     */
    public static int hasCycleByFastSlowPointerLength(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int i = 0;
        int length = 0;
        while (fast != null && fast.next != null) {
            length++;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                i++;
                if (i == 1) {
                    length = 0;
                } else if (i == 2) {
                    //第二次相遇，返回累计步长
                    return length;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(-4);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = b;

        //利用set重复元素排除
        //这种在入环处中断循环
        boolean hasCycle = hasCycle(a);
        System.out.println(hasCycle);

        //利用快慢指针
        //快慢指针相遇的地方中断循环，不一定是入环处
        boolean hasCycle2 = hasCycleByFastSlowPointer(a);
        System.out.println(hasCycle2);

        //如何求出环的长度
        System.out.println(hasCycleByFastSlowPointerLength(a));

        //如果有环，判断入环处 TODO


    }
}
