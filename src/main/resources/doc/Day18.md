## Day18

##### 1.思考题

多线程各种实现、优缺点、使用场景

1. 继承Thread类

   - 实现：写一个类继承Thread类并重写run方法

     ```java
     public static void main(String[] args) {
       	// 1.继承Thread类
         Thread thread = new MyThread();
         thread.start();
     }
     
     static class MyThread extends Thread {
     
         @Override
         public void run() {
             // 写逻辑
         }
     }
     ```

   - 优点：很方便的创建一个新的线程

   - 缺点：继承了Thread，因为Java单继承的特性，所以无法再继承其他类，不够灵活；线程生命周期不好管理；

     无法控制并发最大的线程数；频繁创建线程、垃圾回收线程很消耗资源

   - 使用场景：使用固定几个线程专门用来处理一些逻辑的时候，这些线程不会被频繁创建和垃圾回收

2. 实现Runnable接口

   - 实现：写一个类实现Runnable接口并实现run方法

     ```java
     public static void main(String[] args) {
         // 2.1 实现Runnable接口
         Thread thread1 = new Thread(new MyThread1());
         thread1.start();
     }
     
     static class MyThread1 implements Runnable {
     
         @Override
         public void run() {
             // 写逻辑
         }
     }
     ```

     ```java
     // 2.2 实现Runnable接口的另一张写法
     new Thread(() -> {
         // 写逻辑
     }, "t1").start();
     ```

   - 优点：很灵活很方便的创建新的线程

   - 缺点：线程生命周期不好管理；无法控制并发最大的线程数；频繁创建线程、垃圾回收线程很消耗资源

   - 使用场景：使用固定几个线程专门用来处理一些逻辑的时候，这些线程不会被频繁创建和垃圾回收

3. 实现Callable接口

   - 实现：写一个类实现Callable接口并实现call方法

     ```java
     public static void main(String[] args) {
         // 3.实现Callable接口
         FutureTask futureTask = new FutureTask(new MyThread2());
         Thread thread2 = new Thread(futureTask);
         thread2.start();
         // 拿到call方法的返回结果
         try {
             Object o = futureTask.get();
         } catch (InterruptedException e) {
             e.printStackTrace();
         } catch (ExecutionException e) {
             e.printStackTrace();
         }
         
     }
     
     static class MyThread2 implements Callable {
     
         @Override
         public Object call() throws Exception {
             // 写逻辑
             return "success";
         }
     }
     ```

   - 优点：很灵活很方便的创建新的线程，并且有返回值

   - 缺点：线程生命周期不好管理；无法控制并发最大的线程数；频繁创建线程、垃圾回收线程很消耗资源

   - 使用场景：当需要获得线程执行完后的返回结果时，可以考虑此方法

4.  通过线程池创建

   - 实现：通过Executors工具类创建线程池或手动new一个ThreadPoolExecutor对象创建线程池

     ```java
     // 通过Executors工具类创建可缓存的线程池
     ExecutorService threadPool = Executors.newCachedThreadPool();
     
     try {
         // 模拟10个任务进来
         for (int i = 0; i < 10; i++) {
             threadPool.execute(() -> {
                 log.info("{} 处理任务", Thread.currentThread().getName());
             });
         }
     } catch (Exception e) {
         e.printStackTrace();
     } finally {
         threadPool.shutdown();
     }
     ```

   - 优点：线程可复用，减少反复创建线程对象、垃圾回收的消耗；可以控制并发最大的线程数；可以有效的管理线程

   - 缺点：线程池的参数不好配置，要结合硬件条件和业务类型来合理配置，有一定的难度

   - 使用场景：频繁创建大量新的线程执行任务的时候，可以考虑线程池

##### 2.算法题

给定一个非空数组，返回此数组中第三大的数，时间复杂度限定在O(n)，若存在第三大的数，返回第三大的数，否则返回最大数

```java
/**
 * 思路：
 *      额外借助一个容量为3的result数组，分别依次从小到大保存nums数组中最大的三个数，
 *      从头开始遍历nums数组，每一次遍历都要重新维护result数组，但使用常数级别的时间复杂度
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * @param nums
 * @return
 */
public static int solution1(int[] nums) {
    int length = nums.length;
    if (length <= 2) {
        int max = Arrays.stream(nums).max().getAsInt();
        return max;
    }

    // 如果count >= 3，表示存在第三大的数
    int count = 0;

    // result数组依次从小到大保存nums数组中最大的三个数
    int[] result = new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
    for (int i = 0; i < length; i++) {
        int current = nums[i];
        if (current > result[2]) {
            result[0] = result[1];
            result[1] = result[2];
            result[2] = current;
            count++;
        } else if (current < result[2] && current > result[1]) {
            result[0] = result[1];
            result[1] = current;
            count++;
        } else if (current < result[1] && current > result[0]) {
            result[0] = current;
            count++;
        } else if (current == result[2]) {
            result[0] = result[1];
            result[1] = result[2];
            result[2] = current;
        }
    }

    // 若存在第三大的数，返回第三大的数，否则返回最大数
    return count >= 3 ? result[0] : result[2];
}
```