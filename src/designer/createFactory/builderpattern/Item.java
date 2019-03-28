/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package designer.createFactory.builderpattern;

/**
 * 创建一个食物选项和食物包装的接口
 * Date: 2019-03-28
 *
 * @author zhaqianming
 */
public interface Item {
    String name();
    Packing packing();
    float price();
}
