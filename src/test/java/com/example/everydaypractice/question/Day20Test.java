package com.example.everydaypractice.question;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: Day20Test
 * @Author: lhb
 * @Date: 2021/7/21 下午7:29
 */

@Slf4j
class Day20Test {

    @Test
    void solution1() {
        String s = "ab##cd#a#b";
        String t = "ad##cc#b";
        log.info("input = {}, {}", s, t);
        boolean result = Day20.solution1(s, t);
        log.info("output = {}", result);
    }
}