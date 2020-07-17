package com.jimi.bean;

import com.jimi.shiro.User;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.beans.BeanGenerator;
import org.springframework.cglib.beans.BeanMap;

class test {
  public static void main(String[] args) {
  BeanGenerator beanGenerator = new BeanGenerator();
    beanGenerator.addProperty("id",Long.class);
    beanGenerator.addProperty("name",String.class);
    Object obj = beanGenerator.create();

    BeanMap beanMap = BeanMap.create(obj);

    BeanCopier copier = BeanCopier.create(User.class, obj.getClass(), false);


  }


}
