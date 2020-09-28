/*
 * COPYRIGHT. ChongQing UTECH Technology Co., Ltd. 2020.
 * ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording,
 * or otherwise, without the prior written permission of ChongQing UTECH Network Technology Co., Ltd.
 *
 * Amendment History:
 *
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * 2020-05-09 10:56                  TanLianWang          Create the class
 * http://www.chinautech.com/
 */

package com.jimi.utils;

import org.springframework.beans.BeanUtils;

/**
 * 
 * @author TanLianWang 
 * @version 1.0 
 * @date 2020/5/9 10:56
 */
public class BeanToBean  {

    public static class Student{
        private String name;
        private String age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }

    public static class Person{
        private String name;
        private String age;
        private String tel;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    ", tel='" + tel + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.setAge("11");
        student.setName("你好");

        Person person = new Person();

        BeanUtils.copyProperties(student,person);
        System.out.println(person.toString());

    }



}
