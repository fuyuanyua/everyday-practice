package com.example.everydaypractice.question;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: Day24Test
 * @Author: lhb
 * @Date: 2021/7/28 下午7:35
 */

@Slf4j
class Day24Test {

    @Test
    void solution1() {
        int n = 11;
        log.info("input = {}", n);
        int[] result = Day24.solution1(n);
        log.info("output = {}", result);
    }
}