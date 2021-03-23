package com.example.demo.agorithm;

import com.example.demo.agorithm.reverse.ListNode;

/**
 * 合并有序链表
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * @author wmqing
 * @Date 2021/3/23 17:47
 **/
public class MergeTwoLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //哨兵节点，这样能比较容易返回合并后的链表
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        //当两个链表其中有一个链表为空时，跳出循环
        while (l1 != null && l2 != null) {
            //分别比较两个链表，如果l1小于等于l2的值，那下一个节点即为l1，同时将l1平移一个节点
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            //每次都需要把prev后移一位
            prev = prev.next;
        }
        //因为链表为有序链表，则不管哪个链表是非空的，它包含的元素都要比前面合并过的元素大。
        //只需要把非空链表接到有序链表的后面
        prev.next = l1 == null ? l2 : l1;
        //返回哨兵节点的下一个节点，即为合并链表的头结点
        return prehead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode listNode = mergeTwoLists(l1, l2);
        ListNode head = listNode;
        while (listNode != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
