package com.example.everydaypractice.question;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: Day27Test
 * @Author: lhb
 * @Date: 2021/8/2 下午6:56
 */

@Slf4j
class Day27Test {

    @Test
    void solution1() {
        int[] nums = new int[] {-5, -6, 1, 2, 3};
        log.info("input = {}", nums);
        int result = Day27.solution1(nums);
        log.info("output = {}", result);
    }

    @Test
    void solution2() {
        int[] nums = new int[] {-5, -6, 1, 2, 3};
        log.info("input = {}", nums);
        int result = Day27.solution2(nums);
        log.info("output = {}", result);
    }
}