/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package designer.createFactory;

/**
 *
 * Date: 2019-03-27
 *
 * @author zhaqianming
 */
public class MessageReceiver implements Receiver {
    @Override
    public void receiver() {
        System.out.println("This is MessageReceiver receive");
    }
}
