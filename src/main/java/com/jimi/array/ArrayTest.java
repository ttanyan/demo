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

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/2/20 9:17
 */
public class ArrayTest {

    public int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for(int i=0;i<array.length;i++) {
            int a = array[i];
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            }else{
                map.put(a, 1);
            }
        }
        if (map.get(k) != null) {
            result = map.get(k);
        }
        return result;
    }

    StringBuffer sbuf = new StringBuffer();
    //由于字符占用一个字节，8个位，最大长度为256
    int da[] = new int [256];
    //Insert one char from stringtrim

    public void Insert(char ch)
    {
        sbuf.append(ch);
        if(da[ch] == 0){
            da[ch] = 1;
        }else {
            da[ch] ++;
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char temp [] = sbuf.toString().toCharArray();
        for(char i:temp){
            if(da[i] == 1){
                return i;
            }
        }
        return '#';
    }
    public static void main(String[] args) {
//        List<String> list2 = new ArrayList<String>();
//        //给list2赋值
//        list2.add("2015132114");
//        list2.add("2015132111");
//        list2.add("2015132112");
//        list2.add("2015132113");
//        list2.add("2015132114");
//        list2.add("");
//        list2.add("");
//        System.out.println(list2);
//        List<String> jimiList = list2.subList(0,2);
//        System.out.println("###################"+jimiList.toString());
//
//        //List转Set
//        Set<String> aimei = new HashSet<>(list2);
//        // Set转String
//        Object[] strArray = aimei.toArray();
//
//        System.out.println("object对象 "+strArray.toString());
//        //Set转String
//        String s = String.join(",",aimei);
//        System.out.println("sString\r"+s);
//        //空格替换
//        String bimei = "2015132114\n2015132113\n\n\n\n\n\n\n\n\n\n\n\n\n\r\r2015132115\n2015132110\n2015132116";
//        String imeis = bimei.replaceAll("\n+",",");
//        String imeis1 = bimei.replaceAll("\n",",").replaceAll("\r",",").replaceAll(",+",",").replaceAll(" ","");
//        Set<String> imeiArray = new HashSet<>(Arrays.asList(imeis.split(",")));
//        System.out.println(aimei);
//        System.out.println(imeiArray);
//        imeiArray.addAll(aimei);
//        System.out.println(imeiArray);
//
//        //删除头尾空白字符
//        String qs = " rerewr  ";
//        System.out.println(qs.trim());

//        验证String[]的length会不会计算空值
        String[] strings = new String[20];
        strings = new String[]{"1", "", "2", ""};
        Set<String> staffsSet = new HashSet<>(Arrays.asList(strings));
        System.out.println(staffsSet);

        //HashMap计算重复数字
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(2,3);
        System.out.println(map.entrySet()+"           sesefs"+map.size());
        map.entrySet();
        System.out.println(map.get(1));
        System.out.println(map.containsKey(1));



            String str = "i am a good student ！";
            String[] arr = str.split(" ");//将句子以空格分割为一个数组
            for (int i = 0, j = arr.length - 1; i <= j; i++, j--) {
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            //将数组形式显示为字符串形式
            String s = "";//不能给null，要给一个空串
            for (int i = 0; i < arr.length; i++) {
                s += arr[i] + " ";
            }
            System.out.println(s);






    }
}
