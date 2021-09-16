package com.example.everydaypractice.hot100;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: Hot006Test
 * @Author: lhb
 * @Date: 2021/9/16 下午7:56
 */

@Slf4j
class Hot006Test {

    @Test
    void solution1() {
        int[] nums = new int[] {0, 1, 0, 3, 12};
        log.info("before：{}", nums);
        Hot006.solution1(nums);
        log.info("after：{}", nums);
    }
}