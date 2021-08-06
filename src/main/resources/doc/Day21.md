## Day21

##### 1.思考题

开发完毕后如何减少线上bug出现？

1. 开发人员在开发完毕后，小组成员之间相互进行代码review，及时发现问题。
2. 开发人员在开发完一个功能后，在本地做好自测，先自己走一遍流程，若发现bug能及时重写逻辑，然后发布到开发环境，再验证功能。
3. 开发人员在开发环境验证完后，再提交给测试人员，在测试环境进行测试。
4. 测试环境测试通过后，在最终发布之前，还可以开启小范围的灰度测试，灰度测试也通过后，再逐步发布正式版本。

##### 2.算法题

实现JDK的sqrt方法

```java
/**
 * 思路：二分法查找，通过二分法查找出最大的 target，满足 target * target <= num
 * 时间复杂度：O(logn)，n为数字的值，二分法查找每次都能缩小一半范围
 * 空间复杂度:1
 *
 * @param num
 * @return
 * @throws Exception
 */
public static int sqrt(int num) throws Exception {
    if (num == 0) {
        return 0;
    }
    if (num < 0) {
        throw new Exception("输入值非法：不可小于0");
    }

    int low = 1;
    int high = num;
    int mid = (low + high) / 2;;
    while (low <= high) {
        mid = (low + high) / 2;
        if (mid * mid == num) {
            return mid;
        }
        if (mid * mid > num) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }

    return (mid * mid > num) ? (mid - 1) : mid;
}
```



 	

