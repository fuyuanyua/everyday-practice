package com.example.everydaypractice.question;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: Day11Test
 * @Author: lhb
 * @Date: 2021/7/8 下午7:37
 */

@Slf4j
class Day11Test {

    @Test
    void solution1() {
        int[] nums = new int[] {1, 1, 1, 2, 2, 2, 3, 3};
        boolean result = Day11.solution1(nums);
        log.info("output = {}", result);
    }
}