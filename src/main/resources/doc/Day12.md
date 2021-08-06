## Day12

##### 1.思考题

如何测试一个应用服务器的性能？（有哪些指标和方法）

1. 性能指标：

   - 响应时间：指一次客户端发起请求，到接受到服务端相应结果，整个过程消耗的时间。
   - 最大响应时间：指一次客户端发起请求，到接受到服务端相应结果，整个过程消耗的最大时间。
   - 最小响应时间：指一次客户端发起请求，到接受到服务端相应结果，整个过程消耗的最小时间。
   - 平均响应时间：一批请求的平均响应时间。
   - TPS（Transactions Per Second）：每秒处理的业务数，单位：次/秒
   - QPS（Queries Per Second）：每秒查询次数，单位：次/秒
   - 主要关注：
     - 吞吐量：服务器每秒系统能处理的请求数
     - 响应时间：服务器处理一个请求的耗时
     - 错误率：服务器处理一批请求，出错的请求所占的比例

2. 方法：

   使用压力测试工具：JMeter

   下载地址：https://jmeter.apache.org/download_jmeter.cgi

   可以设置线程数和循环次数，来模拟n个线程对指定接口的并发请求，压测完后会生成结果树，展示各种指标：例如平均响应时间、最大响应时间、最小响应时间、错误率、吞吐量等。

##### 2.算法题

跳台阶问题，一次可跳1阶、2阶或3阶

```java
public class Day12 {

    private final static int MOD = 1000000007;

    /**
     * 解法1：
     *      思路：
     *          1.跳1阶台阶：一种方式
     *              1.跳1阶
     *          2.跳2阶台阶：两种方式
     *              1.跳1阶 + 跳1阶
     *              2.跳2阶
     *          3.跳3阶台阶：四种方式
     *              1.跳1阶 + 跳1阶 + 跳1阶
     *              2.跳1阶 + 跳2阶
     *              3.跳2阶 + 跳1阶
     *              4.跳3阶
     *          4.跳n阶台阶（n >= 4）
     *              1.最后跳1阶达到第n阶：f(n - 1)种
     *              2.最后跳2阶达到第n阶：f(n - 2)种
     *              3.最后跳3阶达到第n阶：f(n - 3)种
     *              4.所以总共有f(n - 1) + f(n - 2) + f(n - 3)种
     *          5.通过以上可总结得到：设上n阶台阶的方法有f(n)种
     *              f(1) = 1
     *              f(2) = 2
     *              f(3) = 4
     *              f(n) = f(n - 1) + f(n - 2) + f(n - 3)，n >= 4
     *          6.递归解法
     *      时间复杂度：指数级，若n太大直接超时
     *      空间复杂度：算不来
     * @param n
     * @return
     */
    public static int solution1(int n) {
        if (n <= 0) {
            return -1;
        }
        if (n == 1) {
            return 1 % MOD;
        }
        if (n == 2) {
            return 2 % MOD;
        }
        if (n == 3) {
            return 4 % MOD;
        }
        return (solution1(n - 1) + solution1(n - 2) + solution1(n - 3)) % MOD;
    }

    /**
     * 解法2：
     *      思路：
     *          思路跟解法1一样，但是对解法1进行了优化，
     *          解法1直接递归，没有保存每一步的计算结果，导致大量的重复计算，
     *          此解法采用迭代的方式，保存每一步的计算结果
     *      时间复杂度：O(n)
     *      空间复杂度：O(1)
     * @param n
     * @return
     */
    public static int solution2(int n) {
        if (n <= 0) {
            return -1;
        }
        if (n == 1) {
            return 1 % MOD;
        }
        if (n == 2) {
            return 2 % MOD;
        }
        if (n == 3) {
            return 4 % MOD;
        }

        // 当前台阶前3阶台阶的跳法总数，初始为第1阶台阶
        int prePrePre = 1 % MOD;
        // 当前台阶前2阶台阶的跳法总数，初始为第2阶台阶
        int prePre = 2 % MOD;
        // 当前台阶前1阶台阶的跳法总数，初始为第3阶台阶
        int pre = 4 % MOD;
        // 当前台阶的跳法总数，初始为第4阶台阶
        int current = (prePrePre + prePre + pre) % MOD;

        for (int i = 4; i <= n; i++) {
            current = (prePrePre + prePre + pre) % MOD;
            prePrePre = prePre;
            prePre = pre;
            pre = current;
        }

        return current;
    }
}
```