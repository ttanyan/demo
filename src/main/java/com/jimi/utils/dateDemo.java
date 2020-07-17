package com.jimi.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

class dateDemo {
 static DateTimeFormatter dateTimeFormatter = DateTimeFormatter
      .ofPattern(DatePattern.DATETIME_YYYYMMDDHHMMSS);


  public  String  foramt(String date,DateTimeFormatter formatter){
        if(date == null ){
          date = LocalDateTime.now().toString();
        }
        if(formatter == null){
          formatter = dateTimeFormatter;
        }
      return null;

  }

  public static void main(String[] args) {




    String format = LocalDateTime.now().format(dateTimeFormatter);
    System.out.println(format);
    System.out.println(LocalDateTime.now());


  }

}
