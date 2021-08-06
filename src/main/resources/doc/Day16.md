## Day16

##### 1.思考题

乐观锁和悲观锁的区别？代码验证

- 悲观锁：每次取数据都悲观的认为其他线程会去修改这个数据，所以每次取数据都上锁，那么其他线程就会阻塞，当执行完操作后才释放锁，Java中ReentrantLock、synchronized等都是悲观锁。

  以ReentrantLock举例：

  ```java
  @Slf4j
  public class PessimisticLockDemo {
  
      /**
       * 测试悲观锁，两个线程分别同时对资源类执行100000次add操作，最终结果一定是200000
       * @param args
       */
      public static void main(String[] args) {
          Resource resource = new Resource();
  
          new Thread(() -> {
              for (int i = 0; i < 100000; i++) {
                  resource.add();
              }
          }, "t1").start();
  
          new Thread(() -> {
              for (int i = 0; i < 100000; i++) {
                  resource.add();
              }
          }, "t2").start();
  
          try {
              Thread.sleep(1000 * 3);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
  
          log.info("最终计算结果结果 = {}", resource.get());
      }
  
      /**
       * 资源类
       */
      static class Resource {
  
          int a = 0;
  
          Lock lock = new ReentrantLock();
  
          /**
           * add方法加上悲观锁，同一时间只能有一个线程执行方法
           */
          public void add() {
              lock.lock();
              try {
                  a++;
                  log.info("{} add", Thread.currentThread().getName());
              } catch (Exception e) {
                  e.printStackTrace();
              } finally {
                  lock.unlock();
              }
          }
  
          public int get() {
              return a;
          }
      }
  }
  ```

- 乐观锁：每次取数据都乐观的认为其他线程不会去修改这个数据，所以不上锁，只有在更新数据的时候，去比较一下数据有没有被修改，被修改了则不更新，没被修改才更新。所以乐观锁并不是一把真正的物理锁，主要思想就是CAS（比较并交换算法），CAS算法包含三个操作数——内存位置、预期原值及新值。执行CAS操作的时候，将内存位置的值与预期原值比较，如果相匹配，那么处理器会自动将该位置值更新为新值，否则，处理器不做任何操作。Java中原子类都用到了CAS思想，也就是乐观锁。

  以AtomicInteger举例：

  ```java
  @Slf4j
  public class OptimisticLockDemo {
  
      public static void main(String[] args) {
          AtomicInteger atomicInteger = new AtomicInteger(0);
  
          // 五个线程分别同时对atomicInteger执行100次getAndIncrement方法，
          // 因为getAndIncrement使用了CAS算法，所以最终结果一定是500
          for (int i = 0; i < 5; i++) {
              new Thread(() -> {
                  for (int j = 0; j < 100; j++) {
                      atomicInteger.getAndIncrement();
                  }
              }, "t" + i).start();
          }
  
          try {
              Thread.sleep(1000 * 3);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
  
          log.info("最终计算结果 = {}", atomicInteger.intValue());
      }
  }
  ```

  

##### 2.算法题

给定一个数组A[0,1,…,n-1]，请构建一个数组B[0,1,…,n-1]，其中B[i]的值是数组A中除了下标i以外的元素的积, 即B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]，不能使用除法。

```java
/**
 * 解法1：
 *      思路：暴力破解
 *      时间复杂度：O(n^2)，n为数组长度
 *      空间复杂度：O(1)
 *      缺点：时间复杂度太高
 * @param nums
 * @return
 */
public static int[] solution1(int[] nums) {
    if (nums == null) {
        return null;
    }

    int length = nums.length;
    if (length == 0) {
        return new int[0];
    }

    int[] result = new int[length];
    for (int i = 0; i < length; i++) {
        int item = 1;
        for (int j = 0; j < length; j++) {
            if (j == i) {
                continue;
            }
            item = item * nums[j];
        }
        result[i] = item;
    }

    return result;
}

/**
 * 解法2：
 *      思路：
 *          以B[i]为例，B[i] = 数组A下标为i的元素的左边所有元素乘积 * 数组A下标为i的元素的右边所有元素乘积，
 *          所以第一次遍历求出数组A下标为i的元素的左边所有元素乘积，放入B[i]
 *          第二次遍历求出数组A下标为i的元素的右边所有元素乘积，放入temp[i]，
 *          B[i] = B[i] * temp[i]
 *          最后返回数组B
 *      时间复杂度：O(n)，n为数组长度
 *      空间复杂度：O(n)，因为额外使用了一个长度为n的临时数组
 * @param nums
 * @return
 */
public static int[] solution2(int[] nums) {
    if (nums == null) {
        return null;
    }

    int length = nums.length;
    if (length == 0) {
        return new int[0];
    }

    // 第一次遍历，result[i]保存数组nums下标为i的元素的左边所有元素乘积
    int[] result = new int[length];
    for (int i = 0; i < length; i++) {
        if (i == 0) {
            result[i] = 1;
            continue;
        }
        result[i] = result[i - 1] * nums[i - 1];
    }

    // 第二次遍历，temp[i]保存数组nums下标为i的元素的右边所有元素乘积
    int[] temp = new int[length];
    for (int i = length - 1; i >= 0; i--) {
        if (i == length - 1) {
            temp[i] = 1;
            result[i] = result[i] * temp[i];
            continue;
        }
        temp[i] = temp[i + 1] * nums[i + 1];
        // result[i]最终结果 = 数组nums下标为i的元素的左边所有元素乘积 * 数组nums下标为i的元素的右边所有元素乘积
        result[i] = result[i] * temp[i];
    }

    return result;
}
```

