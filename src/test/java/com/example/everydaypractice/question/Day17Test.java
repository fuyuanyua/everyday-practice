package com.example.everydaypractice.question;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: Day17Test
 * @Author: lhb
 * @Date: 2021/7/16 下午6:52
 */

@Slf4j
class Day17Test {

    @Test
    void solution1() throws Exception {
        String date = "2019-12-31";
        log.info("input = {}", date);
        int result = Day17.solution1(date);
        log.info("output = {}", result);
    }
}