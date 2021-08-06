## Day29

##### 1.思考题

表a有两个字段k和v，如何用MyBatis查询出来返回一个Map，map的key为k的值，value为v的值？

1. mapper.xml文件中将查询返回结果resultType设置为Map
2. DAO层接口用List<Map<K, V>>来接收查询结果
3. new一个map，遍历list，每一次遍历，map.put(item.get(k), item.get(v))，item表示list里的每一个map

##### 2.算法题

给定一个未排序数组，找到最长递增子数列的个数

```java
/**
 * 思路：
 *      动态规划：
 *      dp[i]存储以nums[i]结尾最长递增子序列的长度,
 *      count[i]存储以nums[i]结尾最长递增子序列出现的次数
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(n)
 * @param nums
 * @return
 */
public static int solution1(int[] nums) {
    if (ArrayUtils.isEmpty(nums)) {
        return 0;
    }

    int length = nums.length;
    if (length == 1) {
        return 1;
    }

    // dp[i]存储以nums[i]结尾最长递增子序列的长度
    int[] dp = new int[length];
    dp[0] = 1;
    // count[i]存储以nums[i]结尾最长递增子序列出现的次数
    int[] count = new int[length];
    count[0] = 1;
    // 记录最长递增子序列长度
    int maxLength = 1;
    for (int i = 1; i < length; i++) {
        // dp[i]默认设为1，因为最坏的情况以nums[i]结尾最长递增子序列就是nums[i]本身，所以长度为1
        dp[i] = 1;
        // count[i]默认设为1，因为最少出现一次
        count[i] = 1;
        for (int j = 0; j < i; j++) {
            if (nums[i] > nums[j]) {
                if (dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    count[i] = count[j];
                } else if (dp[i] == dp[j] + 1) {
                    count[i] = count[i] + count[j];
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
    }

    int result = 0;
    for (int i = 0; i < length; i++) {
        if (dp[i] == maxLength) {
            result += count[i];
        }
    }

    return result;
}
```







 	

