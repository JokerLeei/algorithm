package com.example.leetcode.editor.sort;

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
//        mergeSort(array, 0, array.length - 1);
//        bubbleSort(array);
//        selectSort(array);
//        inertSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] a, int left, int right) {
        if (left <  right) {
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
            int mid = (left + right) >> 1;

            mergeSort(a, left, mid);
            mergeSort(a, mid + 1, right);
            merge(a, left, mid, right);
        }
    }

    public static void merge(int[] a, int left, int mid, int right) {
        int[] temp = new int[a.length];
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            }
            else {
                temp[k++] = a[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = a[i++];
        }
        while (j <= right) {
            temp[k++] = a[j++];
        }

        for (int t = left; t <= right; t++) {
            a[t] = temp[t];
        }
    }

    public static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i] < a[j]) {
                    a[i] = a[i] ^ a[j];
                    a[j] = a[i] ^ a[j];
                    a[i] = a[i] ^ a[j];
                }
            }
        }
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
                a[i] = a[i] ^ a[index];
                a[index] = a[i] ^ a[index];
                a[i] = a[i] ^ a[index];
            }
        }
    }

    public static void inertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    a[j] = a[j] ^ a[j - 1];
                    a[j - 1] = a[j] ^ a[j - 1];
                    a[j] = a[j] ^ a[j - 1];
                }
            }
        }
    }

}
