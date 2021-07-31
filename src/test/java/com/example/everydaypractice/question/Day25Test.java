package com.example.everydaypractice.question;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: Day25Test
 * @Author: lhb
 * @Date: 2021/7/29 下午8:05
 */

@Slf4j
class Day25Test {

    @Test
    void solution1() {
        int[] nums = new int[] {1, 2, 4, 4, 4, 4, 2, 3, 1};
        log.info("input = {}", nums);
        int result = Day25.solution1(nums);
        log.info("output = {}", result);
    }
}