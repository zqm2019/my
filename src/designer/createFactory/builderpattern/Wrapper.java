/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package designer.createFactory.builderpattern;

/**
 * 创建packing实现类--Wrapper
 * Date: 2019-03-28
 *
 * @author zhaqianming
 */
public class Wrapper implements Packing{
    @Override
    public String pack() {
        return "Wrapper";
    }
}
