package com.example.everydaypractice.question;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: Day28Test
 * @Author: lhb
 * @Date: 2021/8/3 下午5:40
 */

@Slf4j
class Day28Test {

    @Test
    void solution1() {
        int[] nums = new int[] {1, 2, 3, 2, 2, 2, 5, 4, 2};
        log.info("input = {}", nums);
        int result = Day28.solution1(nums);
        log.info("output = {}", result);
    }

    @Test
    void solution2() {
        int[] nums = new int[] {1, 2, 3, 2, 2, 2, 5, 4, 2};
        log.info("input = {}", nums);
        int result = Day28.solution2(nums);
        log.info("output = {}", result);
    }
}