package com.example.leetcode.editor.sort;

import com.example.leetcode.editor.sort.util.SortUtil;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author: lijiawei04
 * @date: 2021/6/9 7:10 下午
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] a = SortUtil.getRandomArray(20);

        System.out.println(Arrays.toString(a));
        selectSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void selectSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int index = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[index]) {
                    index = j;
                }
            }
            if (index != i) {
                a[index] += a[i];
                a[i] = a[index] - a[i];
                a[index] = a[index] - a[i];
            }
        }
    }

}
