package com.jimi;

import com.jimi.annotation.Lazy;
import com.jimi.annotation.LazyConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

  public static void main(String[] args) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(LazyConfig.class);
    //需要的时候采取加载,
    Lazy lazy = ctx.getBean(Lazy.class);

  }


}
