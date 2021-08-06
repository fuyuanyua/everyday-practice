## Day17

##### 1.思考题

Java反射机制的原理和好处

1. 原理

   在程序运行时，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意一个方法和属性。这种动态的获取信息以及动态调用对象的方法的功能称为java 的反射机制。Java文件在编译后会生成一个class文件，反射通过字节码文件得到类中的方法和属性等。

2. 好处

   - 在运行时动态创建对象，十分灵活（相比较new一个对象，是在编译的时候就已经确定好要创建的对象了）
   - 可以获取到一个类的所有的属性、方法
   - 可以调用一个对象的任意方法，访问和修改任意属性

3. 示例

   ```java
   /**
    * 以下展示使用反射新建一个Car对象，并调用setBrand方法和getBrand方法
    * @param args
    * @throws ClassNotFoundException
    * @throws NoSuchMethodException
    * @throws IllegalAccessException
    * @throws InvocationTargetException
    * @throws InstantiationException
    */
   public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
       Class<?> aClass = Class.forName("peixun.test.lhb.day17.Car");
       Method setBrand = aClass.getMethod("setBrand", String.class);
       Constructor<?> constructor = aClass.getConstructor();
       Object car = constructor.newInstance();
       setBrand.invoke(car, "BMW");
       Method getBrand = aClass.getMethod("getBrand");
       Object brand = getBrand.invoke(car);
       System.out.println("car's brand is " + brand);
   }
   ```

##### 2.算法题

按YYYY-MM-DD格式给一个日期字符串，返回该日期是当前的第几天

```java
public static int solution1(String date) throws Exception {
    if (StringUtils.isEmpty(date)) {
        throw new Exception("日期不能为空");
    }

    String[] split = date.split("-");
    if (split.length != 3) {
        throw new Exception("日期格式错误");
    }

    LocalDate localDate = LocalDate.of(Integer.valueOf(split[0]), Integer.valueOf(split[1]), Integer.valueOf(split[2]));
    int dayOfYear = localDate.getDayOfYear();
    return dayOfYear;
}
```

