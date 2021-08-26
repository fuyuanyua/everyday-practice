package com.example.everydaypractice.hot100;

import com.example.everydaypractice.datastructure.ListNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @Description: Hot003Test
 * @Author: lhb
 * @Date: 2021/8/24 下午7:55
 */

@Slf4j
class Hot003Test {

    @Test
    void solution1() {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node1);
        log.info("input = {}", head);
        boolean result = Hot003.solution1(head);
        log.info("output = {}", result);
    }
}