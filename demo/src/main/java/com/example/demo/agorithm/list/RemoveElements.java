package com.example.demo.agorithm.list;

import com.example.demo.agorithm.list.reverse.ListNode;


/**
 * 移除链表元素
 * 给你一个链表的头节点 head和一个整数 val ，
 * 请你删除链表中所有满足Node.val==val的节点，并返回新的头节点 。
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * <p>
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 * 哨兵节点广泛应用于树和链表中，如伪头、伪尾、标记等，它们是纯功能的，通常不保存任何数据，
 * 其主要目的是使链表标准化，如使链表永不为空、永不无头、简化插入和删除。
 * @author wmqing
 * @Date 2021/3/23 20:00
 **/
public class RemoveElements {

    public static ListNode removeElements(ListNode head, int removeVal) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;

        ListNode prev = preHead;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == removeVal) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return preHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(6);

        ClassLoader classLoader = l1.getClass().getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());

        l1.next = new ListNode(2);
        l1.next.next = new ListNode(6);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(4);
        l1.next.next.next.next.next = new ListNode(6);

        ListNode listNode = removeElements(l1, 6);
        ListNode head = listNode;
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
