## Day15

##### 1.思考题

单例、工厂、观察者模式的实现与使用场景

1. 单例模式

   单例模式可分为：

   - 饿汉模式：类加载时就实例化对象
   - 懒汉模式：第一次调用时才实例化对象

   实现：

   - 类的构造方法必须是私有的，保证在外部无法实例化对象
   - 通过`private static`变量持有唯一实例，保证对象全局唯一
   - 通过`public static`方法返回此唯一实例，使外部调用方能获取到实例

   以饿汉式的单例模式为例：

   ```java
   public class SingletonDemo {
       private static SingletonDemo singletonDemo = new SingletonDemo();
     
       private SingletonDemo() {}
     
       public static SingletonDemo getInstance() {
           return singletonDemo;
       }
   }
   ```

   使用场景：

   - 创建对象时耗时过多或者耗资源过多，但又经常用到的类
   - 必须保证全局只能有一个实例对象的类
   - Spring的bean默认为单例模式

2. 工厂模式

   工厂模式可分为：

   - 简单工厂模式：工厂类根据不同传参来创建不同的对象。
   - 工厂方法模式：定义一个抽象工厂接口，定义抽象方法，由具体的工厂类去实现此抽象工厂接口，重写抽象方法，以此来生产具体的商品。
   - 抽象工厂模式：与工厂方法模式相比，工厂方法模式接口只定义了一种方法，只能生产一种类型的产品，而抽象工厂模式，接口定义了多种方法，可以生产不同类型的商品。

   实现：

   以工厂方法模式为例：

   ```java
   public interface AbstractFactory {
       Phone makePhone();
   }
   ```

   ```java
   public class XiaoMiFactory implements AbstractFactory{
       @Override
       public Phone makePhone() {
           return new MiPhone();
       }
   }
   ```

   使用场景：

   - 用于new一个对象，但是我们希望隐藏new这个对象的具体且复杂的细节，而用工厂提供的方法来代替我们手动new对象。

3. 观察者模式

   观察者模式对应两个角色：

   - 主题角色
   - 观察者角色

   一个主题角色可以有任意多个观察者，当主题角色发生改变时，会给所有对应的观察者发出通知；观察者有一个方法用来接收主题角色发出的通知，然后执行业务逻辑。

   实现：

   java.util包下提供了现成的类与接口来实现观察者模式，Observable类对应主题角色，其属性Vector<Observer> obs用来绑定其对应的所有观察者，通常我们继承这个类，写一个方法，调用notifyObservers方法，即可通知所有观察者；Observer接口对应观察者角色，我们需要实现此接口然后重写update方法，以此来接收主题角色发出的通知。

   使用场景：

   - 通常用在订阅功能的实现，例如微信公众号的订阅，当此公众号（主题角色）更新了新的内容，所有订阅了此公众号的用户（观察者角色）都会接收到更新通知。

##### 2.算法题

给定一个整数，将其转化成七进制，以字符串形式输出

```java
/**
 * 思路：
 *      将一个十进制数n转化成七进制数的方法：
 *      1.将n除以7，得到商和余数
 *      2.再将商除以7，得到商和余数
 *      3.重复以上操作，直到商等于0
 *      4.将得到的余数倒序输出，得到的就是结果
 *      所以额外借助一个stack，用于存储余数并倒序输出
 * 时间复杂度：O(logn)，底数为7
 * 空间复杂度：O(logn)，底数为7
 * @param n
 * @return
 */
public static String solution1(int n) {
    if (n == 0) {
        return String.valueOf(n);
    }

    // 负数标识
    boolean flag = false;
    if (n < 0) {
        flag = true;
        n = -n;
    }

    Stack<Integer> stack = new Stack<>();
    while (n > 0) {
        int item = n % 7;
        stack.push(item);
        n = n / 7;
    }

    StringBuilder stringBuilder = new StringBuilder();
    if (flag) {
        stringBuilder.append("-");
    }
    int size = stack.size();
    for (int i = 0; i < size; i++) {
        stringBuilder.append(stack.pop());
    }

    return stringBuilder.toString();
}
```