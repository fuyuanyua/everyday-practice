package com.example.everydaypractice.hot100;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: Hot002Test
 * @Author: lhb
 * @Date: 2021/8/23 下午8:16
 */

@Slf4j
class Hot002Test {

    @Test
    void solution1() {
        int[] nums = new int[] {4, 1, 2, 1, 2};
        log.info("input = {}", nums);
        int result = Hot002.solution1(nums);
        log.info("output = {}", result);
    }
}