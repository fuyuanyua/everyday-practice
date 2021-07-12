package com.example.everydaypractice.question;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: Day13Test
 * @Author: lhb
 * @Date: 2021/7/12 下午6:37
 */

@Slf4j
class Day13Test {

    @Test
    void solution1() {
        int n = 234;
        log.info("input = {}", n);
        int result = Day13.solution1(n);
        log.info("output = {}", result);
    }
}