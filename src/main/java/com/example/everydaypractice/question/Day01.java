package com.example.everydaypractice.question;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: Day01
 * @Author: lhb
 * @Date: 2021/6/25 下午12:41
 *
 * 1.说明：给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 2.限制：
 *      在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *      假设字符串的长度不会超过 1010。
 * 3.示例：
 *      输入："abccccdd"
 *      输出：7
 * 4.参考：https://leetcode-cn.com/problems/longest-palindrome/
 */

public class Day01 {

    /**
     * 计算每个字符出现的次数：
     *      1.为偶数次的字符，次数都算入结果
     *      2.为奇数次的字符，若 == 1，无论多少个出现1次的字符，都只算1次，否则把次数 - 1算入结果
     * @param s
     * @return
     */
    public static int solution(String s) {
        int result = 0;

        if (StringUtils.isBlank(s)) {
            return result;
        }

        int length = s.length();
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>(26 * 2);

        for (int i = 0; i < length; i++) {
            char current = chars[i];
            map.put(current, map.getOrDefault(current, 0) + 1);
        }

        boolean flag = false;
        for (Character key : map.keySet()) {
            Integer value = map.get(key);
            if (value % 2 == 0) {
                result += value;
            } else {
                if (value != 1) {
                    result = result + (value - 1);
                } else {
                    flag = true;
                }
            }
        }

        return flag == true ? result + 1 : result;
    }
}
