package com.example.everydaypractice.hot100;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: Hot005Test
 * @Author: lhb
 * @Date: 2021/8/31 下午8:14
 */

@Slf4j
class Hot005Test {

    private final static int[] nums = new int[] {4, 3, 2, 7, 8, 2, 3, 1};

    @Test
    void solution1() {
        log.info("input = {}", nums);
        List<Integer> result = Hot005.solution1(nums);
        log.info("output = {}", result);
    }

    @Test
    void solution2() {
        log.info("input = {}", nums);
        List<Integer> result = Hot005.solution2(nums);
        log.info("output = {}", result);
    }

    @Test
    void solution3() {
        log.info("input = {}", nums);
        List<Integer> result = Hot005.solution3(nums);
        log.info("output = {}", result);
    }
}