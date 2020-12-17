package com.jimi;

import com.jimi.annotations.Lazy;
import com.jimi.annotations.LazyConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LazyTest {

  public static void main(String[] args) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(LazyConfig.class);
    //需要的时候采取加载,
    Lazy lazy = ctx.getBean(Lazy.class);

  }


}
