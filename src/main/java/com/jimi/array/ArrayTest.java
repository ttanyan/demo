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
 * 2019/2/20    Tanlianwang         Create the class
 * http://www.jimilab.com/
 */


package com.jimi.array;

import java.util.*;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/2/20 9:17
 */
public class ArrayTest {
    public static void main(String[] args) {
        List<String> list2 = new ArrayList<String>();
        //给list2赋值
        list2.add("2015132114");
        list2.add("2015132111");
        list2.add("2015132112");
        list2.add("2015132113");
        list2.add("2015132114");
        System.out.println(list2);
        //List转Set
        Set<String> aimei = new HashSet<>(list2);
        // Set转String
        Object[] strArray = aimei.toArray();

        System.out.println("object对象 "+strArray.toString());
        //Set转String
        String s = String.join(",",aimei);
        System.out.println("sString\r"+s);
        //空格替换
        String bimei = "2015132114\n2015132113\n\n\n\n\n\n\n\n\n\n\n\n\n\r\r2015132115\n2015132110\n2015132116";
        String imeis = bimei.replaceAll("\n+",",");
        String imeis1 = bimei.replaceAll("\n",",").replaceAll("\r",",").replaceAll(",+",",").replaceAll(" ","");
        Set<String> imeiArray = new HashSet<>(Arrays.asList(imeis.split(",")));
        System.out.println(aimei);
        System.out.println(imeiArray);
        imeiArray.addAll(aimei);
        System.out.println(imeiArray);

        //删除头尾空白字符
        String qs = " rerewr  ";
        System.out.println(qs.trim());

        //验证String[]的length会不会计算空值
        String[] strings = {"1","","2",""};
        System.out.println(strings.length);



    }
}
