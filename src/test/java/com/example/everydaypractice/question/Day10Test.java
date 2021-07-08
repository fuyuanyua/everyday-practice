package com.example.everydaypractice.question;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: Day10Test
 * @Author: lhb
 * @Date: 2021/7/7 下午7:02
 */

@Slf4j
class Day10Test {

    @Test
    void solution1() {
        String j = "aA";
        String s = "aAAbbbb";
        log.info("input = {}, {}", j, s);
        int result = Day10.solution1(j, s);
        log.info("output = {}", result);
    }

    @Test
    void solution2() {
        String j = "z";
        String s = "ZZZ";
        log.info("input = {}, {}", j, s);
        int result = Day10.solution2(j, s);
        log.info("output = {}", result);
    }
}