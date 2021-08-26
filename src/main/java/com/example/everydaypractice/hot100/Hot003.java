package com.example.everydaypractice.hot100;

import com.example.everydaypractice.datastructure.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: Hot003
 * @Author: lhb
 * @Date: 2021/8/24 下午7:15
 */

public class Hot003 {

    /**
     * 解法1：
     *      额外使用一个set，利用set保存的元素不可重复的特性，
     *      遍历链表，保存节点，若碰到重复元素，则说明链表有环
     * @param head
     * @return
     */
    public static boolean solution1(ListNode head) {
        if (head == null) {
            return false;
        }

        Set<ListNode> set = new HashSet<>();
        ListNode current = head;
        while (current != null) {
            if (set.contains(current)) {
                return true;
            }
            set.add(current);
            current = current.next;
        }

        return false;
    }

}
