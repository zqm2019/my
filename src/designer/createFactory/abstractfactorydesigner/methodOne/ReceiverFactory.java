/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package designer.createFactory.abstractfactorydesigner.methodOne;

import designer.createFactory.EmailReceiver;
import designer.createFactory.EmailSender;
import designer.createFactory.MessageReceiver;
import designer.createFactory.MessageSender;
import designer.createFactory.Receiver;
import designer.createFactory.Sender;

/**
 * 接受者工厂 --方法一
 * Date: 2019-03-27
 *
 * @author zhaqianming
 */
public class ReceiverFactory extends AbstractFactory {
    @Override
    public Sender getSender(String sender) {
        if (sender.equalsIgnoreCase("email")){
            return new EmailSender();
        }else if (sender.equalsIgnoreCase("message")){
            return new MessageSender();
        }else {
            return null;
        }
    }

    @Override
    public Receiver getReceiver(String receiver) {
        if (receiver.equalsIgnoreCase("email")){
            return new EmailReceiver();
        }else if (receiver.equalsIgnoreCase("message")){
            return new MessageReceiver();
        }else {
            return null;
        }
    }
}
