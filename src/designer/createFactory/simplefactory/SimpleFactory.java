/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package designer.createFactory.simplefactory;

import designer.createFactory.EmailSender;
import designer.createFactory.MessageSender;
import designer.createFactory.Sender;

/**
 * 简单工厂（不属于23设计模式之一）单具有一定的价值,缺点：类的创建依赖工厂类（想要扩展程序，必须修改工厂类），违背了闭包原则
 * Date: 2019-03-27
 *
 * @author zhaqianming
 */
public class SimpleFactory {

    //方案一（普通方式）
    protected static Sender getFactory(String type) {
        if (type.equals("email")) {
            return new EmailSender();
        } else if (type.equals("message")) {
            return new MessageSender();
        } else {
            System.out.println("请输入正确的类型");
        }
        return null;
    }

    //方案二（多方法/静态方法）--该方案比一好
    protected Sender getEmailFactory(){
        return new EmailSender();
    }
    protected static Sender getMessageFactory(){
        return new MessageSender();
    }

}
