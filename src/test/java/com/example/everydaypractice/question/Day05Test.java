package com.example.everydaypractice.question;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: Day05Test
 * @Author: lhb
 * @Date: 2021/6/30 下午6:57
 */

@Slf4j
class Day05Test {

    @Test
    void solution1() {
        String ransom = "aa";
        String magazine = "aab";
        log.info("input = {}, {}", ransom, magazine);
        boolean result = Day05.solution1(ransom, magazine);
        log.info("output = {}", result);
    }
}