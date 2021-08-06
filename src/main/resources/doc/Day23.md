## Day23

##### 1.思考题

JVM一次完整的GC流程是怎样的？对象如何晋升到老年代？

1. JVM堆内存结构

   堆内存分为：

   - 新生代：大约占堆内存1/3，新生代又可分为：
     - Eden区：大约占新生代的8/10
     - S1区：大约占新生代的1/10，S1区和S2区是相对应的
     - S2区：大约占新生代的1/10
   - 老年代：大约占堆内存2/3

2. 一次完整的GC流程

   - 新建的对象一般都在Eden区
   - 当Eden区的内存满了，会触发一次Minor GC，清理Eden区和其中一个S区的对象，如果Minor GC有对象存活，都会移到另一个S区，并且这些存活下来的对象年龄 + 1。每次触发Minor GC后，都会重复以上操作，当S区中的对象年龄超过一定限制后，这些对象就被认为是长期存活的对象，就要转移到老年代。
   - 当老年代内存满了之后，触发Full GC，清理整个堆内存空间的垃圾

3. 对象如何晋升到老年代？

   - 大对象被新建出来的时候就直接进入老年代，如超长的字符串，大数组等
   - 经历过多次Minor GC仍然存活下来的对象，当超过一定阈值，这些对象会被转移到老年代

##### 2.算法题

给定二叉搜索树的根节点root，返回所有在[l, r]之间的节点的值之和，节点值具有唯一性

```java
@Slf4j
public class Day23 {

    public static void main(String[] args) {
        // 构建一颗二叉搜索树
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(15);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(18);
        root.setLeft(node1).setRight(node2);
        node1.setLeft(node3).setRight(node4);
        node2.setRight(node5);

        int l = 7;
        int r = 15;
        log.info("input = {}, {}, {}", root, l, r);
        int result = Day23.solution1(root, l, r);
        log.info("output = {}", result);
    }

    /**
     * 思路：
     *      二叉搜索树的特性：二叉搜索树的任意节点，其左子树节点的值都小于它的值，其右子树节点的值都大于它的值
     *      利用这个特性：
     *          如果遇到一个节点的值小于l，则这个节点的左子树所有节点的值都小于l，直接舍弃这个节点的左子树；
     *          如果遇到一个节点的值小于l大于r，则这个节点的右子树所有节点的值都大于r，直接舍弃这个节点的右子树；
     *      先序遍历这棵树，如果遇到以上情况，则做出相应舍弃，否则把当前遍历到的节点的值加入结果
     * 时间复杂度：最坏情况O(n)，也就是这棵树所有节点的值都满足题目要求，则要遍历所有节点
     * 空间复杂度：O(logn)，n为节点数，logn为树的高度
     * @param root
     * @param l
     * @param r
     * @return
     */
    public static int solution1(TreeNode root, int l, int r) {
        // 递归终止条件
        if (root == null) {
            return 0;
        }

        if (root.value < l) {
            return solution1(root.right, l, r);
        }

        if (root.value > r) {
            return solution1(root.left, l ,r);
        }

        log.info("node's value is {}", root.value);
        return root.value + solution1(root.left, l, r) + solution1(root.right, l, r);
    }
}
```



 	

