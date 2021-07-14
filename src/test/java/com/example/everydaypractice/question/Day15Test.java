package com.example.everydaypractice.question;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: Day15Test
 * @Author: lhb
 * @Date: 2021/7/14 下午6:48
 */

@Slf4j
class Day15Test {

    @Test
    void solution1() {
        int n = -10004324;
        log.info("input = {}", n);
        String result = Day15.solution1(n);
        log.info("output = {}", result);
    }
}