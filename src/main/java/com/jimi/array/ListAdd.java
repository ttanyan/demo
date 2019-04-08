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
 * 2019/2/18    Tanlianwang         Create the class
 * http://www.jimilab.com/
 */


package com.jimi.array;

import java.util.*;

/**
 * 合并集合
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/2/18 15:16
 */
public class ListAdd {
    public static void main(String[] args) {
            //合并两个list
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        //给list1赋值
        list1.add("测");
        list1.add("试");
        list1.add("一");
        list1.add("下");
        System.out.println(list1.isEmpty());
        //给list2赋值
        list2.add("下");
        list2.add("并");
        list2.add("列");
        list2.add("表");
        //将list1.list2合并
        list1.addAll(list2);
        //循环输出list1 看看结果
        for (String s : list1) {
            System.out.print(s);
        }
        System.out.println("\n");
        //合并两个set
        Set<String> aSet = new HashSet<>();
        Set<String> bSet = new HashSet<>();
        aSet.add("呵呵");
        aSet.add("哈哈");
        System.out.println(aSet);
        bSet.add("哈哈");
        bSet.add("嘻嘻");
        System.out.println(bSet);
        //set自动去重复
        aSet.addAll(bSet);
        System.out.println(aSet);

    }

}
