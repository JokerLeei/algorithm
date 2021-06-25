package com.example.leetcode.editor;

import com.example.leetcode.editor.sort.util.SortUtil;

import java.util.Arrays;

/**
 * @author: lijiawei04
 * @date: 2021/6/11 6:19 下午
 */
public class Test {

    public static void main(String[] args) {
        int[] array = SortUtil.getRandomArray(20);

        System.out.println(Arrays.toString(array));
//        quickSort(array, 0, array.length - 1);
        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] a, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            int pivot = a[i];

            while (i < j) {
                while (pivot < a[j] && i < j) {
                    j--;
                }
                if (i < j) {
                    a[i++] = a[j];
                }
                while (pivot > a[i] && i < j) {
                    i++;
                }
                if (i < j) {
                    a[j--] = a[i];
                }
            }

            a[i] = pivot;
            quickSort(a, left, i - 1);
            quickSort(a, i + 1, right);
        }
    }

    public static void mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(a, left, mid);
            mergeSort(a, mid + 1, right);
            merge(a, left, mid, right);
        }
    }

    public static void merge(int[] a, int left, int mid, int right) {
        int[] temp = new int[a.length];
        int p1 = left;
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
            temp[k++] = a[p1++];
        }
        while (p2 <= right) {
            temp[k++] = a[p2++];
        }

        for (int i = left; i <= right; i++) {
            a[i] = temp[i];
        }
    }

}
