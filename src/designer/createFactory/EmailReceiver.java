/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package designer.createFactory;

/**
 * 邮件接受者
 * Date: 2019-03-27
 *
 * @author zhaqianming
 */
public class EmailReceiver implements  Receiver{
    @Override
    public void receiver() {
        System.out.println("This is EmailReceiver receiver");
    }
}
