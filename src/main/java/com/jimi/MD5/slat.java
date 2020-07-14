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
 * 2019/4/8    Tanlianwang         Create the class
 * http://www.jimilab.com/
 */


package com.jimi.MD5;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import sun.security.provider.MD5;

import java.util.ArrayList;
import java.util.Vector;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/4/8 13:50
 */
public class slat {

    public static void main(String[] args) {
        String password = "321";
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 8;
        String algorithmName = "md5";
        System.out.println(MD5("t19962864",1));
        String encodedPassword = new SimpleHash(algorithmName, password, salt, times).toString();
        System.out.printf("原始密码是 %s , 盐是： %s, 运算次数是： %d, 运算出来的密文是：%s ", password, salt, times, encodedPassword);
        System.out.println();

        Object testObject = new ArrayList();
        displayObjectClass(testObject);
    }

    public static void displayObjectClass(Object o) {
        if (o instanceof Vector) {
            System.out.println("对象是 java.util.Vector 类的实例");
        } else if (o instanceof ArrayList) {
            System.out.println("对象是 java.util.ArrayList 类的实例");
        } else {
            System.out.println("对象是 " + o.getClass() + " 类的实例");
        }
    }

    public static String MD5 (String s,Integer times){

        for( int i = 0;i < times; i++){
           s = DigestUtils.md5Hex(s);
        }
        return  s;

    }
}

