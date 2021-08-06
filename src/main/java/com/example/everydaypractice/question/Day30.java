package com.example.everydaypractice.question;

import com.example.everydaypractice.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: Day30
 * @Author: lhb
 * @Date: 2021/8/5 下午6:44
 *
 * 1.说明：
 *      判断一棵二叉树是不是二叉搜索树
 * 2.限制：
 *
 * 3.示例：
 *      输入：略
 *      输出：true or false
 */

public class Day30 {

    /**
     * 思路：
     *      对于二叉搜索树的任意节点，它的左子树所有节点的值都小于根节点的值，它的右子树的所有节点都大于根节点的值，
     *      根据二叉搜索树的特性，中序遍历一棵二叉搜索树，必定得到一个递增排序的有序序列
     *      将中序遍历得到的序列结果保存起来，判断这个序列是否严格单调递增，若是，则true
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root
     * @return
     */
    public static boolean solution1(TreeNode root) {
        if (root == null) {
            return false;
        }

        // list用于保存中序遍历这棵树得到的序列
        List<Integer> list = new ArrayList<>();
        // 中序遍历
        inOrderTraverse(root, list);

        // 若序列非严格单调递增，则不是一棵二叉搜索树
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }

        return true;
    }

    /**
     * 中序遍历一棵树，保存中序遍历得到的序列到list
     * @param root
     */
    private static void inOrderTraverse(TreeNode root, List<Integer> list) {
        if (root != null) {
            // 访问左子树
            inOrderTraverse(root.left, list);
            // 访问根节点，保存值到list
            list.add(root.value);
            // 访问右子树
            inOrderTraverse(root.right, list);
        }
    }
}
