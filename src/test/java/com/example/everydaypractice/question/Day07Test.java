package com.example.everydaypractice.question;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: Day07Test
 * @Author: lhb
 * @Date: 2021/7/2 下午7:16
 */

@Slf4j
class Day07Test {

    @Test
    void solution1() {
        String text = "loonbalxballpoon";
        log.info("input = {}", text);
        int result = Day07.solution1(text);
        log.info("result = {}", result);
    }
}