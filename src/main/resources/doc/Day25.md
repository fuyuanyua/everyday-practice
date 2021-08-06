## Day25

##### 1.思考题

方法中使用了过多if，如何优化这种代码？

- 把if else中逻辑复杂且冗长的业务执行代码抽取出来，额外封装到另一个方法中，直接调用这个方法即可，这样逻辑以及代码的可读性就清晰很多。

- 如果if中的逻辑判断特别长且复杂，也直接抽取出来，额外封装到另一个方法，方法返回一个boolean的结果，if直接根据这个结果来执行接下去的业务逻辑。

- 提前return，if中遇到错误条件，直接return结果，这样可以大大减少else的出现，使代码的逻辑十分清晰，例如以下：

  ```java
  if (condition1) {
      return result1;
  }
  if (condition2) {
      return result2;
  }
  if (condition3) {
      return result3;
  }
  return result4;
  ```

- 简单的else if可用三目运算符代替，例如：

  ```java
  if (a == null) {
      a = 1;
  } else {
      a = 2;
  }
  ```

  可改为：

  ```java
  a == null ? 1 : 2;
  ```

##### 2.算法题

给定一个非空且只包含非负数的整数数组nums，数组的度的定义是指数组任意元素出现频度的最大值，找出与nums拥有相同大小度的最短子数组，返回其长度

```java
/**
 * 思路：
 *      额外借助一个map，key存元素的值，value是list，存元素出现时候的下标，
 *      第一次遍历nums，存结果到map，
 *      第二次遍历map，找出nums的度（也就是找出map的所有value中容量最大的list，这个list的size就是度），
 *      第三次遍历map，找出最短子数组的长度（当前数组长度就是list的末项 - list的首项 + 1）
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * @param nums
 * @return
 */
public static int solution1(int[] nums) {
    int length = nums.length;
    // key存元素的值，value是list，存元素出现时候的下标
    Map<Integer, List<Integer>> map = new HashMap<>(length);

    for (int i = 0; i < length; i++) {
        int item = nums[i];
        if (map.containsKey(item)) {
            map.get(item).add(i);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            map.put(item, list);
        }
    }

    // 度
    int du = 0;
    for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
        List<Integer> list = entry.getValue();
        if (list.size() > du) {
            du = list.size();
        }
    }

    // 最短子数组的长度
    int minlength = Integer.MAX_VALUE;
    for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
        List<Integer> list = entry.getValue();
        int size = list.size();
        if (size == du) {
            // 子数组长度
            int currentSize = list.get(size - 1) - list.get(0) + 1;
            if (currentSize < minlength) {
                minlength = currentSize;
            }
        }
    }

    return minlength;

```





 	

