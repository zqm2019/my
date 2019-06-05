/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package designer;

import java.math.BigDecimal;

/**
 * TODO: description
 * Date: 2019-06-05
 *
 * @author zhaqianming
 */
public class BigDecimalDemo {
    BigDecimal b = new BigDecimal(12.10);
    //BigDecimal 转换成 string数据类型
    String cc = b.toString();
    //BigDecimal 转换成 int数据类型
    int c2 = b.intValue();
    //BigDecimal 转换成 double数据类型
    double c = b.doubleValue();

 // b.stripTrailingZeros();//去掉末尾0
 // b.stripTrailingZeros().toPlainString();//避免输出科学计数法

    //操作运算加减乘除
    BigDecimal num1 = new BigDecimal("100");
    BigDecimal num2 = new BigDecimal("50");
    //加法
    BigDecimal result1 = num1.add(num2);
    //减法
    BigDecimal result2 = num1.subtract(num2);
    //乘法
    BigDecimal result3 = num1.multiply(num2);
    //除法
    BigDecimal result4 = num1.divide(num2).setScale(1);

    public BigDecimal getNum1() {
        return num1;
    }

    //    方法用于格式化小数点
//    setScale(1)//表示保留一位小数，默认用四舍五入方式
//
//    setScale(1,BigDecimal.ROUND_DOWN)//直接删除多余的小数位 1.11变1.1
//
//    setScale(1,BigDecimal.ROUND_UP)//进位处理，1.11变成1.2
//
//    setScale(1,BigDecimal.ROUND_HALF_UP)//四舍五入，5进1
//
//    setScale(1,BigDecimal.ROUND_HALF_DOWN)//五舍六入，6进1五舍掉 1.15变1.1


//    compareTo比较大小（两边不可为空）
//            num1.compareTo(num2);大于时返回1，小于返回-1，等于返回0
//

}
