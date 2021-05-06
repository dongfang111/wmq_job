package com.example.demo.agorithm.list.reverse;

/**
 * @author wmqing
 * @Date 2021/5/6 12:53
 **/
public class TestReverseList {

    public static ListNode reverseList(ListNode head) {

        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            ListNode next = current.next;

            current.next = prev;
            prev = current;

            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode listNode = mergeSortList(l1, l2);

        ListNode head = listNode;
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode mergeSortList(ListNode l1, ListNode l2){
        ListNode newList = new ListNode(-1);
        ListNode newP = newList;
        ListNode p1 = l1;
        ListNode q1 = l2;
        while (p1 != null && q1 != null) {
            if (p1.val <= q1.val) {
                newP.next = p1;
                p1 = p1.next;
            } else {
                newP.next = q1;
                q1 = q1.next;
            }
            newP = newP.next;
        }
        newP.next = (p1 == null) ? q1 : p1;
        return newList.next;
    }
}
