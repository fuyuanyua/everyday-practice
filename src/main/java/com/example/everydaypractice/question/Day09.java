package com.example.everydaypractice.question;

/**
 * @Description: Day09
 * @Author: lhb
 * @Date: 2021/7/6 下午6:44
 *
 * 1.说明：
 *      给你一个正整数，输出它的补数。补数是对该数的二进制表示取反。
 * 2.限制：
 *      正整数
 *      整数范围在32位带符号范围内
 *      忽略符号位
 * 3.示例：
 *      输入：5
 *      输出：2
 * 4.参考：https://leetcode-cn.com/problems/number-complement/
 */

public class Day09 {

    /**
     * 解法1：
     *      思路：
     *          先将输入的正整数转为对应的二进制数组，遍历数组，
     *          将每一位都取反，然后将二进制数组转为十进制整数返回
     * @param a
     * @return
     */
    public static int solution1(int a) {
        char[] chars = Integer.toBinaryString(a).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                chars[i] = '1';
            } else {
                chars[i] = '0';
            }
        }
        String s = String.valueOf(chars);
        int result = Integer.parseInt(s, 2);
        return result;
    }

    /**
     * 解法2：
     *      思路：
     *          采用异或运算，
     *          a ^ a = 0
     *          a ^ b = 1
     *          b ^ b = 0
     *          101 ^ 010 = 111
     *          101 ^ 111 = 010
     *          所以只要将输入值和与输入值相同位数的最大值（也就是全部位都取1）进行一下异或运算，就得到结果，
     *          得到与输入值相同位数的最大值的方法是：大于等于输入值的最接近的2的整数次幂的值 - 1
     * @param a
     * @return
     */
    public static int solution2(int a) {
        long temp = 1;
        while (temp <= a) {
            temp = temp << 1;
        }
        temp = temp - 1;
        return a ^ (int)temp;
    }
}
