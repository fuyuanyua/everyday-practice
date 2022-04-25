package com.example.everydaypractice;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 手写一个数据结构，实现LRU算法（最近最少使用）
 * @Author: lhb
 * @Date: 2022/4/25 22:15
 *
 * https://leetcode-cn.com/problems/lru-cache/
 */

public class LruCache {

    /**
     * 定义一个双向链表节点
     */
    public static class Node {
        private int key;

        private int value;

        private Node pre;

        private Node next;

        public Node() {}

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * 借助一个map，实现O(1)时间复杂度get和put
     */
    private Map<Integer, Node> cache;

    /**
     * 双向链表的哑头节点
     */
    private Node dummyHead;

    /**
     * 双向链表的哑尾节点
     */
    private Node dummyTail;

    /**
     * Lru缓存的容量大小
     */
    private int capacity;

    /**
     * Lru缓存当前存储的元素数量
     */
    private int size;

    public LruCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.size = 0;
        this.dummyHead = new Node();
        this.dummyTail = new Node();
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
    }

    public int get(int key) {
        Node node = cache.get(key);
        // 若cache中不存在，返回-1
        if (node == null) {
            return -1;
        }
        // 若cache中存在，把节点移到头节点，返回value
        moveNodeToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        // 若取不到，新建节点
        if (node == null) {
            Node newNode = new Node(key ,value);
            cache.put(key, newNode);
            // 若容量未达到上限，把元素加到头节点
            if (size < capacity) {
                addNodeToHead(newNode);
                size++;
            }
            // 若容量达到上限，移除尾节点，并把cache中对应的key移除，然后把元素加到头节点
            else {
                Node tailNode = removeTailNode();
                cache.remove(tailNode.key);
                addNodeToHead(newNode);
            }
        }
        //若取到，更新value，并把节点移动到头节点
        else {
            node.value = value;
            moveNodeToHead(node);
        }
    }

    /**
     * 把一个节点从双向链表中移除
     *      1.当前节点的前驱的后继指向当前节点的后继
     *      2.当前节点的后继的前驱指向当前节点的前驱
     * @param node
     */
    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    /**
     * 把一个节点加入到双向链表的头节点
     * @param node
     */
    private void addNodeToHead(Node node) {
        node.next = dummyHead.next;
        node.pre = dummyHead;

        node.next.pre = node;
        dummyHead.next = node;
    }

    /**
     * 把双向链表中的一个节点移动到头节点
     * @param node
     */
    private void moveNodeToHead(Node node) {
        removeNode(node);
        addNodeToHead(node);
    }

    /**
     * 移除双向链表中的尾节点
     */
    private Node removeTailNode() {
        Node tailNode = dummyTail.pre;
        removeNode(tailNode);
        return tailNode;
    }
}
