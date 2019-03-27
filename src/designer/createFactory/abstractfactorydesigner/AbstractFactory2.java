/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package designer.createFactory.abstractfactorydesigner;

import designer.createFactory.Receiver;
import designer.createFactory.Sender;

/**
 * 抽象工厂类2 --每个具体工厂创造自己的多个产品
 * Date: 2019-03-27
 *
 * @author zhaqianming
 */
public abstract class AbstractFactory2 {
    public abstract Sender getSender();

    public abstract Receiver getReceiver();
}
