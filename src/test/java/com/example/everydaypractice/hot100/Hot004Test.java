package com.example.everydaypractice.hot100;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @Description: Hot004Test
 * @Author: lhb
 * @Date: 2021/8/26 下午7:55
 */

@Slf4j
class Hot004Test {

    private final static int[] nums = new int[] {2, 2, 1, 1, 1, 2, 2};

    @Test
    void solution1() {
        log.info("input = {}", nums);
        int result = Hot004.solution1(nums);
        log.info("output = {}", result);
    }

    @Test
    void solution2() {
        log.info("input = {}", nums);
        int result = Hot004.solution2(nums);
        log.info("output = {}", result);
    }
}