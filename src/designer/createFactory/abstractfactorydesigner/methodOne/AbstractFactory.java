/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package designer.createFactory.abstractfactorydesigner.methodOne;

import designer.createFactory.Receiver;
import designer.createFactory.Sender;

/**
 * 抽象工厂类 -- 不建议使用，扩展性差，需修改类
 * Date: 2019-03-27
 *
 * @author zhaqianming
 */
public abstract class AbstractFactory {
    public abstract Sender getSender(String send);

    public abstract Receiver getReceiver(String receiver);
}
