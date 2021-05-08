package com.example.demo.sort;

import java.util.*;


/**
 * 求最小的k个数
 *
 * @author wmqing
 * @Date 2021/5/8 13:36
 **/
public class KLeastNumber {

    public static void main(String[] args) {
        int[] input = new int[]{3, 2, 1, 5, 6, 4};
        int kth = findKth(input, 6, 2);
        System.out.println(kth);
    }

    /**
     * 寻找第K大元素
     *
     * @param a
     * @param n
     * @param K
     * @return
     */
    public static int findKth(int[] a, int n, int K) {
        //不指定comparator是最小优先队列
        PriorityQueue<Integer> queue = new PriorityQueue<>(K);
        for (int num : a) {
            //如果优先队列小于K,则入队
            //或者遍历元素大于堆顶，则让堆顶出队，遍历元素入队
            if (queue.size() < K || num > queue.peek()) {
                if (queue.size() >= K) {
                    queue.poll();
                }
                queue.offer(num);
            }
        }
        return queue.size() == 0 ? 0 : queue.peek();
    }

    /**
     * 创建最大堆
     *
     * @param input
     * @param k
     * @return
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution3(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (k > input.length || input.length == 0) {
            return list;
        }
        //添加了Comparator,建立最大优先队列，即队头是最大元素
        PriorityQueue<Integer> queue = new PriorityQueue<>((num1, num2) -> num2 - num1);
        for (int i = 0; i < k; i++) {
            queue.offer(input[i]);
        }
        //建立大根堆，堆顶是k个中最大的元素。因为要找出最小的k个数，如果遍历元素大于堆顶，则跳过该元素。
        //如果遍历元素小于堆顶，则移除堆顶，重新对遍历元素入队
        for (int i = k; i < input.length - 1; i++) {
            if (input[i] < queue.peek()) {
                //如果小于，删除堆顶元素
                queue.poll();
                //遍历元素，重新入队
                queue.offer(input[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            list.add(queue.poll());
        }
        return list;
    }

    /**
     * 解法二：对解法一稍微做了优化，效率稍微改进一点点吧
     * 先对数组进行划分两个，如果k小于第一个分区，就只对第一段进行快排
     *
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (k > input.length || input.length == 0) {
            return list;
        }
        int pivot = partition(input, 0, input.length - 1);
        if ((pivot + 1) > k) {
            qsort(input, 0, pivot - 1);
        } else {
            qsort(input, 0, input.length - 1);
        }
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    /**
     * 解法一：先对数组进行快速排序，然后取前k个
     *
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (k > input.length) {
            return list;
        }
        qsort(input, 0, input.length - 1);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    public static void qsort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            qsort(arr, low, pivot - 1);
            qsort(arr, pivot + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }
}
