/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package designer.createFactory.builderpattern;

/**
 * 创建扩展Buger的实体类--VegBurger
 * Date: 2019-03-28
 *
 * @author zhaqianming
 */
public class VegBurger extends Burger{
    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Veg Burger";
    }
}
