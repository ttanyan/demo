package com.jimi.annotations;

import org.springframework.context.annotation.Bean;

public class LazyConfig {
  @Bean
  @org.springframework.context.annotation.Lazy
  public Lazy lazy(){
    return new Lazy("李四","5");
  }

}
