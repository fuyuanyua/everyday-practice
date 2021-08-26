package com.example.everydaypractice.datastructure;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description: 定义一个单向链表节点
 * @Author: lhb
 * @Date: 2021/7/13 下午6:28
 */

@Getter
@Setter
public class ListNode {

    /**
     * 节点值
     */
    public int value;

    /**
     * 后继节点
     */
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
    }
}
