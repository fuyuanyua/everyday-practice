package com.example.everydaypractice.question;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: Day02
 * @Author: lhb
 * @Date: 2021/6/25 下午6:55
 *
 * 1.说明：
 *      给定一个整数数组nums和一个整数目标值target，
 *      请你在该数组中找出和为目标值target的那两个整数，并返回它们的数组下标。
 * 2.限制：
 *      你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。(说明数组元素是不可重复的)
 *      你可以按任意顺序返回答案。
 * 3.示例：
 *      输入：nums = [2, 7, 11, 15], target = 9
 *      输出：[0, 1]
 * 4.参考：https://leetcode-cn.com/problems/two-sum/
 */

public class Day02 {

    /**
     * 解法1：
     *      思路：直接双重循环暴力破解
     *      时间复杂度：O(n^2)
     *      空间复杂度：O(1)
     * @param nums
     * @param target
     * @return
     */
    public static int[] solution1(int[] nums, int target) {
        // 返回的结果
        int[] result = new int[2];

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }

        return result;
    }

    /**
     * 解法2：
     *      思路：
     *          额外借助一个哈希表，key存元素的值，value存元素的下标，
     *          那么只需遍历一次数组就可以找出目标结果，空间换时间
     *      时间复杂度：O(n)
     *      空间复杂度：O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] solution2(int[] nums, int target) {
        // 返回的结果
        int[] result = new int[2];

        int length = nums.length;
        // key存数组元素的值，value存数组元素的下标
        Map<Integer, Integer> map = new HashMap<>(length);

        for (int i = 0; i < length; i++) {
            int currentValue = nums[i];
            // containsKey时间复杂度为O(1)
            // 在map中寻找是否有key + 当前元素的值等于目标值，有则返回这两个元素的下标
            if (map.containsKey(target - currentValue)) {
                result[0] = i;
                result[1] = map.get(target - currentValue);
                return result;
            }
            // 没有则保存当前元素的值和下标到map里
            map.put(currentValue, i);
        }

        return result;
    }

}
