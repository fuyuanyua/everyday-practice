## Day19

##### 1.思考题

如何避免线上或测试服务器的数据库数据被删除？

1. 做好权限的分配和管理，按最小化原则，只分配够用的最少权限，严格控制具有删除库和表的权限的人数。
2. 做好备份，每天自动备份数据库数据，并且存到别的服务器上，以防数据被删除，可以从备份文件恢复数据。
3. 在业务系统层面，做好防SQL注入，防止SQL注入产生风险；删除操作统一为逻辑删除，而非物理删除。
4. 搭建从库，例如部署一台主数据库服务器、多台从数据库服务器，主数据库的数据实时同步到从数据库，那么一旦主数据库服务器发生物理损坏，例如硬盘故障、机房发生自然灾害损坏了服务器等情况，也不用担心数据的丢失。

##### 2.算法题

写一个方法来查找字符串数组中的最长公共前缀，若不存在公共前缀，返回""

```java
/**
 * 解法1：
 *      思路：
 *          先遍历字符串数组，获取到字符串数组中最短的字符串的长度 minStrLength，
 *          再从头开始比较每个字符串的每一个字符，若都相等，拼接这个字符到结果字符串中
 *          例如：第一轮比较每个字符串的第一个字符，第二轮比较每个字符串的第二个字符，
 *          比较 minStrLength 轮，最后返回结果字符串
 *      时间复杂度：O(n * m)，n为最短字符串的长度，m为字符串数组的长度
 *      空间复杂度：O(1)
 * @param strs
 * @return
 */
public static String solution1(String[] strs) {
    String emptyResult = "";
    if (strs == null) {
        return emptyResult;
    }

    int arrayLength = strs.length;
    if (arrayLength == 0) {
        return emptyResult;
    }
    if (arrayLength == 1) {
        return strs[0] == null ? emptyResult : strs[0];
    }

    // 获取字符串数组中最短的字符串的长度
    int minStrLength = Integer.MAX_VALUE;
    for (int i = 0; i < arrayLength; i++) {
        if (strs[i] == null) {
            return emptyResult;
        }
        if (strs[i].length() < minStrLength) {
            minStrLength = strs[i].length();
        }
    }

    StringBuilder sb = new StringBuilder();
    // 从头开始比较每个字符串的每一个字符
    for (int i = 0; i < minStrLength; i++) {
        for (int j = 0; j < arrayLength - 1; j++) {
            if (strs[j].charAt(i) != strs[j + 1].charAt(i)) {
                return sb.toString();
            }
        }
        sb.append(strs[0].charAt(i));
    }

    return sb.toString();
}

/**
 * 解法2：
 *      思路：
 *          先遍历字符串数组，获取到字符串数组中最短的字符串的长度 minStrLength，
 *          初始设最最长公共前缀为数组的第一个字符串，然后遍历字符串数组，
 *          每一轮都逐个字符比较最短公共前缀和当前字符串，比较完后更新最长公共前缀，
 *          遍历数组后，最后更新的最长公共前缀就是结果
 *      时间复杂度：O(n * m)，n为字符串数组长度，m为最短字符串的长度
 *      空间复杂度：O(1)
 * @param strs
 * @return
 */
public static String solution2(String[] strs) {
    String emptyResult = "";
    if (strs == null) {
        return emptyResult;
    }

    int arrayLength = strs.length;
    if (arrayLength == 0) {
        return emptyResult;
    }
    if (arrayLength == 1) {
        return strs[0] == null ? emptyResult : strs[0];
    }

    // 获取字符串数组中最短的字符串的长度
    int minStrLength = Integer.MAX_VALUE;
    for (int i = 0; i < arrayLength; i++) {
        if (strs[i] == null) {
            return emptyResult;
        }
        if (strs[i].length() < minStrLength) {
            minStrLength = strs[i].length();
        }
    }

    String result = "";
    for (int i = 0; i < arrayLength; i++) {
        if (i == 0) {
            result = strs[0];
            continue;
        }
        if (result.length() > strs[i].length()) {
            result = strs[i];
        }
        StringBuilder sb = new StringBuilder();
        // 逐个字符比较result和当前字符串
        for (int j = 0; j < minStrLength; j++) {
            if (result.charAt(j) == strs[i].charAt(j)) {
                sb.append(strs[i].charAt(j));
            } else {
                // 如果字符不一样，更新result
                result = sb.toString();
                break;
            }
        }
        // 更新result
        result = sb.toString();
    }

    return result;
}
```