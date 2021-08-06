package com.example.everydaypractice.question;

import com.example.everydaypractice.datastructure.TreeNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: Day30Test
 * @Author: lhb
 * @Date: 2021/8/5 下午7:43
 */

@Slf4j
class Day30Test {

    @Test
    void solution1() {
        // 创建一棵二叉搜索树
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(8);
        root.setLeft(node1).setRight(node2);
        node1.setLeft(node3).setRight(node4);
        node2.setLeft(node5).setRight(node6);
        log.info("input = {}", root);

        boolean result = Day30.solution1(root);
        log.info("output = {}", result);
    }
}