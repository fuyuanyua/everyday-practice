package com.example.everydaypractice.question;

/**
 * @Description: Day22
 * @Author: lhb
 * @Date: 2021/7/23 下午6:31
 *
 * 1.说明：
 *      一个 m * n 的矩阵，每行都是非递增的，每列也都是非递增的，求矩阵负数的个数
 * 2.限制：
 *
 * 3.示例：
 *      输入：略
 *      输出：略
 */

public class Day22 {

    /**
     * 思路：
     *      根据题意，此矩阵每行都是非递增，每列也都是非递增，
     *      那么可以发现规律：
     *      遍历某一行，若发现了第一个负数，那么这一行这个数字后面的所有数也都是负数，
     *      若发现的第一个负数正好就是这行的第一个数字，那么这行及以下的所有行全部都是负数
     * 时间复杂度：
     *      最差情况是扫描整个矩阵O(m * n)，
     *      最优情况是扫描到第一个行第一个数字就是负数，O(1)
     *      平均时间复杂度算不来
     * 空间复杂度：O(1)
     * @param input
     * @return
     */
    public static int solution1(int[][] input) {
        // 行数
        int m = input.length;
        // 列数
        int n = input[0].length;

        // 用于统计负数
        int count = 0;
        // 停止遍历矩阵的标志
        boolean flag = false;

        for (int i = 0; i < m; i++) {
            int[] currentRow = input[i];
            for (int j = 0; j < n; j++) {
                if (currentRow[j] < 0) {
                    if (j == 0) {
                        count += (m - i) * n;
                        flag = true;
                    } else {
                        count += (n - j);
                    }
                    break;
                }
            }
            if (flag) {
                break;
            }
        }

        return count;
    }
}
