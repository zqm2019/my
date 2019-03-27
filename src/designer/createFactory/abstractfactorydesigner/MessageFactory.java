/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package designer.createFactory.abstractfactorydesigner;

import designer.createFactory.MessageReceiver;
import designer.createFactory.MessageSender;
import designer.createFactory.Receiver;
import designer.createFactory.Sender;

/**
 * 消息发送者工厂  --可以无限扩展具体工厂类
 * Date: 2019-03-27
 *
 * @author zhaqianming
 */
public class MessageFactory extends AbstractFactory2 {
    @Override
    public Sender getSender() {
        return new MessageSender();
    }

    @Override
    public Receiver getReceiver() {
        return new MessageReceiver();
    }
}
