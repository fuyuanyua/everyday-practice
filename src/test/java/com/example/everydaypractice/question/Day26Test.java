package com.example.everydaypractice.question;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: Day26Test
 * @Author: lhb
 * @Date: 2021/7/30 下午5:10
 */

@Slf4j
class Day26Test {

    @Test
    void solution1() {
        int[] nums = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        log.info("input = {}", nums);
        int result = Day26.solution1(nums);
        log.info("output = {}", result);
    }
}