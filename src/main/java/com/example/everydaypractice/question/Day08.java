package com.example.everydaypractice.question;

import org.omg.CORBA.Current;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @Description: Day08
 * @Author: lhb
 * @Date: 2021/7/5 下午6:30
 *
 * 1.说明：
 *      给你个整数数组arr，其中每个元素都不相同。
 *      请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 * 2.限制：
 *      数组每个元素都不相同
 * 3.示例：
 *      输入：arr = [4,2,1,3]
 *      输出：[[1,2],[2,3],[3,4]]
 * 4.参考：https://leetcode-cn.com/problems/minimum-absolute-difference/
 */

public class Day08 {

    /**
     * 解法1：
     *      思路：
     *          先对数组排序，然后第一次遍历数组，找出最小差值以及最小差值出现的次数，
     *          第二次遍历数组，组装结果然后返回
     *      时间复杂度：排序O(nlogn) + 遍历O(n) + 遍历O(n)，总时间复杂度O(nlogn)
     *      空间复杂度：O(1)
     * @param nums
     * @return
     */
    public static int[][] solution1(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return null;
        }

        // 先对数组排序
        Arrays.sort(nums);
        // 用于记录最小差值，初始值为排序数组第二项与第一项之差
        int minDifference = nums[1] - nums[0];
        // 用于记录最小差值出现的次数，初始值为0
        int minCount = 0;

        // 第一次遍历数组找出最小差值以及最小差值出现的次数
        for (int i = 0; i < nums.length - 1; i++) {
            int currentDifference = nums[i + 1] - nums[i];
            if (currentDifference == minDifference) {
                minCount++;
            }
            if (currentDifference < minDifference) {
                minDifference = currentDifference;
                minCount = 1;
            }
        }

        int[][] result = new int[minCount][2];
        // 二维数组下标
        int index = 0;
        // 第二次遍历数组，组装结果
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] == minDifference) {
                result[index] = new int[] {nums[i], nums[i + 1]};
                index++;
                // 如果结果已经组装完，直接跳出循环
                if (minCount == index) {
                    break;
                }
            }
        }

        return result;
    }
}
