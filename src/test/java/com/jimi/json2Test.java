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
 * 2019/1/18    Tanlianwang         Create the class
 * http://www.jimilab.com/
 */


package com.jimi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jimi.bean2json1.Car;
import com.jimi.bean2json1.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/1/18 16:48
 */
public class json2Test {
    public static void main(String[] args) {
        //1.通过对象生成JSON串，对象里包含对象数组转成JSON串。
        Person person1 = new Person("小明","女",12);
        Person person2 = new Person("小花","男",22);
        //对象数组
        List<Person> persons = new ArrayList<Person>();
        persons.add(person1);
        persons.add(person2);
        Car car = new Car("悍马","越野",12345,persons);
        String json = JSON.toJSON(car).toString();
        System.out.println(json);
        System.out.println(JSON.toJSON(persons));
        List<Person> hello = JSON.parseArray(JSON.toJSON(persons).toString(),Person.class);

        //2.通过JSON对象生成json串
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("province","广东省");
        jsonObject.put("city","深圳市");
        jsonObject.put("邮政编码",1233);
        //通过JSONArray封装对象数组
        JSONArray jsonArray = new JSONArray();
        jsonArray.addAll(persons);
        jsonObject.put("Person",jsonArray);
        String json1 = jsonObject.toJSONString();
        System.out.println(json1);



    }
}
