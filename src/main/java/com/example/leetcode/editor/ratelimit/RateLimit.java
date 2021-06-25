package com.example.leetcode.editor.ratelimit;

import java.util.concurrent.TimeUnit;

import lombok.SneakyThrows;

/**
 * 限流
 *
 * @author: lijiawei04
 * @date: 2021/6/23 1:26 下午
 */
public interface RateLimit {

    /**
     * 尝试是否可以通过限流
     *
     * @return 是/否
     */
    boolean tryAcquire();

    /**
     * 测试一下
     *
     * @param requestNumber 请求数
     * @param interval      请求之间时间间隔
     */
    default void run(long requestNumber, long interval) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < requestNumber; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + System.currentTimeMillis() + "---" + tryAcquire());
            sleep(interval);
        }

        System.out.println("总耗时:" + (System.currentTimeMillis() - start));
    }

    @SneakyThrows
    static void sleep(long mills) {
        TimeUnit.MILLISECONDS.sleep(mills);
    }

}
