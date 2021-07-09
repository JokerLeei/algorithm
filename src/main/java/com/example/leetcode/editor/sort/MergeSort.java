package com.example.leetcode.editor.sort;

import com.example.leetcode.editor.sort.util.SortUtil;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author: lijiawei04
 * @date: 2021/6/18 3:22 下午
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] a = SortUtil.getRandomArray(20);

        System.out.println(Arrays.toString(a));
        mergeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public static void mergeSort(int[] a, int left, int right) {
        if (left < right) {                 // 当数组中只有一个元素时结束递归
            int mid = (left + right) >> 1;  // 划分成两个数组, 左面[left, mid], 右面[mid + 1, right]

            mergeSort(a, left, mid);        // 将左面的数组进行归并递归排序
            mergeSort(a, mid + 1, right);   // 将右面的数组进行归并递归排序
            merge(a, left, mid, right);     // 合并
        }
    }

    /**
     * 两路归并算法，将排好序的两部分数组合成一个有序的数组
     * a 数组分为两部分[left, mid]、[mid + 1, right]，分别各自有序，通过建立一个临时数组，将他们两部分合起来并返回
     */
    private static void merge(int[] a, int left, int mid, int right) {
        int[] temp = new int[a.length];     // 辅助数组
        int p1 = left;      // p1、p2是检测指针，k是存放指针
        int p2 = mid + 1;
        int k = left;

        while (p1 <= mid && p2 <= right) {
            if (a[p1] < a[p2]) {
                temp[k++] = a[p1++];
            }
            else {
                temp[k++] = a[p2++];
            }
        }

        while (p1 <= mid) {
            temp[k++] = a[p1++];    // 如果第一个序列没检测完，直接把后面的元素加到辅助数组中；
        }
        while (p2 <= right) {
            temp[k++] = a[p2++];    // 同上
        }

        for (int i = left; i <= right; i++) {
            a[i] = temp[i];         // 复制回原数组
        }
    }

}
