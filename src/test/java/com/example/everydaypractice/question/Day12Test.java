package com.example.everydaypractice.question;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: Day12Test
 * @Author: lhb
 * @Date: 2021/7/9 下午6:14
 */

@Slf4j
class Day12Test {

    @Test
    void solution1() {
        int n = 50;
        log.info("input = {}", n);
        int result = Day12.solution1(n);
        log.info("output = {}", result);
    }

    @Test
    void solution2() {
        int n = 50;
        log.info("input = {}", n);
        int result = Day12.solution2(n);
        log.info("output = {}", result);
    }
}