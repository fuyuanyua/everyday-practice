## Day07

##### 1.思考题

站在缓存服务器的角度上，应该怎么定义缓存的使用规范？

1. 键名应该设计的简单清晰，不能设置的过长，长的键名不仅消耗内存空间，还会影响查询性能。
2. 键对应的值存储空间不能过大，否则频繁查询这个key很消耗网络IO。
3. 对于key，应该设置随机失效时间，避免同一时间大面积的key失效，引起缓存雪崩的问题。
4. 对于热点数据，为了避免key过期失效而发生缓存击穿的情况，可以设置这个key永不过期。
5. 要设置合理的数据淘汰策略，当缓存空间满了之后，可以根据淘汰策略有效的淘汰掉一部分数据，释放缓存空间。
6. 设置缓存的最大内存，不可超过服务器的最大物理内存，否则超过最大物理内存后，将会使用一部分硬盘空间当作临时内存，而硬盘的读写速度是远远低于内存的，设置命令如下：maxmemory xxxmb。
7. 关注缓存服务器的网络带宽，高并发查询缓存，瓶颈可能卡在网络带宽上。
8. 要使用连接池，并合理配置连接池，相比于查询，缓存的连接创建非常耗时，所以要使用连接池，避免频繁连接带来的性能消耗。

##### 2.算法题

给你一个字符串text，你需要使用text中的字母来拼凑尽可能多的单词"balloon"。

```java
public class Day07 {

    private final static char LOWER_CASE_A = 'a';
    private final static char LOWER_CASE_B = 'b';
    private final static char LOWER_CASE_L = 'l';
    private final static char LOWER_CASE_O = 'o';
    private final static char LOWER_CASE_N = 'n';
    private final static int MIN = 7;

    /**
     * 解法1：
     *      思路：
     *          利用一个哈希表记录b、a、l、o、n这五个字母的次数，因为"balloon"单词中，
     *          l和o都出现了两次，所以l、o这两个字母的次数最终都要除以2（向下取整），
     *          最后返回这五个字母出现的最终次数的最小值
     *      时间复杂度：O(n)，n为字符串长度
     *      空间复杂度：使用常数级额外空间，O(1)
     * @param text
     * @return
     */
    public static int solution1(String text) {
        if (StringUtils.isBlank(text)) {
            return 0;
        }

        char[] chars = text.toCharArray();
        int length = chars.length;

        if (length < MIN) {
            return 0;
        }

        // 记录每个字符出现的次数
        Map<Character, Integer> map = new HashMap<>(5);
        for (char c : chars) {
            switch (c) {
                case LOWER_CASE_A:
                    map.put(LOWER_CASE_A, map.getOrDefault(LOWER_CASE_A, 0) + 1);
                    break;
                case LOWER_CASE_B:
                    map.put(LOWER_CASE_B, map.getOrDefault(LOWER_CASE_B, 0) + 1);
                    break;
                case LOWER_CASE_L:
                    map.put(LOWER_CASE_L, map.getOrDefault(LOWER_CASE_L, 0) + 1);
                    break;
                case LOWER_CASE_O:
                    map.put(LOWER_CASE_O, map.getOrDefault(LOWER_CASE_O, 0) + 1);
                    break;
                case LOWER_CASE_N:
                    map.put(LOWER_CASE_N, map.getOrDefault(LOWER_CASE_N, 0) + 1);
                    break;
                default:
            }
        }

        List<Integer> list = Arrays.asList(map.getOrDefault(LOWER_CASE_A, 0),
                map.getOrDefault(LOWER_CASE_B, 0),
                map.getOrDefault(LOWER_CASE_L, 0) / 2,
                map.getOrDefault(LOWER_CASE_O, 0) / 2,
                map.getOrDefault(LOWER_CASE_N, 0));

        int result = Integer.MAX_VALUE;
        for (int current : list) {
            if (current <= result) {
                result = current;
            }
        }
        return result;
    }
}
```