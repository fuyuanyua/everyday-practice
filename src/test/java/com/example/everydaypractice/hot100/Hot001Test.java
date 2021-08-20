package com.example.everydaypractice.hot100;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @Description: Hot001Test
 * @Author: lhb
 * @Date: 2021/8/17 下午8:51
 */

@Slf4j
class Hot001Test {

    @Test
    void solution1() {
        String s = "({[]})";
        log.info("input = {}", s);
        boolean result = Hot001.solution1(s);
        log.info("output = {}", result);
    }
}