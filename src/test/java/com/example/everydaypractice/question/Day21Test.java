package com.example.everydaypractice.question;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: Day21Test
 * @Author: lhb
 * @Date: 2021/7/22 下午7:41
 */

@Slf4j
class Day21Test {

    @Test
    void sqrt() throws Exception {
        int num = 8;
        int result = Day21.sqrt(num);
        log.info("output = {}", result);
    }
}