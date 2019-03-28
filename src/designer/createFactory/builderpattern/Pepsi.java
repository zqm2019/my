/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package designer.createFactory.builderpattern;

/**
 * 创建ColdDrink 实现类--Pepsi
 * Date: 2019-03-28
 *
 * @author zhaqianming
 */
public class Pepsi extends ColdDrink {
    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "Pepsi";
    }
}
