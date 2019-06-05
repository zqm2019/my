import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试时间类的使用 ZoneId 时区
 * Date: 2019-03-20
 *
 * @author zqm
 */
public class Demo {
 static  String stringD= "2019-05-05";
    public static void main1(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDate localDate1 = LocalDate.of(2019, 04, 01);
        LocalDate localDate2 = LocalDate.of(2019, 04, 11);
        LocalDate localDate = LocalDate.now();
       // LocalTime localTime = LocalTime.now();
        String a = LocalDateTime.now().format(dateTimeFormatter);
        System.out.println(a);
        System.out.println(localDate);
        for (int i=0;i<10;i++){
            if ((LocalDateTime.now().format(dateTimeFormatter1).compareTo(stringD))>=0){
                System.out.println("zhende ");
                stringD =LocalDate.now().plusDays(1).format(dateTimeFormatter1);
            }
        }

        System.out.println(localDate.plusDays(1).format(dateTimeFormatter1));
        System.out.println(LocalDateTime.now().with(DayOfWeek.MONDAY).format(dateTimeFormatter));
        //当前日期往后推一年
        System.out.println(localDate.plusYears(1));
        //当前日期往后推半年
        System.out.println(localDate.plusMonths(6));
        //往前推一天
        System.out.println(localDate.plusMonths(1));
        //往后推一个月
        System.out.println(localDate.plusMonths(-1));
        //起始时间
        System.out.println(localDate.atStartOfDay().format(dateTimeFormatter));
        //日期指定任意时间
        System.out.println(localDate.atTime(5,1).format(dateTimeFormatter));
        System.out.println(localDate.atTime(23,59,59).format(dateTimeFormatter));
        //月有多少天
        System.out.println(localDate.lengthOfMonth());
        Date date = LocalDateToUdate(localDate);
        //获取月的第几天
        System.out.println(localDate.getDayOfMonth());
        //一年的哪一天
        System.out.println(localDate.getDayOfYear());
        //获取月fen
        System.out.println(localDate.getMonthValue());
        System.out.println(localDate.isAfter(localDate1));
        System.out.println(localDate.isBefore(localDate2));
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        String aaaa = localTime.format(dateTimeFormatter2);
        System.out.println(localTime.format(dateTimeFormatter2));
        Date date1 = LocalDateTimeToUdate(localDateTime);
        System.out.println(date1);
        System.out.println(simpleDateFormat.format(date1));
        Date date2 = LocalTimeToUdate(localDate, localTime);
        System.out.println(date2);

        if (aaaa.compareTo("13:15:00")>0){
            System.out.println(true);
        }

        System.out.println(DateToLocateDate(new Date()));
        System.out.println(localDateTime.format(dateTimeFormatter));


    }

    /**
     * LocateDateTime 转date
     */
    private static Date LocalDateTimeToUdate(LocalDateTime localDateTime) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * LocateDate  转 date
     */
    private static Date LocalDateToUdate(LocalDate localDate) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * LocateTime  转 date
     */
    private static Date LocalTimeToUdate(LocalDate localDate, LocalTime localTime) {
        ZoneId zone = ZoneId.systemDefault();

        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        Instant instant = localDateTime.atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * Date  转LocalDate
     */
    private static LocalDate DateToLocateDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
        return localDateTime.toLocalDate();
    }

    /**
     * Date  转LocalDate
     */
    private static LocalTime DateToLocateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
        return localDateTime.toLocalTime();
    }

    /**
     * Date  转LocalDateTime
     */
    private static LocalDateTime DateToLocateDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zoneId);
    }


    /**
     * 获取第n天开始时间，00点00分00秒的时间
     * @param date 指定日期
     * @param amount 表示与指定日期相隔amount天，正数往前推amount天，负数指定日期往后推 0表示与指定日期相同一天
     * @return
     */
    public static String getOneDayStartTime(Date date,int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.DATE, amount);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(calendar.getTime());
    }


    /**
     * 获取一天的结束时间23：59：59
     * @param date
     * @param amount
     * @return
     */
    public static String getOneDayEndTime(Date date,int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.add(Calendar.DATE, amount);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(calendar.getTime());
    }

    public static void main(String[] args) {
        Map<Integer,String> stringMap = new HashMap<>();
        stringMap.put(1,"2");
        System.out.println(stringMap.get(1));
        System.out.println(stringMap.get(null));
    }

}
