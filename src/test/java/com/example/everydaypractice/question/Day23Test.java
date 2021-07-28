package com.example.everydaypractice.question;

import com.example.everydaypractice.datastructure.TreeNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: Day23Test
 * @Author: lhb
 * @Date: 2021/7/27 下午7:02
 */

@Slf4j
class Day23Test {

    @Test
    void solution1() {
        // 构建一颗二叉搜索树
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(15);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(18);
        root.setLeft(node1).setRight(node2);
        node1.setLeft(node3).setRight(node4);
        node2.setRight(node5);

        int l = 7;
        int r = 15;
        log.info("input = {}, {}, {}", root, l, r);
        int result = Day23.solution1(root, l, r);
        log.info("output = {}", result);
    }
}