package com.example.everydaypractice.question;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: Day04Test
 * @Author: lhb
 * @Date: 2021/6/29 下午6:38
 */

@Slf4j
class Day04Test {

    @Test
    void solution1() {
        int[] nums = new int[] {1, 2, 3, 1};
        log.info("input = {}", nums);
        boolean result = Day04.solution1(nums);
        log.info("output = {}", result);
    }

    @Test
    void solution2() {
        int[] nums = new int[] {1, 2, 3, 1};
        log.info("input = {}", nums);
        boolean result = Day04.solution2(nums);
        log.info("output = {}", result);
    }
}