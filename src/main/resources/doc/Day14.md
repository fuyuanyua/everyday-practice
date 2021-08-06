## Day14

##### 1.思考题

MySQL分表分区分库的场景是什么？一般会如何去做？

1. 分表：

   - 定义：把一张表按照一定的规则分解成多张实体表。
   - 场景：当单张表数据量太大，造成索引也很大，查询效率降低，影响了正常的增删改查，那么就可以考虑将单张数据量庞大的表，按照一定的业务规则拆分成多张数据量较小的实体表。
   - 水平分表：例如按照id来划分，1-100000存到第一张表，100001到200000存到第二张表，以此类推。
   - 垂直分表：例如某张表字段特别多或某些字段数据特别大，则将这些字段分离出来，单独存在另一张表里。

2. 分库：

   - 定义：把一个数据库拆成多个数据库，分别部署在不同的数据库服务器。

   - 场景：通常情况下，单台数据库服务器的性能是有瓶颈的，例如磁盘空间不足，内存不足，io出现瓶颈等，那么分库之后，将请求转发到不同的数据库服务器，来突破这些瓶颈。

   - 水平分库：通常是伴随着水平分表，例如按照id来划分，1-100000存在a库的user1表，100001到200000存到b库的user2表。

   - 垂直分库：按照业务维度来划分，例如订单相关的表存到a库，用户相关的表存到b库。

   - 解决方法：市场上有很多公司开源的框架：例如cobar、TDDL等

     https://github.com/alibaba/cobar

3. 分区：

   - 定义：指将同一表中不同行的记录分配到不同的物理文件中，几个分区就有几个.idb文件。

   - 场景：与水平分表类似。

   - 解决方案：目前MySQL支持一下几种类型的分区，RANGE分区，LIST分区，HASH分区，KEY分区。如果表存在主键或者唯一索引时，分区列必须是唯一索引的一个组成部分。以下是分区语句供参考：

     ```sql
     create table `order` (
       `id` int not null auto_increment,
       `partition_key` int not null
     ) partition by range (partition_key) ( 
       partition p0 values less than (100),
       partition p1 values less than (200),
       partition p2 values less than (300),
       partition p3 values less than (400),
       partition p4 values less than maxvalue
     );
     ```

##### 2.算法题

移除未排序链表的重复节点，保留最开始出现的节点

```java
/**
 * 思路：
 *      借助一个HashSet来保存链表中不重复的数字，
 *      从头开始遍历链表，取得当前节点的当前值：
 *          * 若set中不存在这个值，则把这个值存进set，然后继续向后遍历；
 *          * 否则，删除当前节点（删除当前节点的方法：将当前节点的前驱指向当前节点的后继），然后继续向后遍历。
 *      当遍历完链表后，返回头节点，就是目标结果。
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * @param head
 * @return
 */
public static ListNode solution1(ListNode head) {
    if (head == null) {
        return null;
    }

    // 用于保存不重复数字
    Set<Integer> set = new HashSet<>();

    // new一个虚拟节点当作头节点的前驱
    ListNode fake = new ListNode(-1);
    fake.next = head;
    // current指针指向当前节点，用于遍历链表，初始指向头节点
    ListNode current = head;
    // pre指针指向当前节点的前驱，初始指向头节点的前驱
    ListNode pre = fake;
    // 当前遍历到的节点的值
    int currentValue = current.value;

    while (current != null) {
        currentValue = current.value;
        // 如果set中不包含当前值，则current指针和pre指针都向后走一步
        if (!set.contains(currentValue)) {
            set.add(currentValue);
            pre = current;
            current = current.next;
        } else { // 否则，删除当前节点（pre指针指向当前节点的后继，即删除了当前节点），然后当前指针向后走一步
            pre.next = current.next;
            current = current.next;
        }
    }

    return head;
}
```