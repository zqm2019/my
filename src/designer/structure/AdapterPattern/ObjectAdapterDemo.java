
package designer.structure.AdapterPattern;

/**
 * 对象适配器模式：首先由一个原类，通过创建一个接口，包含原类中的方法，以及新的方法
 * 另一个类实现接口，实现方法，并私有一个原类对象属性，并构造一个以原类对象为参数的构造器
 * Date: 2019-04-16
 *
 * @author zhaqianming
 */
public class ObjectAdapterDemo implements TargetInterface {
    private Source source;

    public ObjectAdapterDemo(Source source) {
        super();
        this.source = source;
    }

    @Override
    public void method() {
        source.method();
    }

    @Override
    public void newMethod() {
        System.out.println("This is new objectAdapter");
    }

    public static void main(String[] args) {
        Source source = new Source();
        ObjectAdapterDemo objectAdapterDemo = new ObjectAdapterDemo(source);
        objectAdapterDemo.method();
        //objectAdapterDemo.source.method();
        objectAdapterDemo.newMethod();
    }
}
