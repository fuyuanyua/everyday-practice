package com.example.everydaypractice.question;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Description: Day18
 * @Author: lhb
 * @Date: 2021/7/19 下午6:32
 *
 * 1.说明：
 *      给定一个非空数组，返回此数组中第三大的数
 * 2.限制：
 *      时间复杂度限定在O(n)，若存在第三大的数，返回第三大的数，否则返回最大数
 * 3.示例：
 *      输入：[1, 2, 3]
 *      输出：1
 */

public class Day18 {

    /**
     * 思路：
     *      额外借助一个容量为3的result数组，分别依次从小到大保存nums数组中最大的三个数，
     *      从头开始遍历nums数组，每一次遍历都要重新维护result数组，但使用常数级别的时间复杂度
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public static int solution1(int[] nums) {
        int length = nums.length;
        if (length <= 2) {
            int max = Arrays.stream(nums).max().getAsInt();
            return max;
        }

        // 如果count >= 3，表示存在第三大的数
        int count = 0;

        // result数组依次从小到大保存nums数组中最大的三个数
        int[] result = new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int i = 0; i < length; i++) {
            int current = nums[i];
            if (current > result[2]) {
                result[0] = result[1];
                result[1] = result[2];
                result[2] = current;
                count++;
            } else if (current < result[2] && current > result[1]) {
                result[0] = result[1];
                result[1] = current;
                count++;
            } else if (current < result[1] && current > result[0]) {
                result[0] = current;
                count++;
            } else if (current == result[2]) {
                result[0] = result[1];
                result[1] = result[2];
                result[2] = current;
            }
        }

        // 若存在第三大的数，返回第三大的数，否则返回最大数
        return count >= 3 ? result[0] : result[2];
    }
}
