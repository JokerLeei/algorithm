package com.example.leetcode.editor.ratelimit;

import java.util.Map;
import java.util.TreeMap;

/**
 * 滑动时间窗口限流算法
 *
 * @author: lijiawei04
 * @date: 2021/6/23 4:09 下午
 */
public class SlidingWindowRateLimit implements RateLimit {

    /**
     * 每个时间窗口分为 10 个小窗口
     */
    private static final int SUB_CYCLE = 10;

    /**
     * 每分钟限制 20 个请求, 3 秒一个请求
     */
    private static final int THRESHOLD_PER_MINUTE = 20;

    /**
     * 计数器
     * k: 第几个子窗口
     * v: 该子窗口计数
     */
    private static final Map<Integer, Integer> counters = new TreeMap<>();

    @Override
    public boolean tryAcquire() {
        return false;
    }

    public static void main(String[] args) {
        RateLimit rateLimit = new SlidingWindowRateLimit();
        rateLimit.run(10000, 100);
    }

}
