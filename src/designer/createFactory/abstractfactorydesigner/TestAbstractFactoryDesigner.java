
package designer.createFactory.abstractfactorydesigner;

/**
 * 抽象工厂设计模式测试类
 * Date: 2019-03-27
 *
 * @author zhaqianming
 */
public class TestAbstractFactoryDesigner {
    public static void main(String[] args) {
        AbstractFactory2 abstractFactory2 = new MessageFactory();
        abstractFactory2.getReceiver().receiver();
        abstractFactory2.getSender().send();


        AbstractFactory2 abstractFactory = new EmailFactory();
        abstractFactory.getReceiver().receiver();
        abstractFactory.getSender().send();


    }

}
