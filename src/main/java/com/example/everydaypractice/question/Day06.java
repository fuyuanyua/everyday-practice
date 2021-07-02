package com.example.everydaypractice.question;

import java.util.Stack;

/**
 * @Description: Day06
 * @Author: lhb
 * @Date: 2021/7/1 下午6:28
 *
 * 1.说明：
 *      定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的getMin方法在该栈中，
 *      调用getMin、push及pop的时间复杂度都是O(1)。
 * 2.示例：
 * 3.参考：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 */

public class Day06 {

    class MyStack {

        /**
         * 数据栈，用于存储数据，JDK已实现push、pop、top方法
         */
        private Stack<Integer> dataStack;

        /**
         * 辅助栈，用于实现getMin方法，要在O(1)时间复杂度获取最小元素，所以要保证最小元素永远在栈顶
         */
        private Stack<Integer> minStack;

        public MyStack() {
            this.dataStack = new Stack<>();
            this.minStack = new Stack<>();
        }

        public MyStack(Stack<Integer> dataStack, Stack<Integer> minStack) {
            this.dataStack = dataStack;
            this.minStack = minStack;
        }

        /**
         * 入栈：
         *      1.对于数据栈，直接push e即可
         *      2.对于辅助栈，因为要保证栈顶元素永远是最小元素，所以：
         *          * 若辅助栈当前无元素，直接push e
         *          * 若辅助栈有元素，则比较e与辅助栈栈顶元素min：
         *              * 若e <= min，则push e
         *              * 否则，新建一个值等于min的元素push进去
         * @param e
         */
        public void push(Integer e) {
            dataStack.push(e);
            if (minStack.isEmpty()) {
                minStack.push(e);
            } else {
                // 获取最小元素
                Integer min = minStack.peek();
                if (e <= min) {
                    minStack.push(e);
                } else {
                    Integer min1 = new Integer(min);
                    minStack.push(min1);
                }
            }
        }

        /**
         * 出栈：数据栈和辅助栈都弹出栈顶元素即可
         * @return
         */
        public Integer pop() {
            if (!dataStack.isEmpty() && !minStack.isEmpty()) {
                Integer result = dataStack.pop();
                minStack.pop();
                return result;
            }
            return null;
        }

        /**
         * 获取栈顶元素：直接返回数据栈栈顶元素
         * @return
         */
        public Integer peek() {
            return dataStack.peek();
        }

        /**
         * 获取最小元素：直接返回辅助栈栈顶元素
         * @return
         */
        public Integer getMin() {
            if (minStack.isEmpty()) {
                return null;
            }
            return minStack.peek();
        }
    }
}
