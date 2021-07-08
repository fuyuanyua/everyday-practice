package com.example.everydaypractice.question;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: Day11
 * @Author: lhb
 * @Date: 2021/7/8 下午4:26
 *
 * 1.说明：
 *       给定一副牌，每张牌上都写着一个整数。此时，你需要选定一个数字X，
 *       使我们可以将整副牌按下述规则分成1组或更多组：
 *       每组都有 X 张牌。
 *       组内所有的牌上都写着相同的整数。
 *       仅当你可选的 X >= 2 时返回 true。
 *
 * 2.限制：
 *
 * 3.示例：
 *      输入：[1, 2, 3, 4, 4, 3, 2, 1]
 *      输出：true
 * 4.参考：https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards/
 */

public class Day11 {

    /**
     * 解法1：
     *      思路：
     *          先遍历数组，得到每张牌的数量，再求的各牌数量的最大公约数，
     *          若 >= 2，则返回true
     * @param nums
     * @return
     */
    public static boolean solution1(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }

        // 统计每张牌的张数，key为牌名，value为牌的张数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int item = nums[i];
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        // 求各牌的数量的最大公约数
        int greatestCommonDivisor = -1;
        int current;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            current = entry.getValue();
            if (current == 1) {
                return false;
            }
            if (greatestCommonDivisor == -1) {
                greatestCommonDivisor = current;
            } else {
                greatestCommonDivisor = getGreatestCommonDivisor(greatestCommonDivisor, current);
            }

        }

        if (greatestCommonDivisor < 2) {
            return false;
        }

        return true;
    }

    /**
     * 求x、y两数的最大公约数
     * 参考：https://zh.wikipedia.org/wiki/%E8%BC%BE%E8%BD%89%E7%9B%B8%E9%99%A4%E6%B3%95
     * @param x
     * @param y
     * @return
     */
    public static int getGreatestCommonDivisor(int x, int y) {
        if (y == 0) {
            return x;
        }
        int z = x % y;
        return getGreatestCommonDivisor(y, z);
    }
}
