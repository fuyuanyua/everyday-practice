package com.example.everydaypractice.question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: Day25
 * @Author: lhb
 * @Date: 2021/7/29 下午7:03
 *
 * 1.说明：
 *      给定一个非空且只包含非负数的整数数组nums，数组的度的定义是指数组任意元素出现频度的最大值，
 *      找出与nums拥有相同大小度的最短子数组，返回其长度
 * 2.限制：
 *      无
 * 3.示例：
 *      输入：[1, 2, 2, 3, 1]
 *      输出：2
 */

public class Day25 {

    /**
     * 思路：
     *      额外借助一个map，key存元素的值，value是list，存元素出现时候的下标，
     *      第一次遍历nums，存结果到map，
     *      第二次遍历map，找出nums的度（也就是找出map的所有value中容量最大的list，这个list的size就是度），
     *      第三次遍历map，找出最短子数组的长度（当前数组长度就是list的末项 - list的首项 + 1）
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @return
     */
    public static int solution1(int[] nums) {
        int length = nums.length;
        // key存元素的值，value是list，存元素出现时候的下标
        Map<Integer, List<Integer>> map = new HashMap<>(length);

        for (int i = 0; i < length; i++) {
            int item = nums[i];
            if (map.containsKey(item)) {
                map.get(item).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(item, list);
            }
        }

        // 度
        int du = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            if (list.size() > du) {
                du = list.size();
            }
        }

        // 最短子数组的长度
        int minlength = Integer.MAX_VALUE;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            int size = list.size();
            if (size == du) {
                // 子数组长度
                int currentSize = list.get(size - 1) - list.get(0) + 1;
                if (currentSize < minlength) {
                    minlength = currentSize;
                }
            }
        }

        return minlength;
    }
}
