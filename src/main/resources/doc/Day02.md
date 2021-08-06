## Day02

#### 1.思考题

redis的雪崩、穿透、并发是怎么回事？如何解决？

1. 雪崩

   - 说明：某一时刻缓存大批量失效就是缓存雪崩。我们在设置key时采用了相同的过期时间，导致在某一时刻这批缓存同时过期，在高并发的情况下，大批量请求瞬间全部打到DB，导致DB压力瞬间变大，甚至宕机。

   - 解决方案：可以将每个key的过期时间都设为随机值，避免在某一时刻key大批量过期。

     示例：

     ```java
     redisTemplate.opsForValue().set(1, 1, new Random().nextInt(1000), TimeUnit.SECONDS);
     ```

2. 穿透

   - 说明：查询一个永不存在的数据就是缓存穿透。第一次查询没有缓存，进而查DB，DB也查询不到，所以也没有将这次查询结果写入缓存。导致后续每次请求都去查DB，失去了缓存的意义。

   - 解决方案：对于DB查不到的数据，也可以将value设为null或者0，然后放入缓存，这样后续请求也都会直接走缓存。

   - 将value设为null的方法：

     - 手动将值设为null

       ```java
       redisTemplate.opsForValue().set(1, null);
       ```

     - 若用SpringCache，可以在配置文件中配置：

       ```properties
       spring.cache.redis.cache-null-values=true
       ```

3. 并发

   - 说明：多个线程同时操纵同一个key，可能就会导致value出错。

   - 示例：例如当前key的value为20，表示库存为20，线程1操作key，想把库存 - 1，线程2也操作key，想把库存 - 1，正常情况下最后结果value是18，但是线程1和线程2同时读到了value为20，线程1把库存设为了19，线程2也把库存设为了19，导致最后value是19，这明显是不正确的。

   - 解决方案：get值和set值必须保证是原子操作，所以采用加锁的方式，保证同一时间只有一个线程能操作资源，若是分布式环境下，可以采用分布式锁。

   - 本地锁示例：

     ```java
     lock.lock();
     try {
         Integer value = (Integer)redisTemplate.opsForValue().get(1);
         value = value - 1;
         redisTemplate.opsForValue().set(1, value);
     } catch (Exception e) {
         e.printStackTrace();
     } finally {
         lock.unlock();
     }
     ```

#### 2.算法题

给定一个整数数组nums和一个整数目标值target，请你在该数组中找出 和为目标值target的那两个整数，并返回它们的数组下标。

```java
public class Day02 {

    /**
     * 解法1：
     *      思路：直接双重循环暴力破解
     *      时间复杂度：O(n^2)
     *      空间复杂度：O(1)
     * @param nums
     * @param target
     * @return
     */
    public static int[] solution1(int[] nums, int target) {
        // 返回的结果
        int[] result = new int[2];

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }

        return result;
    }

    /**
     * 解法2：
     *      思路：
     *          额外借助一个哈希表，key存元素的值，value存元素的下标，
     *          那么只需遍历一次数组就可以找出目标结果，空间换时间
     *      时间复杂度：O(n)
     *      空间复杂度：O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] solution2(int[] nums, int target) {
        // 返回的结果
        int[] result = new int[2];

        int length = nums.length;
        // key存数组元素的值，value存数组元素的下标
        Map<Integer, Integer> map = new HashMap<>(length);

        for (int i = 0; i < length; i++) {
            int currentValue = nums[i];
            // containsKey时间复杂度为O(1)
            // 在map中寻找是否有key + 当前元素的值等于目标值，有则返回这两个元素的下标
            if (map.containsKey(target - currentValue)) {
                result[0] = i;
                result[1] = map.get(target - currentValue);
                return result;
            }
            // 没有则保存当前元素的值和下标到map里
            map.put(currentValue, i);
        }

        return result;
    }

}
```