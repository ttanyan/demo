package com.util;


import cn.hutool.core.date.DateUtil;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @author Tan Lianwang
 * @title: test
 * @date 2022/3/22 16:33
 */
public class TimeUtils {
    public static void main(String[] args) {
//        Properties properties = System.getProperties();
//        CollectionUtils.isEmpty(new ArrayList<>());
//        ArrayList<Object> list = null;
//        System.out.println(CollectionUtils.isEmpty(list));
//        System.out.println(properties.getProperty("os.name")+"hahah");
//        System.out.println(new Date().getTime());
//        System.out.println(System.currentTimeMillis());
//        System.out.println(System.currentTimeMillis() / 1000);

        System.out.println("============计算两个日期的差(天)===============");
        LocalDate today = LocalDate.now();
        System.out.println("Today : " + today);
        LocalDate birthDate = LocalDate.of(1993, Month.OCTOBER, 19);
        System.out.println("BirthDate : " + birthDate);

        Period p = Period.between(birthDate, today);
        System.out.printf("年龄 : %d 年 %d 月 %d 日", p.getYears(), p.getMonths(), p.getDays());
        System.out.println("\n");

        System.out.println("=============计算两个时间的差(秒）==============");
        Instant inst1 = Instant.now();
        System.out.println("Inst1 : " + inst1);
        Instant inst2 = inst1.plus(Duration.ofSeconds(10));
        System.out.println("Inst2 : " + inst2);
        System.out.println("相差毫秒数 : " + Duration.between(inst1, inst2).toMillis());
        System.out.println("相差秒数 : " + Duration.between(inst1, inst2).getSeconds());
        System.out.println("\n");

        System.out.println("=============计算两个时间的天数(秒）==============");
        LocalDate startDate = LocalDate.of(1993, Month.OCTOBER, 19);
        System.out.println("开始时间  : " + startDate);
        LocalDate endDate = LocalDate.of(2017, Month.JUNE, 16);
        System.out.println("结束时间 : " + endDate);
        long daysDiff = ChronoUnit.DAYS.between(startDate, endDate);
        System.out.println("两天之间的差在天数   : " + daysDiff);
        System.out.println("\n");

        //当日活跃天数
        long beginTime = DateUtil.beginOfDay(new Date()).getTime() / 1000;
        long nowTime = DateUtil.currentSeconds();
        System.out.println("分母： "+(nowTime-1651680000)/60/60/24);
        System.out.println("分母： "+(1651766400-nowTime));










    }
}
