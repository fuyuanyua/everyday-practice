package com.example.everydaypractice.question;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: Day28
 * @Author: lhb
 * @Date: 2021/8/3 下午4:24
 */

public class Day28 {

    /**
     * 解法1：
     *      思路：先对数组升序排序，因为数字出现次数超过数组长度一半，那么排序后数组中间的数字必定是目标数字
     *      时间复杂度：排序的时间复杂度O(nlogn)
     *      空间复杂度：O(n)
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
        if (nums == null) {
            return 0;
        }

        int length = nums.length;
        if (length == 0) {
            return 0;
        }

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
