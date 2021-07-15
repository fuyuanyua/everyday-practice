package com.example.everydaypractice.question;

/**
 * @Description: Day16
 * @Author: lhb
 * @Date: 2021/7/15 下午6:42
 *
 * 1.说明：
 *      给定一个数组A[0,1,…,n-1]，请构建一个数组B[0,1,…,n-1]，
 *      其中B[i]的值是数组A中除了下标i以外的元素的积, 即B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。
 * 2.限制：
 *      不能使用除法
 * 3.示例：
 *      输入：[1, 2, 3, 4, 5]
 *      输出：[120, 60, 40, 30, 24]
 * 4.参考：https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/
 */

public class Day16 {

    /**
     * 解法1：
     *      思路：暴力破解
     *      时间复杂度：O(n^2)，n为数组长度
     *      空间复杂度：O(1)
     *      缺点：时间复杂度太高
     * @param nums
     * @return
     */
    public static int[] solution1(int[] nums) {
        if (nums == null) {
            return null;
        }

        int length = nums.length;
        if (length == 0) {
            return new int[0];
        }

        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            int item = 1;
            for (int j = 0; j < length; j++) {
                if (j == i) {
                    continue;
                }
                item = item * nums[j];
            }
            result[i] = item;
        }

        return result;
    }

    /**
     * 解法2：
     *      思路：
     *          以B[i]为例，B[i] = 数组A下标为i的元素的左边所有元素乘积 * 数组A下标为i的元素的右边所有元素乘积，
     *          所以第一次遍历求出数组A下标为i的元素的左边所有元素乘积，放入B[i]
     *          第二次遍历求出数组A下标为i的元素的右边所有元素乘积，放入temp[i]，
     *          B[i] = B[i] * temp[i]
     *          最后返回数组B
     *      时间复杂度：O(n)，n为数组长度
     *      空间复杂度：O(n)，因为额外使用了一个长度为n的临时数组
     * @param nums
     * @return
     */
    public static int[] solution2(int[] nums) {
        if (nums == null) {
            return null;
        }

        int length = nums.length;
        if (length == 0) {
            return new int[0];
        }

        // 第一次遍历，result[i]保存数组nums下标为i的元素的左边所有元素乘积
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                result[i] = 1;
                continue;
            }
            result[i] = result[i - 1] * nums[i - 1];
        }

        // 第二次遍历，temp[i]保存数组nums下标为i的元素的右边所有元素乘积
        int[] temp = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            if (i == length - 1) {
                temp[i] = 1;
                result[i] = result[i] * temp[i];
                continue;
            }
            temp[i] = temp[i + 1] * nums[i + 1];
            // result[i]最终结果 = 数组nums下标为i的元素的左边所有元素乘积 * 数组nums下标为i的元素的右边所有元素乘积
            result[i] = result[i] * temp[i];
        }

        return result;
    }
}
