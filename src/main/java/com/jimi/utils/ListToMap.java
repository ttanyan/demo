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
 * 2019/1/23    Tanlianwang         Create the class
 * http://www.jimilab.com/
 */


package com.jimi.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/1/23 9:55
 */
public class ListToMap {
    public static void main(String[] args) {
        List<Person> list = new ArrayList();
        list.add(new Person("1001", "小A"));
        list.add(new Person("1002", "小B"));
        list.add(new Person("1003", "小C"));
        System.out.println(list);
//将list转换map
        Map<String, String> map = list.stream().collect(Collectors.toMap(Person::getId, Person::getName));
        System.out.println(map);

    }
}
