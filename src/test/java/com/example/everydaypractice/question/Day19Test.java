package com.example.everydaypractice.question;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: Day19Test
 * @Author: lhb
 * @Date: 2021/7/20 下午4:12
 */

@Slf4j
class Day19Test {

    @Test
    void solution1() {
        String[] strs = new String[] {"flower", "flow", "flight"};
        String result = Day19.solution1(strs);
        log.info("output = {}", result);
    }

    @Test
    void solution2() {
        String[] strs = new String[] {"flower", "flow", "flight"};
        String result = Day19.solution2(strs);
        log.info("output = {}", result);
    }
}