package com.example.demo.agorithm.list;

import com.example.demo.agorithm.list.reverse.ListNode;

/**
 * 给定一个单链表和一个x，把链表中小于x的放到前面，大于等于x的放到后面，
 * 每部分元素的原始相对位置不变
 * 例如：
 * 给出 1→4→3→2→5→2 x=3
 * 返回 1→2→2→4→3→5
 * 示例1
 * 输入
 * {1,1},0
 * 输出
 * {1,1}
 *
 * @author wmqing
 * @Date 2021/4/21 18:03
 **/
public class PartitionList {

    public static ListNode partition(ListNode head, int x) {
        ListNode p = head;
        ListNode tail = null;
        while (p != null) {
            tail = p;
            p = p.next;
        }
        ListNode preHead = new ListNode(-1);
        preHead.next = head;

        ListNode temp = null;
        ListNode prev = preHead;

        p = head;

        ListNode newListNode = new ListNode(-1);
        ListNode newP = newListNode;
        ListNode tempNew = null;
        while (p.next != null) {
            if (p.val >= x) {
                temp = p;
                prev.next = p.next;

                temp.next = null;
                tail.next = temp;

                tail = temp;

                tempNew = new ListNode(p.next.val);
            } else {
                prev = p;
                tempNew = new ListNode(p.val);
            }
            p = p.next;

            newP.next = tempNew;
            newP = newP.next;
        }
        return newListNode.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(2);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next = new ListNode(2);
        ListNode partition = partition(l1, 3);
        System.out.println(partition);
    }
}
