package com.example.everydaypractice.question;

import com.oracle.tools.packager.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: Day03Test
 * @Author: lhb
 * @Date: 2021/6/28 下午6:52
 */

@Slf4j
class Day03Test {

    @Test
    void solution1() {
        int[] nums = new int[] {1, 2, 2, 3};
        log.info("input = {}", nums);
        boolean result = Day03.solution1(nums);
        log.info("result = {}", result);
    }

    @Test
    void solution2() {
        int[] nums = new int[] {1, 2, 2, 3};
        log.info("input = {}", nums);
        boolean result = Day03.solution2(nums);
        log.info("result = {}", result);
    }
}