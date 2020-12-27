/*
 * Amendment History:
 * 
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * 2020/12/28                 anyant           Create the class
 * https://blog.csdn.net/tingfengqianqu
*/



package com.jimi.java8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

/**
 * @author anyant
 * @version 1.0
 * @ProjectName demo
 * @Description
 * @Date 2020/12/28 00:03
 */
public class TimeApi {
    public static void main(String[] args) {
        //Java 8 包含了全新的时间日期API，这些功能都放在了java.time包下。新的时间日 期API是基于Joda-Time库开发的，但是也不尽相同。下面的例子就涵盖了大多数新 的API的重要部分。

        //1.Clock 时钟
        // Clock提供了对当前时间和日期的访问功能。Clock是对当前时区敏感的，并可用于 替代System.currentTimeMillis()方法来获取当前的毫秒时间。当前时间线上的时刻 可以用Instance类来表示。Instance也能够用于创建原先的java.util.Date对象。
        //默认时区 Asia/Shanghai
        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock);
        //现在距离1970年1月1日的毫秒时间
        long millis = clock.millis();
        System.out.println(millis);
        Instant instant = clock.instant();
        //年月日
        Date from = Date.from(instant);
        System.out.println(from);
        //2.Timezones 时区
        //时区类可以用一个ZoneId来表示。时区类的对象可以通过静态工厂方法方便地获 取。时区类还定义了一个偏移量，用来在当前时刻或某时间与目标时区时间之间进 行转换。
        //默认时区
        System.out.println(ZoneId.systemDefault());
        //支持的所有时区
        System.out.println(ZoneId.getAvailableZoneIds());
        //当前的标准偏移量
        System.out.println(ZoneId.of("Asia/Shanghai").getRules());


        //2.LocalTime 本地时间
        //本地时间类表示一个没有指定时区的时间，例如，10 p.m.或者17:30:15，下面的 例子会用上面的例子定义的时区创建两个本地时间对象。然后我们会比较两个时 间，并计算它们之间的小时和分钟的不同。
        // 创建上海Asia/Shanghai和伦敦Europe/London的时区 测试LocalTime
        LocalTime now = LocalTime.now(ZoneId.of("Europe/London"));
        LocalTime now1 = LocalTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(now);
        System.out.println(now1);
        System.out.println(now1.isBefore(now));
        //计算两个时区的时间差
        long hoursBetween = ChronoUnit.HOURS.between(now, now1);
        System.out.println(hoursBetween);

        //LocalTime是由多个工厂方法组成，其目的是为了简化对时间对象实例的创建和操 作，包括对时间字符串进行解析的操作
        LocalTime of = LocalTime.of(12, 12, 12);
        System.out.println(of);
        DateTimeFormatter germanFormatter =
                DateTimeFormatter
                        .ofLocalizedTime(FormatStyle.SHORT)
                        .withLocale(Locale.GERMAN);
        LocalTime leetTime = LocalTime.parse("13:37", germanFormatter);
        System.out.println(leetTime);


        //LocalDate 日期
        LocalDate today = LocalDate.now();
        System.out.println(today);
        //向后推一天
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        System.out.println(tomorrow);
        //向后推两天
        LocalDate yesterday = today.minusDays(2);
        System.out.println(yesterday);
        //计算星期
        LocalDate independenceDay = LocalDate.of(2020, Month.DECEMBER, 28);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
        System.out.println(dayOfWeek);

        DateTimeFormatter germanFormatter1 =
                DateTimeFormatter
                        .ofLocalizedDate(FormatStyle.MEDIUM)
                        .withLocale(Locale.GERMAN);
        LocalDate xmas = LocalDate.parse("12.12.2020", germanFormatter1);
        System.out.println(xmas);

        //LocalDateTime 日期时间
        LocalDateTime sylvester = LocalDateTime.of(2020, Month.DECEMBER,
                31, 23, 59, 59);
        System.out.println(sylvester);

        DayOfWeek dayOfWeek1 = sylvester.getDayOfWeek();
        System.out.println(dayOfWeek1);

        Month month = sylvester.getMonth();
        System.out.println(month);

        long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
        System.out.println(minuteOfDay);

        //转成Date对象
        Instant instant1 = sylvester.atZone(ZoneId.systemDefault()).toInstant();
        System.out.println(Date.from(instant1));

        //格式化时间 yMd Hms
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm:ss");
        String format = dateTimeFormatter.format(LocalDateTime.now());
        System.out.println(format);



    }
}
