package com.example.everydaypractice.question;

/**
 * @Description: Day13
 * @Author: lhb
 * @Date: 2021/7/12 下午2:29
 */

public class Day13 {

    /**
     * 思路：
     *      获得数字n的个位数的方法是：n % 10，
     *      获得n的个位数后，要获得十位数：先n = n / 10，去掉个位数，然后n % 10，
     *      获得百位数的方法同上，依次类推下去
     * 时间复杂度：O(m)，m为数字n的位数
     * 空间复杂度：O(1)
     * @param n
     * @return
     */
    public static int solution1(int n) {
        int abs = Math.abs(n);
        if (abs == 0) {
            return 0;
        }

        int sum = 0;
        int product = 1;

        while (abs > 0) {
            int num = abs % 10;
            abs = abs / 10;
            sum += num;
            product *= num;
        }

        return product - sum;
    }
}
