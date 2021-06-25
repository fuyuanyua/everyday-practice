package com.example.everydaypractice.question;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: Day02Test
 * @Author: lhb
 * @Date: 2021/6/25 下午7:13
 */

@Slf4j
class Day02Test {

    @Test
    void solution1() {
        int[] nums = new int[] {2, 7, 11, 15};
        int target = 9;
        log.info("input = {}, {}", nums, target);
        int[] result = Day02.solution1(nums, target);
        log.info("output = {}", result);
    }

    @Test
    void solution2() {
        int[] nums = new int[] {2, 7, 11, 15};
        int target = 17;
        log.info("input = {}, {}", nums, target);
        int[] result = Day02.solution2(nums, target);
        log.info("output = {}", result);
    }
}