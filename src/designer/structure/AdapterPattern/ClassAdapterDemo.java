
package designer.structure.AdapterPattern;

/**
 * 类的适配器模式，首先由一个原类，通过创建一个接口，包含原类中的方法，以及新的方法
 * 新建一个适配器类,继承原来，实现接口 该类的实例对象既有原类功能，还有新的功能
 * Date: 2019-04-16
 *
 * @author zhaqianming
 */
public class ClassAdapterDemo extends Source implements TargetInterface {
    @Override
    public void newMethod() {
        System.out.println("This is new method");
    }

    public static void main(String[] args) {
        ClassAdapterDemo classAdapterDemo = new ClassAdapterDemo();
        classAdapterDemo.newMethod();
        classAdapterDemo.method();
    }
}
