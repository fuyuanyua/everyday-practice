## Day08

##### 1.思考题

为什么不能直接在控制层写业务代码？缺点有哪些？

常见Java Web架构可简单分为以下三层：

- 控制层（Controlller）：主要处理数据交互，对访问控制进行转发
- 业务层（Service）：处理具体的复杂的业务逻辑
- 数据访问层（DAO）：封装了对底层数据库的交互的方法

直接在控制层写业务代码的缺点：

- 导致项目架构混乱，体现不出分层的思想
- 不利于项目代码的维护和扩展
- 耦合度极高，业务逻辑代码难以复用

控制层在对应不同请求url，可能很多功能会有重复，所以控制层就应该是薄薄的一层，业务逻辑交给业务层处理，这样达到解耦、代码可复用、易扩展的效果。

##### 2.算法题

给你个整数数组arr，其中每个元素都不相同。请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。

```java
/**
     * 解法1：
     *      思路：
     *          先对数组排序，然后第一次遍历数组，找出最小差值以及最小差值出现的次数，
     *          第二次遍历数组，组装结果然后返回
     *      时间复杂度：排序O(nlogn) + 遍历O(n) + 遍历O(n)，总时间复杂度O(nlogn)
     *      空间复杂度：O(1)
     * @param nums
     * @return
     */
    public static int[][] solution1(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return null;
        }

        // 先对数组排序
        Arrays.sort(nums);
        // 用于记录最小差值，初始值为排序数组第二项与第一项之差
        int minDifference = nums[1] - nums[0];
        // 用于记录最小差值出现的次数，初始值为0
        int minCount = 0;

        // 第一次遍历数组找出最小差值以及最小差值出现的次数
        for (int i = 0; i < nums.length - 1; i++) {
            int currentDifference = nums[i + 1] - nums[i];
            if (currentDifference == minDifference) {
                minCount++;
            }
            if (currentDifference < minDifference) {
                minDifference = currentDifference;
                minCount = 1;
            }
        }

        int[][] result = new int[minCount][2];
        // 二维数组下标
        int index = 0;
        // 第二次遍历数组，组装结果
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] == minDifference) {
                result[index] = new int[] {nums[i], nums[i + 1]};
                index++;
                // 如果结果已经组装完，直接跳出循环
                if (minCount == index) {
                    break;
                }
            }
        }

        return result;
    }
```

