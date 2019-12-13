
//package utils;
//
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.ParsePosition;
//import java.text.SimpleDateFormat;
//import java.time.Instant;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.time.ZoneId;
//import java.time.ZonedDateTime;
//import java.time.temporal.ChronoUnit;
//import java.util.Calendar;
//import java.util.Date;
//
//import org.apache.commons.lang.StringUtils;
//
//import com.tuniu.mob.dist.common.constant.CommonConstant;
//import com.tuniu.mob.dist.common.utils.DateUtil;
//
///**
// * 日期相关工具类
// * Date: 2019-01-08
// *
// * @author zhaqianming
// */
//public class DateUtils {
//
//    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
//
//    /**
//     * 获取第n天凌晨00点00分00秒的时间
//     *
//     * @return
//     */
//    public static Date getNextDayZeroHour(Date date, int amount) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        calendar.set(Calendar.HOUR_OF_DAY, 0);
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.SECOND, 0);
//        calendar.add(Calendar.DATE, amount);
//        return calendar.getTime();
//    }
//
//    public static Date getOneDayEndTime(Date date, int amount) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        calendar.set(Calendar.HOUR_OF_DAY, 23);
//        calendar.set(Calendar.MINUTE, 59);
//        calendar.set(Calendar.SECOND, 59);
//        calendar.add(Calendar.DATE, amount);
//        return calendar.getTime();
//    }
//
//    /**
//     * 判断开始，结束时间是否大于三年，返回小于等于三年的时间
//     *
//     * @param startTime
//     * @return
//     */
//    public static String eligibleTime(String startTime) {
//        if (StringUtils.isNotBlank(startTime)) {
//            //获取当前时间三年前的时间
//            LocalDateTime complainTime = LocalDateTime.now().minus(3, ChronoUnit.YEARS);
//            //判断参数时间是否在当前时间三年内
//            if (DateUtil.toDate(complainTime).getTime() > DateUtil.parseDateTime(startTime).getTime()) {
//                return complainTime.format(CommonConstant.DATE_TIME_FORMATTER);
//            } else {
//                return startTime;
//            }
//        }
//        return null;
//    }
//
//    /**
//     * 获取某一周的星期几
//     *
//     * @param week  week = 0 时为本周，-1 是上周，1 是下一周，2 是下下周，以此类推
//     * @param day  day 为星期几，周一传 Calendar.MONDAY，以此类推
//     * @return
//     */
//    public static Date getDayOfWeek(int week, int day) {
//        Calendar cal = Calendar.getInstance();
//        cal.add(Calendar.DATE, week*7);
//        cal.set(Calendar.DAY_OF_WEEK, day);
//        LocalDate localDate = LocalDateTime.ofInstant(cal.getTime().toInstant(), ZoneId.systemDefault()).toLocalDate();
//        //返回所需日期的开始时间
//        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
////        localDate.atTime(LocalTime.MIN);
//    }
//
//    //获取当天的开始时间
//    public static String getDayBegin() {
//        LocalDate localDate = LocalDate.now();
//        return getDayStartTime(localDate);
//    }
//
//    //获取当天的开始时间(date)
//    public static Date getDateDayBegin() throws ParseException {
//        return stringToDate(getDayBegin());
//    }
//
//    //获取当天的结束时间
//    public static String getDayEnd() {
//        LocalDate localDate = LocalDate.now();
//        return getDayEndTime(localDate);
//    }
//
//    //获取当天的结束时间(date)
//    public static Date getDateDayend()  throws ParseException {
//        return stringToDate(getDayEnd());
//    }
//
//    //获取本周的开始时间
//    public static String getBeginDayOfWeek() {
//        Date date = new Date();
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(date);
//        int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
//        if (dayofweek == 1) {
//            dayofweek += 7;
//        }
//        cal.add(Calendar.DATE, 2 - dayofweek);
//        return getDayStartTime(DateUtil.toLocalDateTime(cal.getTime()).toLocalDate());
//    }
//
//    //获取指定时间前时间的开始时间（包含当天）
//    public static String getBeginDayBefore(int dayBefore) {
//        LocalDateTime now = LocalDateTime.now();
//        LocalDateTime localDateTime = now.minusDays(dayBefore - 1);
//        return getDayStartTime(localDateTime.toLocalDate());
//    }
//
//    //获取本周的结束时间
//    public static String getEndDayOfWeek() {
//        String beginDayOfWeek = getBeginDayOfWeek();
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(DateUtil.parseDateTime(beginDayOfWeek));
//        cal.add(Calendar.DAY_OF_WEEK, 6);
//        return getDayEndTime(DateUtil.toLocalDateTime(cal.getTime()).toLocalDate());
//    }
//
//    //获取本月的开始时间
//    public static String getBeginDayOfMonth() {
//        LocalDate localDate = LocalDate.now();
//        int year = localDate.getYear();
//        int monthValue = localDate.getMonthValue();
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(year, monthValue - 1, 1);
//        return getDayStartTime(DateUtil.toLocalDateTime(calendar.getTime()).toLocalDate());
//    }
//
//    //获取本月的结束时间
//    public static String getEndDayOfMonth() {
//        LocalDate localDate = LocalDate.now();
//        int year = localDate.getYear();
//        int monthValue = localDate.getMonthValue();
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(year, monthValue - 1, 1);
//        int day = calendar.getActualMaximum(5);
//        calendar.set(year, monthValue - 1, day);
//        return getDayEndTime(DateUtil.toLocalDateTime(calendar.getTime()).toLocalDate());
//    }
//
//    //获取指定日期本月的开始时间
//    public static String getBeginDayOfMonth(Date date) {
//        LocalDate localDate = DateUtil.toLocalDate(date);
//        int year = localDate.getYear();
//        int monthValue = localDate.getMonthValue();
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(year, monthValue - 1, 1);
//        return getDayStartTime(DateUtil.toLocalDateTime(calendar.getTime()).toLocalDate());
//    }
//
//    //获取指定日期本月的结束时间
//    public static String getEndDayOfMonth(Date date) {
//        LocalDate localDate = DateUtil.toLocalDate(date);
//        int year = localDate.getYear();
//        int monthValue = localDate.getMonthValue();
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(year, monthValue - 1, 1);
//        int day = calendar.getActualMaximum(5);
//        calendar.set(year, monthValue - 1, day);
//        return getDayEndTime(DateUtil.toLocalDateTime(calendar.getTime()).toLocalDate());
//    }
//
//    //获取指定月份开始时间
//    public static Date getMonthStart(String dateStr) {
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
//        ParsePosition pos = new ParsePosition(0);
//        return formatter.parse(dateStr, pos);
//    }
//
//    //获取指定月份上一个月开始时间
//    public static Date getLastMonthStart(String dateStr) {
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
//        ParsePosition pos = new ParsePosition(0);
//        int i = Integer.parseInt(dateStr.substring(dateStr.length() - 2));
//        LocalDate now = LocalDate.now();
//        String month;
//        String result;
//        if (i == 1) {
//            month = "12";
//            result = (now.getYear()) - 1 + "-" + month;
//        } else {
//            month = i < 10 ? "0" + --i : "" + --i;
//            result = now.getYear() + "-" + month;
//        }
//        return formatter.parse(result, pos);
//    }
//
//
//    //获取某个日期的开始时间
//    public static String getDayStartTime(LocalDate localDate) {
//        return localDate.atTime(LocalTime.MIN).format(CommonConstant.DATE_TIME_FORMATTER);
//    }
//
//    //获取某个日期的结束时间
//    public static String getDayEndTime(LocalDate localDate) {
//        return localDate.atTime(LocalTime.MAX).format(CommonConstant.DATE_TIME_FORMATTER);
//    }
//
//    //获取当前时间 yyyy-MM-dd HH:mm:ss
//    public static String getCurrentDateTime(LocalDateTime localDateTime) {
//        if (localDateTime == null) {
//            localDateTime = localDateTime.now();
//        }
//        return localDateTime.format(CommonConstant.DATE_TIME_FORMATTER);
//    }
//
//    //date 转 localDateTime
//    public static LocalDateTime date2LocalDate(Date date) {
//        Instant instant = date.toInstant();
//        ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
//        return zdt.toLocalDateTime();
//    }
//
//    //String 转 date
//    public static Date stringToDate(String date) throws ParseException {
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        return dateFormat.parse(date);
//    }
//
//    public static String dateToString(Date date) {
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        return dateFormat.format(date);
//    }
//
//}
