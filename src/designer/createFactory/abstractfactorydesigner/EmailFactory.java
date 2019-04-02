
package designer.createFactory.abstractfactorydesigner;

import designer.createFactory.EmailReceiver;
import designer.createFactory.EmailSender;
import designer.createFactory.Receiver;
import designer.createFactory.Sender;

/**
 * 邮件发送者工厂  --可以无限扩展具体工厂类
 * Date: 2019-03-27
 *
 * @author zhaqianming
 */
public class EmailFactory extends AbstractFactory2 {
    @Override
    public Sender getSender() {
        return new EmailSender();
    }

    @Override
    public Receiver getReceiver() {
        return new EmailReceiver();
    }
}
