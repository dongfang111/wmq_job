package com.example.demo.agorithm.list;

import com.example.demo.agorithm.list.reverse.ListNode;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * @author wmqing
 * @Date 2021/3/23 20:53
 **/
public class DeleteDuplicates {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        try {
            ListNode l1 = new ListNode(1);
            l1.next = new ListNode(1);
            l1.next.next = new ListNode(1);
            l1.next.next.next = new ListNode(3);
            l1.next.next.next.next = new ListNode(3);

//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//
//                }
//            }).start();

            ListNode listNode = deleteDuplicates(l1);
            ListNode p = listNode;
//        p.next = null;
//        listNode.next = null;
            while (p != null) {
                System.out.println(p.val);
                p = p.next;
            }
            throw new RuntimeException();
        } finally {
            System.out.println("finally");
        }
    }
}
