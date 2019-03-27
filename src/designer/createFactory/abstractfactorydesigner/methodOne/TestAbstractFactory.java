/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package designer.createFactory.abstractfactorydesigner.methodOne;

import designer.createFactory.abstractfactorydesigner.AbstractFactory2;
import designer.createFactory.abstractfactorydesigner.EmailFactory;
import designer.createFactory.abstractfactorydesigner.MessageFactory;

/**
 * 抽象工厂设计模式测试类
 * Date: 2019-03-27
 *
 * @author zhaqianming
 */
public class TestAbstractFactory {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = new SenderFactory();
        abstractFactory.getReceiver("email").receiver();
        abstractFactory.getSender("email").send();



    }

}
