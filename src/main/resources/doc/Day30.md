## Day30

##### 1.思考题

权限控制，根据不同的用户返回不同的字段信息，如何设计？

1. 首先为用户分配角色
2. 创建字段与表的对应关系表
3. 创建字段权限表，为不同的字段分配不同的角色，一个字段可以对应多个角色
4. 查询时，根据该用户的角色，先查询出该用户拥有权限的字段，然后将查询字段动态拼接到查询sql中
5. 结果封装到实体类，返回到前端前，因为值为null的字段都是没有权限的字段，所以序列化时可以直接将值为null的字段忽略，最后返回给前端

##### 2.算法题

数组中一个数字出现的次数超过数组长度的一般。请找出这个数字，数组非空

```java
/**
 * 解法1：
 *      思路：先对数组升序排序，因为数字出现次数超过数组长度一半，那么排序后数组中间的数字必定是目标数字
 *      时间复杂度：排序的时间复杂度O(nlogn)
 *      空间复杂度：O(1)
 * @param nums
 * @return
 */
public static int solution1(int[] nums) {
    int length = nums.length;

    Arrays.sort(nums);
    int mid = (0 + (length - 1)) / 2;
    return nums[mid];
}

/**
 * 解法2：
 *      思路：
 *          遍历数组，把每个数字的次数记录到哈希表，key为此数字的值，value为此数字出现的次数，
 *          返回出现次数大于（数组长度 / 2）的数字
 *      时间复杂度：O(n)
 *      空间复杂度：O(n)
 * @param nums
 * @return
 */
public static int solution2(int[] nums) {
    int length = nums.length;

    int half = nums.length / 2;
    Map<Integer, Integer> map = new HashMap<>(length);
    for (int num : nums) {
        map.put(num, map.getOrDefault(num, 0) + 1);
        if (map.get(num) > half) {
            return num;
        }
    }

    return 0;
}
```





 	

