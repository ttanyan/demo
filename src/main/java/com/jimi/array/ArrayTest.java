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
        Set<String> aimei = new HashSet<>(list2);
        Set<String>  nimei = new HashSet<>(list2);
        System.out.println(nimei.size());
        aimei.isEmpty();
        Object[] strArray = aimei.toArray();
        for(int i = 0;i<strArray.length;i++){
            System.out.println(strArray[i]);
        }

        String bimei = "2015132114\n\r2015132113\n\n\n\n\n\n\n\n\n\n\n\n\n\r\r2015132115\n2015132110\n2015132116";

        String imeis = bimei.replaceAll("\n+",",").replaceAll("\r+",",");
        String imeis1 = bimei.replaceAll("\n",",").replaceAll("\r",",").replaceAll(",+",",").replaceAll(" ","");
        System.out.println("bimei"+bimei+"\n"+"imeissssssssssssssssssss"+imeis);

        Set<String> imeiArray = new HashSet<>(Arrays.asList(imeis.split(",")));
        System.out.println(aimei);
        System.out.println(imeiArray);
        imeiArray.addAll(aimei);
        System.out.println(imeiArray);

    }
}
