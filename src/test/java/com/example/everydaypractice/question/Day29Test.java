package com.example.everydaypractice.question;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: Day29Test
 * @Author: lhb
 * @Date: 2021/8/4 下午9:12
 */

@Slf4j
class Day29Test {

    @Test
    void solution1() {
        int[] nums = new int[] {1, 3, 5, 4, 7};
        log.info("input = {}", nums);
        int result = Day29.solution1(nums);
        log.info("output = {}", result);
    }
}