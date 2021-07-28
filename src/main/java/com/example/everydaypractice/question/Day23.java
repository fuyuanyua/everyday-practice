package com.example.everydaypractice.question;

import com.example.everydaypractice.datastructure.TreeNode;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description: Day23
 * @Author: lhb
 * @Date: 2021/7/26 下午9:54
 *
 * 1.说明：
 *      给定二叉搜索树的根节点root，返回所有在[l, r]之间的节点的值之和
 * 2.限制：
 *      节点值具有唯一性
 * 3.示例：
 *      输入：root = [10, 5, 15, 3, 7, null, 18], l = 7, r = 15
 *      输出：32
 */

@Slf4j
public class Day23 {

    /**
     * 思路：
     *      二叉搜索树的特性：二叉搜索树的任意节点，其左子树节点的值都小于它的值，其右子树节点的值都大于它的值
     *      利用这个特性：
     *          如果遇到一个节点的值小于l，则这个节点的左子树所有节点的值都小于l，直接舍弃这个节点的左子树；
     *          如果遇到一个节点的值小于l大于r，则这个节点的右子树所有节点的值都大于r，直接舍弃这个节点的右子树；
     *      先序遍历这棵树，如果遇到以上情况，则做出相应舍弃，否则把当前遍历到的节点的值加入结果
     * 时间复杂度：最坏情况O(n)，也就是这棵树所有节点的值都满足题目要求，则要遍历所有节点
     * 空间复杂度：O(h)，h为树的高度
     * @param root
     * @param l
     * @param r
     * @return
     */
    public static int solution1(TreeNode root, int l, int r) {
        // 递归终止条件
        if (root == null) {
            return 0;
        }

        if (root.value < l) {
            return solution1(root.right, l, r);
        }

        if (root.value > r) {
            return solution1(root.left, l ,r);
        }

        log.info("node's value is {}", root.value);
        return root.value + solution1(root.left, l, r) + solution1(root.right, l, r);
    }
}
