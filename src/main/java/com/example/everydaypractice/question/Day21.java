package com.example.everydaypractice.question;

/**
 * @Description: Day21
 * @Author: lhb
 * @Date: 2021/7/22 下午6:31
 *
 * 1.说明：
 *      实现JDK的sqrt方法
 * 2.限制：
 *      不可调用JDK的sqrt方法
 * 3.示例：
 *      输入：num = 9
 *      输出：3
 */

public class Day21 {

    /**
     * 思路：二分法查找，通过二分法查找出最大的 target，满足 target * target <= num
     * 时间复杂度：O(logn)，n为数字的值，二分法查找每次都能缩小一半范围
     * 空间复杂度:1
     *
     * @param num
     * @return
     * @throws Exception
     */
    public static int sqrt(int num) throws Exception {
        if (num == 0) {
            return 0;
        }
        if (num < 0) {
            throw new Exception("输入值非法：不可小于0");
        }

        int low = 1;
        int high = num;
        int mid = (low + high) / 2;;
        while (low <= high) {
            mid = (low + high) / 2;
            if (mid * mid == num) {
                return mid;
            }
            if (mid * mid > num) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return (mid * mid > num) ? (mid - 1) : mid;
    }
}
