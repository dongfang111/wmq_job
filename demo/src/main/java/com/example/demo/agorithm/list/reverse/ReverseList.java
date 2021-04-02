package com.example.demo.agorithm.list.reverse;

/**
 * 反转链表
 *
 * @author wmqing
 * @Date 2021/3/23 11:02
 **/
public class ReverseList {

    //1-->2-->3-->4-->5-->null 反转成 5->4->3->2->1->NULL
    public static ListNode reverseList(ListNode head) {
        //首次当前节点为头结点
        ListNode curr = head;
        //前节点，反转时，当前节点的下一个节点指向前一个节点，需定义一个前置节点
        //头结点的前一个节点为null，在迭代过程中给prev赋值
        ListNode prev = null;
        //迭代
        while (curr != null) {
            //因为要给当前节点下一个节点变更指向为前一个节点，所以保留好当前节点的下一个节点指向
            ListNode next = curr.next;
            //1.变更当前节点的下一个节点指向前置节点(实际操作就这一步)
            curr.next = prev;
            //2.开始下一轮迭代，数据准备
            //2.1 给前置节点赋值为当前迭代节点
            //2.2 迭代节点变更为下一个节点
            prev = curr;
            curr = next;
        }
        //3. 返回反转后的头结点
        return prev;
    }

    /**
     * 给你单链表的头指针 head 和两个整数 left 和 right，其中 left <= right 。
     * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表。
     * 输入 [1,2,3,4,5] left = 2, right = 4 输出：[1,4,3,2,5]
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {

        return null;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        //1.反转链表
        ListNode reverseNode = reverseList(node);

        ListNode head = reverseNode;
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
