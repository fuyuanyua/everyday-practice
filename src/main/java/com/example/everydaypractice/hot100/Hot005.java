package com.example.everydaypractice.hot100;

import java.util.*;

/**
 * @Description: Hot005
 * @Author: lhb
 * @Date: 2021/8/30 下午6:53
 */

public class Hot005 {

    /**
     * 解法1：
     *      map存储1到n的所有元素，key和value相等，遍历nums，
     *      移除对应的key，最后返回剩余的key组成的list
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @return
     */
    public static List<Integer> solution1(int[] nums) {
        int length = nums.length;
        // 先初始化map存储1到n的所有元素，key和value相同
        Map<Integer, Integer> map = new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            map.put(i + 1, i + 1);
        }
        // 遍历nums，map移除相应元素
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            map.remove(num);
        }

        if (map.isEmpty()) {
            return Collections.emptyList();
        }

        List<Integer> list = new ArrayList<>();
        for (Integer key : map.keySet()) {
            list.add(key);
        }
        return list;
    }

    /**
     * 解法2：
     *      先遍历nums，存储元素到set，然后set移除nums中的元素，
     *      添加1到n中未在nums中的元素，最后返回set元素组成的list，
     *      其实是解法1的逆向思维，时间复杂度和空间复杂度都没降低
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @return
     */
    public static List<Integer> solution2(int[] nums) {
        int length = nums.length;
        // 先利用set将nums去重
        Set<Integer> set = new HashSet<>(length);
        for (int i = 0; i < length; i++) {
            set.add(nums[i]);
        }
        // set移除nums中的元素，添加1到n中未在nums中的元素，最后返回
        for (int i = 1; i <= length; i++) {
            if (set.contains(i)) {
                set.remove(i);
            } else {
                set.add(i);
            }
        }
        return new ArrayList<>(set);
    }

    /**
     * 解法3：
     *      遍历nums，每遍历到一个元素，将下标为【该元素绝对值-1】的元素设为负数，表示该下标出现过，
     *      长度为n的数组，下标范围为0到n-1，值范围为1到n，遍历完后值仍然为正数，则表示该下标没出现过，
     *      所以最后返回值为正数的所有【下标+1】所组成的list
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public static List<Integer> solution3(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }
        List<Integer> list = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
