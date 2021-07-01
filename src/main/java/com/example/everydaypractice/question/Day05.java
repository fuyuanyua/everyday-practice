package com.example.everydaypractice.question;

/**
 * @Description: Day05
 * @Author: lhb
 * @Date: 2021/6/30 下午6:32
 *
 * 1.说明：
 *      给定一个赎金信（ransom）字符串和一个杂志（magazine）字符串，
 *      判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。
 *      如果可以构成，返回true，否则返回false。
 * 2.限制：
 *      两个字符串均只含有小写字母
 * 3.示例：
 *      输入："aa", "aab"
 *      输出：true
 * 4.参考：https://leetcode-cn.com/problems/ransom-note/
 */

public class Day05 {

    /**
     * 解法1：
     *      思路：
     *          准备一个容量为26的数组，
     *          遍历magazine，记录magazine中每个字符出现的次数，
     *          再遍历ransom，每遍历到一个字符，将数组中这个字符的次数减去1，
     *          如果这个字符的次数 < 0，说明magazine无法提供这个字符去组成ransom，返回false，
     *          若遍历完ransom，则说明满足要求，返回true
     *      时间复杂度：设ransom长度为n，magazine长度为m，则O(n + m)
     *      空间复杂度：使用常数级别的额外空间，O(1)
     * @param ransom
     * @param magazine
     * @return
     */
    public static boolean solution1(String ransom, String magazine) {
        char[] ransomChars = ransom.toCharArray();
        char[] magazineChars = magazine.toCharArray();

        // 用于记录magazine中每个小写字母出现的次数
        // temp[0]-temp[25]分别对应a-z出现的次数
        int[] temp = new int[26];

        // 小写字母a-z的ASCII码为：97-122
        for (int i = 0; i < magazineChars.length; i++) {
            temp[magazineChars[i] - 97]++;
        }

        for (int i = 0; i < ransomChars.length; i++) {
            temp[ransomChars[i] - 97]--;
            if (temp[ransomChars[i] - 97] < 0) {
                return false;
            }
        }

        return true;
    }
}
