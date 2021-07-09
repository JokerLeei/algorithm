package com.example.leetcode.editor.cn.random;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 遍历一次 随机等概率获取一个元素
 *
 * 一个数：概率 = 1
 * 两个数：第二个数概率为1/2，有1/2的概率替换掉第一个数的结果
 *        so 第一个数概率 = 1 - 1/2 = 1/2
 *           第二个数概率 = 1/2
 * 三个数：第三个数概率为1/3，即有1/3的概率替换掉暂存结果(1/2概率替换掉暂存1，1/2概率替换掉暂存2)
 *        so 第一个数概率 = 1 - 1/2 - (1/2 * 1/3) = 1/3
 *           第二个数概率 = 1/2 - (1/2 * 1/3) = 1/3
 *           第三个数概率 = 1/3
 *
 * N个数以此类推······
 *
 * @author: lijiawei04
 * @date: 2021/6/30 12:26 下午
 */
public class OnceForeachRandom {

    public static void main(String[] args) {
        int[] a = new int[]{ 1, 2, 3, 4, 5 };
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 1000000; i++) {
            int random = random(a);
            if (!map.containsKey(random)) {
                map.put(random, 1);
            }
            else {
                map.put(random, map.get(random) + 1);
            }
        }

        System.out.println(map);
    }

    public static int random(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }

        Random random = new Random();
        int result = 0;
        int index = 1;
        for (int i : a) {
            if (random.nextInt(Integer.MAX_VALUE) % index == 0) {
                result = i;
            }
            index++;
        }

        return result;
    }

}
