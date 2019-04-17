
package designer.structure.AdapterPattern;

/**
 * 面向借口哦变成，如果要实现接口就必须实现接口所有的方法；
 * 而有些情况，某些类只想实现接口中一些自己想要的方法
 * 因此，我们新建一个抽象类，来实现接口所有的方法，而某些类只要继承接口覆盖自己想要的方法即可
 * Date: 2019-04-17
 *
 * @author zhaqianming
 */
public class InterfaceAdapterDemo extends AbstractClas {

    public void method() {
        System.out.println("This is InterfaceAdapter");
    }

    public static void main(String[] args) {
        InterfaceAdapterDemo demo = new InterfaceAdapterDemo();
        demo.method();
        demo.newMethod();
    }
}
