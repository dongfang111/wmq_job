package com.example.demo.sort;

/**
 * 选择排序
 * 选择排序(Selection-sort)是一种简单直观的排序算法。
 * 它的工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
 * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 以此类推，直到所有元素均排序完毕。
 * <p>
 * 不稳定排序
 *
 * @author 王明卿
 * @version 1.0
 * @since 2020/10/14 19:51
 **/
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 6, 5, 8, 2, 1, 3};
        selectionSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void selectionSort(int[] arr) {
        int minIndex, temp;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}
