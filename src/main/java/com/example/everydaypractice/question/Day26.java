package com.example.everydaypractice.question;

import java.util.Arrays;

/**
 * @Description: Day26
 * @Author: lhb
 * @Date: 2021/7/30 下午4:40
 *
 * 1.说明：
 *      给定一个整数数组nums，找到一个具有最大和的连续子数组，返回其最大和
 * 2.限制：
 *      子数组最少包含一个元素
 * 3.示例：
 *      输入：[-2, 1, -3, 4, -1, 2, 1, -5, 4]
 *      输出：6
 *      解释：连续子数组 [4, -1, 2, 1] 的和最大，为6
 * 4.参考：
 *      动态规划
 *      https://zhuanlan.zhihu.com/p/91582909
 *      https://zh.wikipedia.org/wiki/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92
 */

public class Day26 {

    /**
     * 思路：
     *      动态规划
     *          1.已知数组nums
     *          2.创建一个dp数组，长度为nums.length
     *          3.dp[i]保存以nums[i]结尾的子数组中的最大和，所以dp[0] = nums[0]
     *          4.求dp[i]，从第二项开始遍历nums数组
     *              1.如果dp[i - 1] <= 0，那么dp[i] = nums[i]
     *              2.如果dp[i - 1] > 0，那么dp[i] = nums[i] + dp[i - 1]
     *          5.从dp数组中找出最大的一个数字，这个数字就是目标结果
     * @param nums
     * @return
     */
    public static int solution1(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int length = nums.length;
        if (length == 0) {
            return 0;
        }

        // dp数组，dp[i]保存以nums[i]结尾的子数组中的最大和
        int[] dp = new int[length];
        dp[0] = nums[0];

        // 根据规则为dp数组的每一项赋值
        for (int i = 1; i < length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }

        // 找出dp数组的最大值，这个值就是目标结果
        int result = Arrays.stream(dp).max().getAsInt();
        return result;
    }
}
