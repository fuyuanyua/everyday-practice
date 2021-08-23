package com.example.everydaypractice.hot100;

import java.util.Arrays;

/**
 * @Description: Hot002
 * @Author: lhb
 * @Date: 2021/8/20 下午7:00
 *
 * 1.说明：给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 2.限制：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 3.示例：
 *      输入：[2,2,1]
 *      输出：1
 * 4.参考：https://leetcode-cn.com/problems/single-number/
 */

public class Hot002 {

    /**
     * 解法1：
     *      暴力破解，先排序，假设nums[i]，若i为偶数，且nums[i] != nums[i + 1]，则nums[i]就是目标值，
     *      注意：若目标元素是数组中的最大值，则目标元素在数组尾，要特殊处理，防止判断时下标越界
     * @param nums
     * @return
     */
    public static int solution1(int[] nums) {
        Arrays.sort(nums);

        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }

        for (int i = 0; i < length; i++) {
            // 特殊处理，防止目标值在数组尾的时候nums[i + 1]会下标越界
            if (i == length - 1) {
                return nums[i];
            }
            if (i % 2 == 0) {
                if (nums[i] != nums[i + 1]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }
}
