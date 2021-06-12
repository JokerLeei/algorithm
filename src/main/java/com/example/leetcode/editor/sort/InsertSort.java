package com.example.leetcode.editor.sort;

import com.example.leetcode.editor.sort.util.SortUtil;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author: lijiawei04
 * @date: 2021/6/8 2:54 下午
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] a = SortUtil.getRandomArray(20);

        System.out.println(Arrays.toString(a));
        inertSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void inertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    a[j] += a[j - 1];
                    a[j - 1] = a[j] - a[j - 1];
                    a[j] = a[j] - a[j - 1];
                }
            }
        }
    }

}
