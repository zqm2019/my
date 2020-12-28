/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package designer.structure.bridge;

import java.util.Calendar;
import java.util.Date;

/**
 * 定义一个桥（抽象的）：拥有一个接口的实例，生成get/set方法，对外提供一个获取（实例调用的方法的）方法。
 * Date: 2019-04-18
 *
 * @author zhaqianming
 */
public abstract class Bridge {

    private SourceAble sourceAble;

    public void method(){
        sourceAble.bridge();
    }
    public SourceAble getSourceAble() {
        return sourceAble;
    }

    public void setSourceAble(SourceAble sourceAble) {
        this.sourceAble = sourceAble;
    }

    public static Date getFirstDayDateOfMonth(final Date date) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        final int last = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, last);
        return cal.getTime();

    }

    public static void main(String[] args) {
        Date date = getFirstDayDateOfMonth(new Date());
        System.out.println();
    }
}
