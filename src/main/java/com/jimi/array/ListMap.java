/*
 * COPYRIGHT. ShenZhen JiMi Technology Co., Ltd. 2019.
 * ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording,
 * or otherwise, without the prior written permission of ShenZhen JiMi Network Technology Co., Ltd.
 *
 * Amendment History:
 *
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * 2019/10/23    TanLianWang        Create the class
 * http://www.jimilab.com/
 */


package com.jimi.array;

import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author TanLianWang
 * @version 1.0
 * @ProjectName demo
 * @Description
 * @Date 2019/10/23 10:22
 */
public class ListMap {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        for(int i=0;i<10;i++){
            Student student = new Student();
            student.setAge(i);
            student.setName("student"+i);
            students.add(student);
        }
        List<Map<String,Student>> list = ObjectToMap(students);
        System.out.println(list.size());



    }

    public static List<Map<String,Student>> ObjectToMap(List<Student> studentList){
        List<Map<String,Student>> list = new ArrayList<>();
        Map<String,Student> map = new HashMap<>();
        for(int i = 0; i<studentList.size();i++){
            studentList.get(i);
            map.put(Integer.toString(i),studentList.get(i));
            list.add(map);
        }
        return list;

    }

    public static class Student{
        private  Integer age;
        private String name;

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "age='" + age + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
