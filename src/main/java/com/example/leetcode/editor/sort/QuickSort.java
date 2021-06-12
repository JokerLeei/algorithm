package com.example.leetcode.editor.sort;

import com.example.leetcode.editor.sort.util.SortUtil;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author: lijiawei04
 * @date: 2021/6/9 7:22 下午
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = SortUtil.getRandomArray(20);

        System.out.println(Arrays.toString(a));
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public static void quickSort(int[] a, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;

            int pivot = a[i];   // 用子表的第一个记录做基准

            while (i < j) {     // 从表的两端交替向中间扫描
                while (pivot < a[j] && i < j) {
                    j--;
                }
                if (i < j) {
                    a[i++] = a[j];  // 用比基准小的记录替换低位记录
                }
                while (pivot > a[i] && i < j) {
                    i++;
                }
                if (i < j) {
                    a[j--] = a[i];  // 用比基准大的记录替换高位记录
                }
            }

            a[i] = pivot;   // 将基准数值替换回 a[i]

            quickSort(a, left, i - 1);  // 对低子表进行递归排序
            quickSort(a, i + 1, right); // 对高子表进行递归排序
        }
    }

}
