package com.example.leetcode.editor;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author: lijiawei04
 * @date: 2021/6/11 6:19 下午
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(getTodayPassSecond());
    }

    /**
     * 获取今日已经过去的时间(单位:s)
     *
     * @return 今日已经过去的时间
     */
    private static Long getTodayPassSecond() {
        LocalDateTime nowDay = LocalDateTime.now();
        LocalDateTime nowDayStart = LocalDateTime.of(nowDay.getYear(), nowDay.getMonth(), nowDay.getDayOfMonth(), 0, 0, 0);
        return Duration.between(nowDayStart, LocalDateTime.now()).getSeconds();
    }

}
