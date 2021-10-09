package com.example.everydaypractice.hot100;

/**
 * @Description: Hot009
 * @Author: lhb
 * @Date: 2021/10/9 下午7:26
 *
 * 1.说明：
 *      给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 *      在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
 *      找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 2.限制：
 *      n == height.length
 *      2 <= n <= 10^5
 *      0 <= height[i] <= 10^4
 * 3.示例：
 *      输入：height = [4, 3, 2, 1, 4]
 *      输出：1
 * 4.参考：https://leetcode-cn.com/problems/container-with-most-water/
 */

public class Hot009 {

    /**
     * 思路：
     *      双指针，left指针指向左边，right指针指向右边
     *      S = min(height[left], height[right]) * [right - left]，i、j分别指向左垂直线和右垂直线，
     *      每一次都将left或right向内移动一格，因为面积由短边决定，底缩小1格的情况下，高增大，S才有可能增大，
     *      所以每次都移动left、right中指向短边的那个指针，当left指针和right指针碰撞，跳出循环，得到最终结果
     * 时间复杂度：O(n)
     * 空军复杂度：O(1)
     * @param height
     * @return
     */
    public static int solution1(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        // 左指针，指向左垂直线，初始指向最左边
        int left  = 0;
        // 右指针，指向右垂直线，初始指向最右边
        int right = height.length - 1;
        // 最大面积
        int maxArea = 0;
        // 因为底不变的情况下，面积由短边决定，所以每次都将指向短边的指针向内移动一格，这样总面积可能会增大
        while (left < right) {
            int tempArea = Math.min(height[left], height[right]) * (right - left);
            if (tempArea > maxArea) {
                maxArea = tempArea;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
