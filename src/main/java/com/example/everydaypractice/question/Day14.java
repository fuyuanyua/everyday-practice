package com.example.everydaypractice.question;

import com.example.everydaypractice.datastructure.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: Day14
 * @Author: lhb
 * @Date: 2021/7/13 下午6:30
 *
 * 1.说明：
 *      移除未排序链表的重复节点，保留最开始出现的节点
 * 2.限制：
 *
 * 3.示例：
 *      输入：1 -> 2 -> 3 -> 3 -> 2 -> 1
 *      输出：1 -> 2 -> 3
 */

public class Day14 {

    /**
     * 思路：
     *      借助一个HashSet来保存链表中不重复的数字，
     *      从头开始遍历链表，取得当前节点的当前值：
     *          * 若set中不存在这个值，则把这个值存进set，然后继续向后遍历；
     *          * 否则，删除当前节点（删除当前节点的方法：将当前节点的前驱指向当前节点的后继），然后继续向后遍历。
     *      当遍历完链表后，返回头节点，就是目标结果。
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param head
     * @return
     */
    public static ListNode solution1(ListNode head) {
        if (head == null) {
            return null;
        }

        // 用于保存不重复数字
        Set<Integer> set = new HashSet<>();

        // new一个虚拟节点当作头节点的前驱
        ListNode fake = new ListNode(-1);
        fake.next = head;
        // current指针指向当前节点，用于遍历链表，初始指向头节点
        ListNode current = head;
        // pre指针指向当前节点的前驱，初始指向头节点的前驱
        ListNode pre = fake;
        // 当前遍历到的节点的值
        int currentValue = current.value;

        while (current != null) {
            currentValue = current.value;
            // 如果set中不包含当前值，则current指针和pre指针都向后走一步
            if (!set.contains(currentValue)) {
                set.add(currentValue);
                pre = current;
                current = current.next;
            } else { // 否则，删除当前节点（pre指针指向当前节点的后继，即删除了当前节点），然后当前指针向后走一步
                pre.next = current.next;
                current = current.next;
            }
        }

        return head;
    }
}
