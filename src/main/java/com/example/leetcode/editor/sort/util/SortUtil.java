package com.example.leetcode.editor.sort.util;

import java.util.Arrays;
import java.util.Random;

/**
 * @author: lijiawei04
 * @date: 2021/6/9 7:26 下午
 */
public class SortUtil {

    private static final Random SEED = new Random();

    public static int[] getRandomArray(int n) {
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = SEED.nextInt(100);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getRandomArray(30)));
    }

}
