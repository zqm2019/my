/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package designer.createFactory;

/**
 * 消息发送者
 * Date: 2019-03-27
 *
 * @author zhaqianming
 */
public class MessageSender implements Sender {
    @Override
    public void send() {
        System.out.println("This is message send");
    }
}
