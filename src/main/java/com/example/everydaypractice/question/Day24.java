package com.example.everydaypractice.question;

/**
 * @Description: Day24
 * @Author: lhb
 * @Date: 2021/7/28 下午6:52
 *
 * 1.说明：
 *      给定一个整数n，返回任意一个由n个各不相同的整数组成的数组，并且这n个整数相加为0
 * 2.限制：
 *      无
 * 3.示例：
 *      输入：5
 *      输出：[-2, -1, 0, 1, 2]
 */

public class Day24 {

    /**
     * 思路：结果数组长度为n，遍历数组，每次赋值赋两项，并且保证这两项相加为0
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param n
     * @return
     */
    public static int[] solution1(int n) {
        if (n <= 0) {
            return new int[0];
        }

        int[] result = new int[n];
        // 遍历的次数
        int total = 0;
        // 要赋的值的绝对数
        int num = 0;
        // 当n是偶数
        if (n % 2 == 0) {
            total = n / 2;
            for (int i = 0; i < total; i++) {
                num = i + 1;
                result[i] = num;
                result[n - 1 - i] = -num;
            }
        } else { // 当n是奇数
            total = n / 2 + 1;
            for (int i = 0; i < total; i++) {
                if (i == total - 1) {
                    result[i] = 0;
                    break;
                }
                num = i + 1;
                result[i] = num;
                result[n - 1 - i] = -num;
            }
        }

        return result;
    }
}
