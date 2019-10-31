
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式
 * Date: 2019-04-11
 *
 * @author zhaqianming
 */
public class RegDemo {

    /**
     * 取content中所有的日期格式为yyyy-MM-dd的日期
     *
     * @param content
     * @return
     */
    private List<String> buildCouponEffectiveDate(String content) {
        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list;

    }

    //分组来取值
    public static void main(String[] args) {
        String a = "18010859408";
        String b = a.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");

        String aa = "AAAAbbbb";
        //去掉前n个字符
        System.out.println(aa.substring(2));
        //截取吗m,n个字符,下标从0开始
        System.out.println(aa.substring(3, 6));
        System.out.println(aa.equalsIgnoreCase("aaaaBBBB"));
        //取第n个字符，从1开始
        System.out.println(aa.charAt(5));
        //匹配第一个并赋值
        System.out.println(aa.replaceFirst("A", "a"));
        //小写
        System.out.println(aa.toLowerCase());
        System.out.println(aa.replace("A", "a"));
        System.out.println(aa.replaceAll("A", "c"));
        System.out.println(b);
        System.out.println(aa.concat("ccc"));

        /**
         * 元祖匹配，匹配成功第一个是所有，第二个是括号内的
         */
        Pattern patter = Pattern.compile("\\+(￥.*?)×");
        String content = "首付￥521.00+￥285.89×24期";
        Matcher matcher = patter.matcher(content);
        if (matcher.find()) {//第一次为true
            System.out.println(1);
            System.out.println(matcher.group(0)); //+￥285.89×

            System.out.println(matcher.group(1)); //￥285.89
        }
        System.out.println(matcher.find()); //第二次为false


    }
}
