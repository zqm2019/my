
package designer.structure.decoratorAndProxy;

/**
 * 代理模式和装饰模式很像，都是和原类继承同一个接口，
 * 主要区别是，装饰是拥有一个被代理类构造器而代理使用的默认构造器获得一个私有的被装饰的类的实现。
 * Date: 2019-04-17
 *
 * @author zhaqianming
 */
public class ProxyDemo implements Sourceable{

    private Source source;

    public ProxyDemo() {
        this.source = new Source();
    }

    @Override
    public void method() {
        System.out.println("This is ProxyDemo");
        source.method();
    }

    public static void main(String[] args) {
        ProxyDemo proxyDemo = new ProxyDemo();
        proxyDemo.method();
    }
}
