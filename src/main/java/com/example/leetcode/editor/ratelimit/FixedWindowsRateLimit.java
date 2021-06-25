package com.example.leetcode.editor.ratelimit;

/**
 * 固定时间窗口限流算法
 *
 * @author: lijiawei04
 * @date: 2021/6/23 12:58 下午
 */
public class FixedWindowsRateLimit implements RateLimit {

    /**
     * WINDOWS_UNIT 时间内最多允许 THRESHOLD 个请求
     */
    private static final long WINDOWS_UNIT = 1000L;
    private static final long THRESHOLD = 3L;

    private long lastRequestTime = 0L;
    private long counter = 0L;

    public boolean tryAcquire() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastRequestTime > WINDOWS_UNIT) { // 检查是否在时间窗口内
            counter = 0;    // 计数器清0
            lastRequestTime = currentTime;
        }

        if (counter < THRESHOLD) {  // 小于阈值，请求有效
            counter++;      // 计数器加1
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        RateLimit rateLimit = new FixedWindowsRateLimit();
        rateLimit.run(100, 10);
    }

}
