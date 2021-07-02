package com.example.everydaypractice.question;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @Description: Day07
 * @Author: lhb
 * @Date: 2021/7/2 下午6:27
 *
 * 1.说明：
 *      给你一个字符串text，你需要使用text中的字母来拼凑尽可能多的单词"balloon"。
 * 2.限制：
 *      字符串text中每个字母只能被使用一次
 * 2.示例：
 *      输入："loonbalxballpoon"
 *      输出：2
 * 3.参考：https://leetcode-cn.com/problems/maximum-number-of-balloons/
 */

public class Day07 {

    private final static char LOWER_CASE_A = 'a';
    private final static char LOWER_CASE_B = 'b';
    private final static char LOWER_CASE_L = 'l';
    private final static char LOWER_CASE_O = 'o';
    private final static char LOWER_CASE_N = 'n';
    private final static int MIN = 7;

    /**
     * 解法1：
     *      思路：
     *          利用一个哈希表记录b、a、l、o、n这五个字母的次数，因为"balloon"单词中，
     *          l和o都出现了两次，所以l、o这两个字母的次数最终都要除以2（向下取整），
     *          最后返回这五个字母出现的最终次数的最小值
     *      时间复杂度：O(n)，n为字符串长度
     *      空间复杂度：使用常数级额外空间，O(1)
     * @param text
     * @return
     */
    public static int solution1(String text) {
        if (StringUtils.isBlank(text)) {
            return 0;
        }

        char[] chars = text.toCharArray();
        int length = chars.length;

        if (length < MIN) {
            return 0;
        }

        // 记录每个字符出现的次数
        Map<Character, Integer> map = new HashMap<>(5);
        for (char c : chars) {
            switch (c) {
                case LOWER_CASE_A:
                    map.put(LOWER_CASE_A, map.getOrDefault(LOWER_CASE_A, 0) + 1);
                    break;
                case LOWER_CASE_B:
                    map.put(LOWER_CASE_B, map.getOrDefault(LOWER_CASE_B, 0) + 1);
                    break;
                case LOWER_CASE_L:
                    map.put(LOWER_CASE_L, map.getOrDefault(LOWER_CASE_L, 0) + 1);
                    break;
                case LOWER_CASE_O:
                    map.put(LOWER_CASE_O, map.getOrDefault(LOWER_CASE_O, 0) + 1);
                    break;
                case LOWER_CASE_N:
                    map.put(LOWER_CASE_N, map.getOrDefault(LOWER_CASE_N, 0) + 1);
                    break;
                default:
            }
        }

        List<Integer> list = Arrays.asList(map.getOrDefault(LOWER_CASE_A, 0),
                map.getOrDefault(LOWER_CASE_B, 0),
                map.getOrDefault(LOWER_CASE_L, 0) / 2,
                map.getOrDefault(LOWER_CASE_O, 0) / 2,
                map.getOrDefault(LOWER_CASE_N, 0));

        int result = Integer.MAX_VALUE;
        for (int current : list) {
            if (current <= result) {
                result = current;
            }
        }
        return result;
    }
}
