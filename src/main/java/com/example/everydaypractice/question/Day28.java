package com.example.everydaypractice.question;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: Day28
 * @Author: lhb
 * @Date: 2021/8/3 下午4:24
 *
 * 1.说明：
 *      数组中一个数字出现的次数超过数组长度的一般。请找出这个数字
 * 2.限制：
 *      数组非空
 * 3.示例：
 *      输入：[1, 2, 3, 2, 2, 2, 5, 4, 2]
 *      输出：2
 */

public class Day28 {

    /**
     * 解法1：
     *      思路：先对数组升序排序，因为数字出现次数超过数组长度一半，那么排序后数组中间的数字必定是目标数字
     *      时间复杂度：排序的时间复杂度O(nlogn)
     *      空间复杂度：O(1)
     * @param nums
     * @return
     */
    public static int solution1(int[] nums) {
        int length = nums.length;

        Arrays.sort(nums);
        int mid = (0 + (length - 1)) / 2;
        return nums[mid];
    }

    /**
     * 解法2：
     *      思路：
     *          遍历数组，把每个数字的次数记录到哈希表，key为此数字的值，value为此数字出现的次数，
     *          返回出现次数大于（数组长度 / 2）的数字
     *      时间复杂度：O(n)
     *      空间复杂度：O(n)
     * @param nums
     * @return
     */
    public static int solution2(int[] nums) {
        int length = nums.length;

        int half = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>(length);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > half) {
                return num;
            }
        }

        return 0;
    }
}
