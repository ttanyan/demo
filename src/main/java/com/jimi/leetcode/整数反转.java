/*
 * COPYRIGHT. AnyanT tanlianwang@qq.com
 * ALL RIGHTS RESERVED
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording,
 * or otherwise, without the prior written permission of AnyanT.
 * Amendment History:
 * Amendment History:
 *
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * 2021/5/10                 anyant           Create the class
 * https://blog.csdn.net/tingfengqianqu
 */


package com.jimi.leetcode;

import com.google.common.collect.Lists;

import java.util.ArrayList;

/**
 * @author anyant
 * @version 1.0
 * @Description
 * @Date 2021/5/10 23:57
 */
public class 整数反转 {

    public static int daoxu(int x){
        int a=0,b=0,c=0;
        a = x/100 == 0 ? a : x/100;
        b = x/10%10 == 0 ? b : x/10%10;
        c = x%10 == 0 ? c : x%10;
        //限制个位数
        if(a == 0 && b == 0){
            return c;
        }
        //限制两位数个位为0的
        if(x <= 99 && c == 0){
            return b;
        }
        if(a >= 10){
           a = daoxu(a);
        }
        return c*100+b*10+a;
    }

    public static void main(String[] args) {
        System.out.println(daoxu(901000));
        int a[] = new int[5];
        a[0] = 1;
        a[1] = 1;
        a[2] = 1;
        a[3] = 1;
        a[4] = 1;
        System.out.println(a.length);



    }
}
