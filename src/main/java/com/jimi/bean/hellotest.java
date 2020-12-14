package com.jimi.bean;

import com.jimi.shiro.User;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.beans.BeanGenerator;
import org.springframework.cglib.beans.BeanMap;

class hellotest {

  private static final hellotest tqw = new hellotest();
  private hellotest(){
    System.out.println("hello");
  }
  public static hellotest getInstance(){
    return tqw;
  }

  public static void main(String[] args) throws InterruptedException {
    System.out.println("23112");
    Thread.sleep(7000);
    hellotest.getInstance();
  BeanGenerator beanGenerator = new BeanGenerator();
    beanGenerator.addProperty("id",Long.class);
    beanGenerator.addProperty("name",String.class);
    Object obj = beanGenerator.create();

    BeanMap beanMap = BeanMap.create(obj);

    BeanCopier copier = BeanCopier.create(User.class, obj.getClass(), false);


  }


}
