package com.example.everydaypractice.question;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: Day16Test
 * @Author: lhb
 * @Date: 2021/7/15 下午7:07
 */

@Slf4j
class Day16Test {

    @Test
    void solution1() {
        int[] nums = new int[] {1, 2, 3, 4, 5};
        log.info("input = {}", nums);
        int[] result = Day16.solution1(nums);
        log.info("output = {}", result);
    }

    @Test
    void solution2() {
        int[] nums = new int[] {1, 2, 3, 4, 5};
        log.info("input = {}", nums);
        int[] result = Day16.solution2(nums);
        log.info("output = {}", result);
    }
}