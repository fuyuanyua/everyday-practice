## Day24

##### 1.思考题

一张表A，有两个字段userId，num。接口会不断的有数据流入（高并发），这些数据需要根据userId判断是否存在表中，有则num值加1无则插入。

高并发必然不能直接操作库，先把表中数据存入redis的hash中，key任意，field存userId，value存num。每次请求进来，先判断hash的field中是否存在这个userId（命令：HEXISTS key field），若有，直接自增（命令：HINCRBY key field increment）；若没有，则直接存入（命令：HSET key field value）。为了保证缓存和数据库的数据最终一致，需要定时将缓存的数据批量更新到数据库。

##### 2.算法题

给定一个整数n，返回任意一个由n个各不相同的整数组成的数组，并且这n个整数相加为0

```java
/**
 * 思路：结果数组长度为n，遍历数组，每次赋值赋两项，并且保证这两项相加为0
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * @param n
 * @return
 */
public static int[] solution1(int n) {
    if (n <= 0) {
        return new int[0];
    }

    int[] result = new int[n];
    // 遍历的次数
    int total = 0;
    // 要赋的值的绝对数
    int num = 0;
    // 当n是偶数
    if (n % 2 == 0) {
        total = n / 2;
        for (int i = 0; i < total; i++) {
            num = i + 1;
            result[i] = num;
            result[n - 1 - i] = -num;
        }
    } else { // 当n是奇数
        total = n / 2 + 1;
        for (int i = 0; i < total; i++) {
            if (i == total - 1) {
                result[i] = 0;
                break;
            }
            num = i + 1;
            result[i] = num;
            result[n - 1 - i] = -num;
        }
    }

    return result;
}
```



 	

