package com.example.everydaypractice.hot100;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: Hot008Test
 * @Author: lhb
 * @Date: 2021/10/8 下午8:14
 */

@Slf4j
class Hot008Test {

    @Test
    void solution1() {
        int nums[] = new int[]{2, 0, 2, 1, 1, 0};
        log.info("input = {}", nums);
        Hot008.solution1(nums);
        log.info("output = {}", nums);
    }
}