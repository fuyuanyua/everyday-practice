package com.example.everydaypractice.question;

import org.springframework.util.CollectionUtils;

/**
 * @Description: Day03
 * @Author: lhb
 * @Date: 2021/6/28 下午6:26
 *
 * 1.说明：
 *      如果数组是单调递增或单调递减的，那么它是单调的。
 *      如果对于所有 i <= j，A[i] <= A[j]，那么数组A是单调递增的。
 *      如果对于所有 i <= j，A[i] >= A[j]，那么数组A是单调递减的。
 *      当给定的数组A是单调数组时返回true，否则返回false。
 * 2.限制：
 *      无
 * 3.示例：
 *      输入：[1, 2, 2, 3]
 *      输出：true
 * 4.参考：https://leetcode-cn.com/problems/monotonic-array/
 */

public class Day03 {

    /**
     * 解法1：
     *      思路：
     *          一次遍历，设置两个标识，一个是递增标识，一个是递减标识，初始都为true，
     *          从头开始遍历数组，若后一个元素大于当前元素，则递减标识设为false，
     *          若后一个元素小于当前元素，则递增标识设为true，
     *          遍历完后若递减标识和递增标识都为false，则表示数组不具备单调性，否则数组是单调的
     *      时间复杂度：O(n)
     *      空间复杂度：O(1)
     * @param nums
     * @return
     */
    public static boolean solution1(int[] nums) {
        int length = nums.length;

        if (length <= 0 || nums == null) {
            return false;
        }

        // 递增标识
        boolean increase = true;
        // 递减标识
        boolean decrease = true;

        // length - 1，表示遍历到倒数第二个元素，否则下标越界
        for (int i = 0; i < length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                decrease = false;
            } else if (nums[i + 1] < nums[i]) {
                increase = false;
            }
        }

        return (decrease || increase);
    }

    /**
     * 解法2：
     *      思路：两次遍历，一次判断数组是否递增，一组判断数组是否递减
     *      时间复杂度：O(n)
     *      空间复杂度：O(1)
     * @param nums
     * @return
     */
    public static boolean solution2(int[] nums) {
        int length = nums.length;

        if (length <= 0 || nums == null) {
            return false;
        }

        return (isIncrease(nums) || isDecrease(nums));
    }

    private static boolean isDecrease(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isIncrease(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                return false;
            }
        }
        return true;
    }
}
