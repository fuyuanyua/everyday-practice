package com.example.everydaypractice.question;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: Day18Test
 * @Author: lhb
 * @Date: 2021/7/19 下午7:20
 */

@Slf4j
class Day18Test {

    @Test
    void solution1() {
        int[] nums = new int[] {1, 1, 1, 1, 1, 4};
        int result = Day18.solution1(nums);
        log.info("result = {}", result);
    }
}