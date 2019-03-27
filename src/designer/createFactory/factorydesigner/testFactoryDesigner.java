/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package designer.createFactory.factorydesigner;

import designer.createFactory.Sender;

/**
 * 工厂模式测试
 * Date: 2019-03-27
 *
 * @author zhaqianming
 */
public class testFactoryDesigner {
    public static void main(String[] args) {
        /**
         * 每个工厂各司其职互不干扰，如果有新的工具要生产，只需要在扩展一个新的工厂类，
         * 无需修改已用的工厂类
         */
        Sender sender1 = new EmailFactory();
        sender1.send();
        Sender send2 = new MessageFactory();
        send2.send();
    }
}
