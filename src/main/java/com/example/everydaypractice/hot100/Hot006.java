package com.example.everydaypractice.hot100;

/**
 * @Description: Hot006
 * @Author: lhb
 * @Date: 2021/9/16 下午7:05
 *
 * 1.说明：给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 2.限制：
 *      必须在原数组上操作，不能拷贝额外的数组。
 *      尽量减少操作次数。
 * 3.示例：
 *      输入：[0, 1, 0, 3, 12]
 *      输出：[1, 3, 12, 0, 0]
 * 4.参考：https://leetcode-cn.com/problems/move-zeroes/
 */

public class Hot006 {

    /**
     * 解法1：
     *      定义一个index指针，指向下一次非0元素应该存放的下标，初始指向下标0，
     *      遍历数组，每当遇到非0元素，将index指针指向的元素值设为当前遍历到的元素的值，index++，然后继续遍历，
     *      遍历完数组后，将index及以后坐标的元素值都设为0
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums
     */
    public static void solution1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int length = nums.length;
        int index = 0;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (num != 0) {
                nums[index] = num;
                index++;
            }
        }
        for (int i = index; i < length; i++) {
            nums[i] = 0;
        }
    }
}
