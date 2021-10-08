## Day09

##### 1.思考题

设计一个客户端的注册接口（考虑安全性）。

- 使用post请求，参数封装在请求体，而不是直接暴露在url，使用https协议。
- 禁止暴露密码：用户输入的密码禁止使用明文传输，要对密码进行加密，数据库中也不存储明文，而是存储密文。
- 采用复杂密码：禁止用户使用简单的密码进行注册，防止被暴力破解。
- 密码二次确认：用户输入的密码要进行二次输入，保证两次输入的密码是一致的。
- 参数校验：对用户输入的各项信息进行校验，校验不通过注册失败，前端和后端都要校验，前端校验提升用户体验，后端再次校验保证安全。
- 用户名保证唯一：用户名重复则注册失败
- 邮箱/手机验证码机制：用户需要输入邮箱或手机，然后将得到的验证码输入，再提交注册，验证码一致才注册成功，一方面，将此用户与此邮箱或此手机绑定，是一一对应的，另一方面，设置验证码发送间隔为30s或60s，以上两个方面能有效防止用户恶意注册
- ip限制：若某个ip短时间内请求多次，将此ip加入黑名单一段时间（几个小时或者一天），限制其访问
- 记录日志：每次注册请求都记录到日志表

##### 2.算法题

给你一个正整数，输出它的补数。补数是对该数的二进制表示取反。

```java
/**
 * 解法1：
 *      思路：
 *          先将输入的正整数转为对应的二进制数组，遍历数组，
 *          将每一位都取反，然后将二进制数组转为十进制整数返回
 * @param a
 * @return
 */
public static int solution1(int a) {
    char[] chars = Integer.toBinaryString(a).toCharArray();
    for (int i = 0; i < chars.length; i++) {
        if (chars[i] == '0') {
            chars[i] = '1';
        } else {
            chars[i] = '0';
        }
    }
    String s = String.valueOf(chars);
    int result = Integer.parseInt(s, 2);
    return result;
}

/**
 * 解法2：
 *      思路：
 *          采用异或运算，
 *          a ^ a = 0
 *          a ^ b = 1
 *          b ^ b = 0
 *          101 ^ 010 = 111
 *          101 ^ 111 = 010
 *          所以只要将输入值和与输入值相同位数的最大值（也就是全部位都取1）进行一下异或运算，就得到结果，
 *          得到与输入值相同位数的最大值的方法是：(大于等于输入值的最近的2的整数次幂的值) - 1
 * @param a
 * @return
 */
public static int solution2(int a) {
    long temp = 1;
    while (temp <= a) {
        temp = temp << 1;
    }
    temp = temp - 1;
    return a ^ (int)temp;
}
```