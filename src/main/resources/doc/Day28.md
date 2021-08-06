## Day28

##### 1.思考题

如何防止用户重复提交表单？

1. 唯一约束：

   可以对数据库表的字段做唯一约束，重复插入会报错。

2. token机制：
   提交前，从服务端获取一个令牌，服务端也把这个令牌存在redis中，前端提交请求就把这个令牌也带过去，服务端校验前端提交的令牌和redis中的令牌，若相等，则把redis的令牌删除，然后执行后续业务。那么如果多次重复提交，也只有第一次提交会校验通过然后执行业务，后续的提交，redis中都不存在这个key，所以都校验不通过，不会去执行后续业务。

   从redis获取令牌 -> 比较redis的令牌和前端传来的令牌 -> 从redis删除令牌，这三个操作一定要是原子操作，所以要使用lua脚本保证原子性，或者加锁，也能保证原子性。

3. 各种锁机制：

   - 数据库乐观锁：

     CAS思想，表冗余一个version字段，每次先查出version，更新的时候对比version，一致才会更新，然后version + 1，否则不一致表示数据已经被改过，不执行更新操作。

   - 数据库悲观锁：

     select xxx for update，查询的时候就这条记录上锁，其他线程的查询就会阻塞，然后做判断和更新操作，更新完才会释放锁。

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





 	

