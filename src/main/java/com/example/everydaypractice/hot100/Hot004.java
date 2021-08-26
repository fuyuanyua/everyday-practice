package com.example.everydaypractice.hot100;

import java.util.Arrays;

/**
 * @Description: Hot004
 * @Author: lhb
 * @Date: 2021/8/26 下午7:08
 *
 * 1.说明：给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 n/2 的元素。
 * 2.限制：
 *      假设数组是非空的
 *      给定的数组总是存在多数元素
 * 3.示例：
 *      输入：[3,2,3]
 *      输出：3
 * 4.参考：https://leetcode-cn.com/problems/majority-element/
 */

public class Hot004 {

    /**
     * 解法1：先对数组排序，排序后数组的中间下标元素必定是目标元素
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public static int solution1(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        return nums[length / 2];
    }

    /**
     * 解法2：
     *      投票法，设初始候选人为数组第一个元素，设初始票数为1，
     *      从第二个元素开始遍历数组，若遍历到的元素与候选人相等，票数 + 1，否则票数 - 1，
     *      若票数计零，则更换候选人为当前遍历到的元素，票数重新设置为1，继续遍历，重复以上步骤，
     *      最后胜出的候选人就是目标元素
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public static int solution2(int[] nums) {
        // 候选人，初始为数组第一个元素
        int candidate = nums[0];
        // 选票数，初始为1票
        int count = 1;

        int length = nums.length;
        for (int i = 1; i < length; i++) {
            int num = nums[i];
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
            // 如果票数计零，换候选人
            if (count == 0) {
                candidate = num;
                count = 1;
            }
        }
        return candidate;
    }
}
