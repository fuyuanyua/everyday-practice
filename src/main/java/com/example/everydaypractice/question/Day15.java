package com.example.everydaypractice.question;

import java.util.Observable;
import java.util.Observer;
import java.util.Stack;

/**
 * @Description: Day15
 * @Author: lhb
 * @Date: 2021/7/14 下午6:21
 *
 * 1.说明：
 *      给定一个整数，将其转化成七进制，以字符串形式输出
 * 2.限制：
 *
 * 3.示例：
 *      输入：100
 *      输出："202"
 */

public class Day15 {

    /**
     * 思路：
     *      将一个十进制数n转化成七进制数的方法：
     *      1.将n除以7，得到商和余数
     *      2.再将商除以7，得到商和余数
     *      3.重复以上操作，直到商等于0
     *      4.将得到的余数倒序输出，得到的就是结果
     *      所以额外借助一个stack，用于存储余数并倒序输出
     * 时间复杂度：O(logn)，底数为7
     * 空间复杂度：O(logn)，底数为7
     * @param n
     * @return
     */
    public static String solution1(int n) {
        if (n == 0) {
            return String.valueOf(n);
        }

        // 负数标识
        boolean flag = false;
        if (n < 0) {
            flag = true;
            n = -n;
        }

        Stack<Integer> stack = new Stack<>();
        while (n > 0) {
            int item = n % 7;
            stack.push(item);
            n = n / 7;
        }

        StringBuilder stringBuilder = new StringBuilder();
        if (flag) {
            stringBuilder.append("-");
        }
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(stack.pop());
        }

        return stringBuilder.toString();
    }
}
