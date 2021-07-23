package com.example.everydaypractice.question;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: Day22Test
 * @Author: lhb
 * @Date: 2021/7/23 下午7:53
 */

@Slf4j
class Day22Test {

    @Test
    void solution1() {
        int[] row1 = new int[] {4, 3, 2, -1};
        int[] row2 = new int[] {3, 2, 1, -1};
        int[] row3 = new int[] {1, 1, -1, -2};
        int[] row4 = new int[] {-1, -1, -2, -3};
        int[][] input = new int[4][4];
        input[0] = row1;
        input[1] = row2;
        input[2] = row3;
        input[3] = row4;
        log.info("input = {}", input);

        int result = Day22.solution1(input);
        log.info("output = {}", result);
    }
}