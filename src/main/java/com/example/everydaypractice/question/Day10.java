package com.example.everydaypractice.question;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: Day10
 * @Author: lhb
 * @Date: 2021/7/7 下午6:28
 *
 * 1.说明：
 *       给定字符串J代表石头中宝石的类型，和字符串S代表你拥有的石头。
 *       S中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * 2.限制：
 *      J中的字母不重复，J和S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 * 3.示例：
 *      输入："aA", "aAAbbbb"
 *      输出：3
 * 4.参考：https://leetcode-cn.com/problems/jewels-and-stones/
 */

public class Day10 {

    /**
     * 解法1：
     *      思路：
     *          额外借助一个哈希表，key存宝石类型，value存宝石数量，
     *          因为j、s都值包含大小写字母，所以宝石最多52种，
     *          先遍历宝石字符串，找出所有目标宝石，
     *          再遍历石头字符串，记录各目标宝石出现的次数，
     *          最后累加所有目标宝石出现的次数，即是结果
     *      时间复杂度：O(n)，n为石头字符串的长度
     *      空间复杂度：使用常数级别的额外空间，O(1)
     * @param j
     * @param s
     * @return
     */
    public static int solution1(String j, String s) {
        if (StringUtils.isBlank(j) || StringUtils.isBlank(s)) {
            return 0;
        }

        // 找出所有目标宝石
        Map<Character, Integer> map = new HashMap<>(26 * 2);
        for (int i = 0; i < j.length(); i++) {
            map.put(j.charAt(i), 0);
        }

        // 遍历石头字符串，记录各目标宝石出现的次数
        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            if (map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            }
        }

        // 累加所有目标宝石出现的次数
        AtomicInteger result = new AtomicInteger();
        map.forEach((k, v) -> result.getAndAdd(v));

        return result.intValue();
    }

    /**
     * 解法2：
     *      思路：
     *          遍历石头字符串，每遍历到石头字符串的一个字符，
     *          都直接用宝石字符串进行字符串匹配，
     *          若此字符在宝石字符串中，结果 + 1，
     *          最后返回结果
     *      时间复杂度：
     *          遍历石头字符串O(n)，n为石头字符串长度，
     *          每一次字符串匹配，时间复杂度O(m)，m为宝石字符串长度，
     *          所以总时间复杂度：O(n * m)
     *      空间复杂度：O(1)
     * @param j
     * @param s
     * @return
     */
    public static int solution2(String j, String s) {
        if (StringUtils.isBlank(j) || StringUtils.isBlank(s)) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            if (j.contains(String.valueOf(item))) {
                result++;
            }
        }

        return result;
    }
}
