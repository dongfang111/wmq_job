package com.example.demo.sort;

/**
 * 冒泡排序
 *
 * @author 王明卿
 * @version 1.0
 * @since 2020/10/14 13:49
 **/
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 7, 2, 40, 30, 27, 50, 4};
        bubbleSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 稳定排序，从小到大排序
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
