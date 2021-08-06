## Day11

##### 1.思考题

线上JVM堆溢出了，该怎么定位问题？

1. 先获取到Java进程的pid：使用`top`命令或者`ps -ef|grep java`命令获取
2. 借助jmap分析：
   - `jmap -heap pid`：打印堆的概要信息，包括GC算法、堆的配置信息、堆的各个分区的内存使用情况等
   - `jmap -finalizerinfo pid`：打印正在等待垃圾回收的对象的信息
   - `jmap -histo pid`：展示class的内存情况：包括实例数、大小、类名
3. 直接根据错误日志分析：
   - OOM：unable to create new native thread：说明服务创建太多线程了，超过系统极限，一般linux系统允许单个进程最多创建1024个线程，所以要分析应用是否真的需要创建这么多线程，尽可能把线程数降到最低。
   - OOM：java heap space：堆内存溢出，通过-XX:+HeapDumpOnOutOfMemeryError拿到内存dump文件，然后分析。或者-Xms -Xmx修改堆内存空间大小。
   - OOM：GC overhead limit exceeded：超过98%的时间做GC并且回收了不到2%的堆内存，也要根据dump文件进行分析。
   - OOM：Direct buffer memory：直接内存溢出，可通过-XX:MaxDirectMemorySize 调节大小。
   - OOM：Metaspace：元空间溢出，元空间存放虚拟机加载的类信息、常量池、静态变量等，可通过-XX:MaxMetaspaceSize调节大小。

##### 2.算法题

给定一副牌，每张牌上都写着一个整数。此时，你需要选定一个数字X，使我们可以将整副牌按下述规则分成1组或更多组：每组都有 X 张牌。组内所有的牌上都写着相同的整数。仅当你可选的 X >= 2 时返回 true。

```java
/**
 * 解法1：
 *      思路：
 *          先遍历数组，得到每张牌的数量，再求的各牌数量的最大公约数，
 *          若最大公约数 >= 2，则返回true
 * @param nums
 * @return
 */
public static boolean solution1(int[] nums) {
    if (nums.length <= 1) {
        return false;
    }

    // 统计每张牌的张数，key为牌名，value为牌的张数
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int item = nums[i];
        map.put(item, map.getOrDefault(item, 0) + 1);
    }

    // 求各牌的数量的最大公约数
    int greatestCommonDivisor = -1;
    int current;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        current = entry.getValue();
        if (current == 1) {
            return false;
        }
        if (greatestCommonDivisor == -1) {
            greatestCommonDivisor = current;
        } else {
            greatestCommonDivisor = getGreatestCommonDivisor(greatestCommonDivisor, current);
        }

    }

    if (greatestCommonDivisor < 2) {
        return false;
    }

    return true;
}

/**
 * 求x、y两数的最大公约数
 * 参考：https://zh.wikipedia.org/wiki/%E8%BC%BE%E8%BD%89%E7%9B%B8%E9%99%A4%E6%B3%95
 * @param x
 * @param y
 * @return
 */
public static int getGreatestCommonDivisor(int x, int y) {
    if (y == 0) {
        return x;
    }
    int z = x % y;
    return getGreatestCommonDivisor(y, z);
```