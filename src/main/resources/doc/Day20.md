## Day20

##### 1.思考题

从开发角度来看，有什么方法可以做到灰度发布？

服务端的灰度发布：

1. 物理灰度：专门准备几台服务器，用来部署灰度版本的服务，通过流量控制，将少部分用户的请求转发到灰度服务上，若灰度测试通过，则逐步把正式服务器的服务升级为新版本。
2. 逻辑灰度：通过硬编码的方式，将灰度服务的逻辑写在代码中，同时在数据库中专门建一张配置表，通过配置表配置开关，来控制用户进入到哪一段逻辑代码。缺点就是代码有点繁琐，耦合度很高，并且在日后还要删除相关代码。

##### 2.算法题

给定s和t两个字符串，判断他们的最终结果是否相等，#表示退格字符

```java
private final static char FLAG = '#';

/**
 * 解法1：
 *      思路：
 *          分别遍历字符串s和字符串t得到最终结果，将两个结果比较，相等则返回true
 *      时间复杂度：O(m + n)，m为字符串s的长度，n为字符串t的长度
 *      空间复杂度：O(m + n)，m为字符串s的长度，n为字符串t的长度
 * @param s
 * @param t
 * @return
 */
public static boolean solution1(String s, String t) {
    // getFinalStr1方法不会返回null，所以不用判断空指针
    return getFinalStr1(s).equals(getFinalStr1(t));
}

/**
 * 解法2：
 *      思路：
 *          分别遍历字符串s和字符串t得到最终结果，将两个结果比较，相等则返回true
 *      时间复杂度：O(m + n)，m为字符串s的长度，n为字符串t的长度
 *      空间复杂度：O(m + n)，m为字符串s的长度，n为字符串t的长度
 * @param s
 * @param t
 * @return
 */
public static boolean solution2(String s, String t) {
    // getFinalStr2方法不会返回null，所以不用判断空指针
    return getFinalStr2(s).equals(getFinalStr2(t));
}

/**
 * 将输入的字符串按规则输出：
 *      额外准备一个字符串 sb 用于记录结果，遍历字符串 input，
 *      如果当前的字符是'#'，如果 sb 不为空串，删除 sb 的最后一个字符，
 *      如果当前的字符不是是'#'，将当前的字符追加到 sb 的尾部，
 *      遍历完字符串 input 后，返回字符串 sb，就是最终结果
 * @param input
 * @return
 */
private static String getFinalStr1(String input) {
    String emptyStr = "";
    if (StringUtils.isEmpty(input)) {
        return emptyStr;
    }

    StringBuilder sb = new StringBuilder();
    int length = input.length();
    for (int i = 0; i < length; i++) {
        char c = input.charAt(i);
        if (c == FLAG) {
            if (sb.length() != 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        } else {
            sb.append(c);
        }
    }

    return sb.toString();
}

/**
 * 将输入的字符串按规则输出：
 *      思路与getFinalStr1方法类似，只是用栈来存储结果，
 *      遍历字符串，若当前字符是'#'，则弹出栈顶字符，否则将字符入栈，
 *      遍历栈得到最终结果
 * @param input
 * @return
 */
private static String getFinalStr2(String input) {
    String emptyStr = "";
    if (StringUtils.isEmpty(input)) {
        return emptyStr;
    }

    Stack<Character> stack = new Stack<>();
    int length = input.length();
    for (int i = 0; i < length; i++) {
        char c = input.charAt(i);
        if (c == FLAG) {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        } else {
            stack.push(c);
        }
    }

    StringBuilder sb = new StringBuilder();
    for (Character character : stack) {
        sb.append(character);
    }

    return sb.toString();
}
```



 	

