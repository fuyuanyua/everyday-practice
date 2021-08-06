## Day03

##### 1.思考题

在什么情况下，程序使用单线程比使用多线程更有效率？原因和举例。

1. 当硬件是单核单线程cpu时：

   因为在单核单线程cpu的机器上，只有一个逻辑核心，线程并不能并行执行，线程仍然是串行执行的，同一时间只能有一个线程得到cpu，只不过线程之间切换的速度很快，让人以为是并行执行，但是线程之间频繁切换是很消耗性能的。所以在非IO密集型的任务下（不考虑线程阻塞），开启了多线程不但不会提升效率，反而会在线程切换的时候降低了效率。

2. 当处理简单计算任务时：

    因为处理简单计算任务，单线程也能很快完成，若开启多线程，首先新建n个线程要消耗资源，线程切换也消耗性能，若要保证数据安全，还要加锁处理，进一步消耗性能，最后还要垃圾回收这n个线程。所以当多线程带来的效率提升很小，甚至远不及以上这些带来的性能消耗的时候，单线程将比多线程更有效率。

##### 2.算法题

如果数组是单调递增或单调递减的，那么它是单调的。如果对于所有 i <= j，A[i] <= A[j]，那么数组A是单调递增的。如果对于所有 i <= j，A[i] >= A[j]，那么数组A是单调递减的。当给定的数组A是单调数组时返回true，否则返回false。

```java
public class Day03 {

    /**
     * 解法1：
     *      思路：
     *          一次遍历，设置两个标识，一个是递增标识，一个是递减标识，初始都为true，
     *          从头开始遍历数组，若后一个元素大于当前元素，则递减标识设为false，
     *          若后一个元素小于当前元素，则递增标识设为true，
     *          遍历完后若递减标识和递增标识都为false，则表示数组不具备单调性，否则数组是单调的
     *      时间复杂度：O(n)
     *      空间复杂度：O(1)
     * @param nums
     * @return
     */
    public static boolean solution1(int[] nums) {
        int length = nums.length;

        if (length <= 0 || nums == null) {
            return false;
        }

        // 递增标识
        boolean increase = true;
        // 递减标识
        boolean decrease = true;

        // length - 1，表示遍历到倒数第二个元素，否则下标越界
        for (int i = 0; i < length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                decrease = false;
            } else if (nums[i + 1] < nums[i]) {
                increase = false;
            }
        }

        return (decrease || increase);
    }

    /**
     * 解法2：
     *      思路：两次遍历，一次判断数组是否递增，一组判断数组是否递减
     *      时间复杂度：O(n)
     *      空间复杂度：O(1)
     * @param nums
     * @return
     */
    public static boolean solution2(int[] nums) {
        int length = nums.length;

        if (length <= 0 || nums == null) {
            return false;
        }

        return (isIncrease(nums) || isDecrease(nums));
    }

    private static boolean isDecrease(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isIncrease(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                return false;
            }
        }
        return true;
    }
}
```