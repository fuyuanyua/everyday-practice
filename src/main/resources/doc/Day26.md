## Day26

##### 1.思考题

SpringBoot项目中如何实现一个可自动配置的项目子模块，并阐述其实现原理？

实现：

1. 先创建一个SpringBoot项目，并引入自动化配置依赖spring-boot-autoconfigure
2. 创建一个XxxProperties配置类，配置类需要加上@ConfigurationProperties(prefix = "xxx.xx")注解，会从yml或properties配置文件中读取前缀为"xxx.xx"的信息，并将属性一一映射，封装成配置类对象，类上加@Component注解，纳入容器。
3. 创建一个XxxService服务类，用于写业务功能。
4. 创建一个XxxAutoConfiguration自动配置类，加上注解@Configuration，注入XxxProperties配置类对象，并提供一个方法，通过配置类对象的属性来创建服务类对象，返回此对象，方法上加@Bean注解，将此对象纳入容器。类上再加上@ConditionalOnClass(XxxService.class)注解，表示只有当XxxService类存在于classpath中时才会进行相应的实例化
5. 在类路径下新建META-INF/spring.factories，在此文件中注册XxxAutoConfiguration自动配置类
6. 将此项目打包到本地或上传到maven私服，其他项目就可以通过maven来引入此项目了

原理：

@SpringBootApplication注解中的@EnableAutoConfiguration表示启用自动配置，会去加载META-INF/spring.factories中的信息，得到自动配置类，并加载到容器中，实现自动配置。

##### 2.算法题

给定一个整数数组nums，找到一个具有最大和的连续子数组，返回其最大和，子数组最少包含一个元素

```java
/**
 * 思路：
 *      动态规划
 *          1.已知数组nums
 *          2.创建一个dp数组，长度为nums.length
 *          3.dp[i]保存以nums[i]结尾的子数组中的最大和，所以dp[0] = nums[0]
 *          4.求dp[i]，从第二项开始遍历nums数组
 *              1.如果dp[i - 1] <= 0，那么dp[i] = nums[i]
 *              2.如果dp[i - 1] > 0，那么dp[i] = nums[i] + dp[i - 1]
 *          5.从dp数组中找出最大的一个数字，这个数字就是目标结果
 * @param nums
 * @return
 */
public static int solution1(int[] nums) {
    if (nums == null) {
        return 0;
    }

    int length = nums.length;
    if (length == 0) {
        return 0;
    }

    // dp数组，dp[i]保存以nums[i]结尾的子数组中的最大和
    int[] dp = new int[length];
    dp[0] = nums[0];

    // 根据规则为dp数组的每一项赋值
    for (int i = 1; i < length; i++) {
        if (dp[i - 1] > 0) {
            dp[i] = dp[i - 1] + nums[i];
        } else {
            dp[i] = nums[i];
        }
    }

    // 找出dp数组的最大值，这个值就是目标结果
    int result = Arrays.stream(dp).max().getAsInt();
    return result;
}
```







 	

