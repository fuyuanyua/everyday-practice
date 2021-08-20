package com.example.everydaypractice.hot100;

import org.apache.commons.lang3.StringUtils;

import java.util.Stack;

/**
 * @Description: Hot001
 * @Author: lhb
 * @Date: 2021/8/17 下午7:06
 *
 * 1.说明：给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 2.限制：
 *      左括号必须用相同类型的右括号闭合。
 *      左括号必须以正确的顺序闭合。
 * 3.示例：
 *      输入：s = "()[]{}"
 *      输出：true
 * 4.参考：https://leetcode-cn.com/problems/valid-parentheses/
 */

public class Hot001 {

    public static boolean solution1(String s) {
        if (StringUtils.isEmpty(s)) {
            return false;
        }

        // 用于保存元素：若遇到左括号，把对应的右括号入栈；若遇到右括号等于栈顶元素，弹出栈顶元素
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        // 如果长度是奇数直接返回false
        if (length % 2 == 1) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
                continue;
            }
            if (c == '[') {
                stack.push(']');
                continue;
            }
            if (c == '{') {
                stack.push('}');
                continue;
            }
            if (stack.size() == 0) {
                return false;
            }
            if (c != stack.pop()) {
                return false;
            }
        }
        if (stack.size() != 0) {
            return false;
        }
        return true;
    }
}
