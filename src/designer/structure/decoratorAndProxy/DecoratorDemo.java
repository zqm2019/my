
package designer.structure.decoratorAndProxy;

/**
 * m目标装饰类(targat)与被装饰类(Source)实现同一个接口，并拥有的被装饰类的一个实例。
 * 且有一个以被装饰类为参数的构造器
 * Date: 2019-04-17
 *
 * @author zhaqianming
 */
public class DecoratorDemo implements Sourceable{

    private Source source;

    public DecoratorDemo(Source source) {
        this.source = source;
    }

    @Override
    public void method() {
        System.out.println("动态添加功能");
        source.method();
    }

    public static void main(String[] args) {
        Source source =new Source();
        DecoratorDemo decoratorDemo = new DecoratorDemo(source);
        decoratorDemo.method();

    }
}
