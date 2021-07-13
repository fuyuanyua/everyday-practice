package com.example.everydaypractice.question;

import com.example.everydaypractice.datastructure.ListNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: Day14Test
 * @Author: lhb
 * @Date: 2021/7/13 下午6:56
 */

@Slf4j
class Day14Test {

    @Test
    void solution1() {
        // 初始化一个单向链表：1 -> 2 -> 3 -> 3 -> 2 -> 1
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        log.info("input = {}", head);
        ListNode result = Day14.solution1(head);
        log.info("output = {}", result);
    }
}