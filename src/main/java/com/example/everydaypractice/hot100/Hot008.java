package com.example.everydaypractice.hot100;

/**
 * @Description: Hot008
 * @Author: lhb
 * @Date: 2021/10/8 下午4:11
 *
 * 1.说明：
 *      给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，
 *      使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 2.限制：
 *      此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *      原地排序
 * 3.示例：
 *      输入：[2, 0, 2, 1, 1, 0]
 *      输出：[0, 0, 1, 1, 2, 2]
 * 4.参考：https://leetcode-cn.com/problems/sort-colors/
 */

public class Hot008 {

    /**
     * 思路：
     *      index用于标识下一次要交换的下标，初始下标为0，
     *      第一次遍历数组，遇到值为0的元素，就将此元素与index指向的元素交换，
     *      第二次遍历数组，遇到值为1的元素，就将此元素与index指向的元素交换
     * 时间复杂度：O(n)
     * 空间复杂毒：O(1)
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
            if (num == 0) {
                swap(i, index, nums);
                index++;
            }
        }
        for (int i = index; i < length; i++) {
            int num = nums[i];
            if (num == 1) {
                swap(i, index, nums);
                index++;
            }
        }
    }

    private static void swap(int index1, int index2, int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        if (index1 >= nums.length || index1 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index2 >= nums.length || index2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
