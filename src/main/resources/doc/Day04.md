## Day04

##### 1.思考题

IO多路复用是什么？Java有没有类似的实现？

1. IO：

   可以分为磁盘IO、网络IO。

2. 网络IO：

   网络IO对应两端，客户端和服务端，以服务端为例，来说明一次IO过程：

   1. 服务端和客户端建立连接
   2. 客户端通过协议栈将数据发送到服务端的网卡
   3. 通过DMA（Direct Memory Access）技术，将网卡的数据拷贝到内核空间
   4. 将内核空间的数据拷贝到此进程的用户空间中

   所以一般网络IO分为两阶段：以上步骤2-3为等待数据阶段，以上步骤4为拷贝数据阶段

3. IO模型

   - 同步阻塞：服务端与客户端建立连接后，服务端线程在等待数据、拷贝数据都处于阻塞状态，线程不能做其他事情。
   - 同步非阻塞：服务端在等待数据阶段不会阻塞，先直接返回一个错误，然后线程轮询去查询内核的数据有没有准备好，若准备好了再将内核的数据拷贝到用户空间中。
   - 多路复用：用单个线程去处理多个网络连接，在等待数据阶段，内核负责轮询所有socket，当某个socket有数据准备好了，再去通知应用，然后将数据从内核空间拷贝到用户空间。

4. Java的实现：

   Java中java.nio包下：

   - Channel接口：抽象成一个客户端和服务端的连接。
   - Selector类：多路复用选择器，可以检测注册在此Selector上的多个channel，是否有channel处于就绪状态，从而实现了单线程对多channel的管理。

##### 2.算法题

给定一个整数数组，判断是否存在重复元素。如果存在一值在数组中出现至少两次，方法返回true，如果数组中每个元素都不相同，则返回false。

```java
/**
 * 解法1：
 *      思路：先对数组进行排序，然后遍历数组比较相邻元素，若相邻元素值相等，则表示存在重复元素
 *      时间复杂度：排序O(nlogn)，遍历数组O(n)，所以总时间复杂度O(nlogn)
 *      空间复杂度：O(1)
 * @param nums
 * @return
 */
public static boolean solution1(int[] nums) {
    int length = nums.length;

    if (length <= 1 || nums == null) {
        return false;
    }

    // JDK排序平均时间复杂度O(nlogn)
    Arrays.sort(nums);

    for (int i = 0; i < length - 1; i++) {
        if (nums[i + 1] == nums[i]) {
            return true;
        }
    }

    return false;
}

/**
 * 解法2：
 *      思路：
 *          额外借助一个HashSet，HashSet的元素是不可重复的，
 *          遍历数组，每访问到一个元素，判断set中是否存在这个元素，
 *          存在，则直接返回true；不存在，则将此元素添加到set中
 *      时间复杂度：O(n)
 *      空间复杂度：O(n)
 * @param nums
 * @return
 */
public static boolean solution2(int[] nums) {
    int length = nums.length;

    if (length <= 1 || nums == null) {
        return false;
    }

    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < length; i++) {
        int current = nums[i];
        // Set的contains方法时间复杂度O(1)
        if (set.contains(current)) {
            return true;
        }
        set.add(current);
    }

    return false;
}
```