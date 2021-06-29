package com.example.everydaypractice.question;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description: Day04
 * @Author: lhb
 * @Date: 2021/6/29 下午5:48
 *
 * 1.说明：
 *      给定一个整数数组，判断是否存在重复元素。
 *      如果存在一值在数组中出现至少两次，方法返回true，如果数组中每个元素都不相同，则返回false。
 * 2.限制：
 *      无
 * 3.示例：
 *      输入：[1, 2, 3, 1]
 *      输出：true
 * 4.参考：https://leetcode-cn.com/problems/contains-duplicate/
 */

public class Day04 {

    /**
     * 解法1：
     *      思路：先对数组进行排序，然后遍历数组比较相邻元素，若相邻元素值相等，则表示存在重复元素
     *      时间复杂度：排序O(nlogn)，遍历数组O(n)，所以总时间复杂度O(nlogn)
     *      空间复杂度：O(1)
     * @param nums
     * @return
     */
    public static boolean solution1(int[] nums) {
        int length = nums.length;

        if (length <= 1 || nums == null) {
            return false;
        }

        // JDK排序平均时间复杂度O(nlogn)
        Arrays.sort(nums);

        for (int i = 0; i < length - 1; i++) {
            if (nums[i + 1] == nums[i]) {
                return true;
            }
        }

        return false;
    }

    /**
     * 解法2：
     *      思路：
     *          额外借助一个HashSet，HashSet的元素是不可重复的，
     *          遍历数组，每访问到一个元素，判断set中是否存在这个元素，
     *          存在，则直接返回true；不存在，则将此元素添加到set中
     *      时间复杂度：O(n)
     *      空间复杂度：O(n)
     * @param nums
     * @return
     */
    public static boolean solution2(int[] nums) {
        int length = nums.length;

        if (length <= 1 || nums == null) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            int current = nums[i];
            // Set的contains方法时间复杂度O(1)
            if (set.contains(current)) {
                return true;
            }
            set.add(current);
        }

        return false;
    }
}
