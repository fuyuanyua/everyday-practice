package com.example.everydaypractice.hot100;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: Hot009Test
 * @Author: lhb
 * @Date: 2021/10/9 下午8:01
 */

@Slf4j
class Hot009Test {

    @Test
    void solution1() {
        int[] height = new int[]{4, 3, 2, 1, 4};
        log.info("input = {}", height);
        int result = Hot009.solution1(height);
        log.info("output = {}", result);
    }
}