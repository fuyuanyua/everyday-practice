## Day01

##### 1.思考题

如何进行批量插入？为什么要这样做？

批量插入的方法：

1. 直接for循环调用dao层

   ```java
   for (int i = 0; i < 100; i++) {
     baseMapper.insert(entity);
   }
   ```

   - 优点：简单粗暴
   - 缺点：每一次循环都消耗连接数据库的资源，数据量大

2. MySQL可以在一条语句中批量插入

   此为MySQL的特殊语法，Oracle实测不行

   ```mysql
   insert into table1
   (col1, col2, col3)
   values
   (xx, xx, xx),
   (xx, xx, xx),
   (xx, xx, xx),
   (xx, xx, xx);
   ```

   

3. insert into ...select...

   ```mysql
   insert into pms_brand
   (name)
   select pms_category.name from pms_category;
   ```

   

4. 

