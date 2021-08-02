package com.example.everydaypractice.question;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Description: Day27
 * @Author: lhb
 * @Date: 2021/8/2 下午4:24
 *
 * 1.说明：
 *      给定一个整数数组nums，找出三个元素组成的最大乘积，返回这个乘积
 * 2.限制：
 *
 * 3.示例：
 *      输入：[1, 2, 3]
 *      输出：6
 */

public class Day27 {

    /**
     * 解法1：
     *      思路：
     *          找出数组中三个数，且要乘积最大，有以下情况：
     *          若数组的元素全是正数或全是负数，则是最大的三个数相乘；
     *          若数组有正有负，且包含两个及以上的负数，则最小的两个负数相乘再乘上最大的正数得到a1，
     *          最大的三个数相乘得到a2，取a1和a2之中的最大值
     *          综上所述，先对数组排序，然后得到a1和a2，取最大值
     *      时间复杂度：排序的时间复杂度是O(nlogn)
     *      空间复杂度：O(1)
     * @param nums
     * @return
     */
    public static int solution1(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int length = nums.length;
        int result = 1;
        if (length <= 3) {
            for (int i = 0; i < length; i++) {
                result *= nums[i];
            }
            return result;
        }

        Arrays.sort(nums);
        int a1 = nums[0] * nums[1] * nums[length - 1];
        int a2 = nums[length - 1] * nums[length - 2] * nums[length - 3];
        return Math.max(a1, a2);
    }

    /**
     * 解法2：
     *      思路：
     *          遍历一次数组nums，找出最大的三个数和最小的两个数，利用解法1的思路得到a1和a2，返回两者之中的最大值，
     *          最大的三个数用一个小顶堆维护，最小的两个数用一个大顶堆维护
     *      时间复杂度：遍历数组O(n)，每一轮都要维护一个小顶堆O(log3)和一个大顶堆O(log2)，所以消耗常量的时间复杂度，总时间复杂度还是O(n)
     *      空间复杂度：小顶堆和大顶堆使用常量的额外空间，所以O(1)
     * @param nums
     * @return
     */
    public static int solution2(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int length = nums.length;
        int result = 1;
        if (length <= 3) {
            for (int i = 0; i < length; i++) {
                result *= nums[i];
            }
            return result;
        }

        // 小顶堆，存储数组中最大的三个数
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(3);
        // 大顶堆，存储数组中最小的两个数
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(2, (v1, v2) -> (v2 - v1));
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (minHeap.size() < 3) {
                minHeap.offer(num);
            } else {
                // 因为是小顶堆，堆顶永远是最小值
                Integer min = minHeap.peek();
                if (num > min) {
                    // 移除堆顶元素
                    minHeap.poll();
                    // 插入新值
                    minHeap.offer(num);
                }
            }

            if (maxHeap.size() < 2) {
                maxHeap.offer(num);
            } else {
                // 因为是大顶堆，堆顶永远是最大值
                Integer max = maxHeap.peek();
                if (num < max) {
                    // 移除堆顶元素
                    maxHeap.poll();
                    // 插入新值
                    maxHeap.offer(num);
                }
            }
        }

        int a1 = 1;
        int a2 = 1;
        for (int i = 0; i < 3; i++) {
            if (i == 2) {
                a1 *= minHeap.peek();
            }
            a2 *= minHeap.poll();
        }
        for (int i = 0; i < 2; i++) {
            a1 *= maxHeap.poll();
        }

        return Math.max(a1, a2);
    }
}
