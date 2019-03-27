/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package designer.createFactory.simplefactory;

import designer.createFactory.Sender;

/**
 * 简单工厂测试
 * Date: 2019-03-27
 *
 * @author zhaqianming
 */
public class testSimpleFactory {

    public static void main(String[] args) {
        //针对方案一
        Sender sender1= SimpleFactory.getFactory("email");
        sender1.send();
        Sender sender2= SimpleFactory.getFactory("message");
        sender2.send();

        //方案二
        SimpleFactory simpleFactory = new SimpleFactory();
        Sender sender3 = simpleFactory.getEmailFactory();
        sender3.send();
        Sender sender4 = SimpleFactory.getMessageFactory();
        sender4.send();
    }

}
