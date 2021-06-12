package com.example.leetcode.editor.sort;

import com.example.leetcode.editor.sort.util.SortUtil;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author: lijiawei04
 * @date: 2021/6/8 2:41 下午
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] a = SortUtil.getRandomArray(20);

        System.out.println(Arrays.toString(a));
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    a[i] += a[j];
                    a[j] = a[i] - a[j];
                    a[i] = a[i] - a[j];
                }
            }
        }
    }

}
