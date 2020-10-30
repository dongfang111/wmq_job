package com.example.demo.sort;

import com.example.demo.entity.ListNode;

import java.util.Arrays;

/**
 * 插入排序
 * 稳定排序，适合数据量小，部分数据有序的情况
 *
 * @author wmqing
 * @Date 2020/10/30 17:00
 **/
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {1, 9, 7, 2, 3, 6, 4, 5};
        insertSort(arr);
    }

    /**
     * 数据插入排序
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        int i, j;
        int n = arr.length;
        int target;

        for (i = 1; i < n; i++) {
            j = i;
            target = arr[i];
            while (j > 0 && target < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = target;
            System.out.println("第" + i + "趟排序结果：" + Arrays.toString(arr));
        }
    }

    /**
     * 链表进行插入排序
     *
     * @param head
     * @return
     */
    public ListNode insertSortListNode(ListNode head) {

        return null;
    }
}
