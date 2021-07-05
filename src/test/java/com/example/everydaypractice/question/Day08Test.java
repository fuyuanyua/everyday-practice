package com.example.everydaypractice.question;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: Day08Test
 * @Author: lhb
 * @Date: 2021/7/5 下午7:22
 */

@Slf4j
class Day08Test {

    @Test
    void solution1() {
        int[] nums = new int[] {4, 2, 1, 3};
        log.info("input = {}", nums);
        int[][] result = Day08.solution1(nums);
        for (int i = 0; i < result.length; i++) {
            log.info("result[{}] = {}", i, result[i]);
        }
    }
}