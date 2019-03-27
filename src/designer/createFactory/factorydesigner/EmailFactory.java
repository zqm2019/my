/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package designer.createFactory.factorydesigner;

import designer.createFactory.Sender;

/**
 * 每个工厂只生产一种工具--单一原则
 * Date: 2019-03-27
 *
 * @author zhaqianming
 */
public class EmailFactory implements Sender {
    @Override
    public void send() {
        System.out.println("This is emailFactory send");
    }
}
