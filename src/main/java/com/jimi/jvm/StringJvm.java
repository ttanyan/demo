/*
 * COPYRIGHT. ShenZhen JiMi Technology Co., Ltd. 2020.
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
 * 2020/11/18    anyant         Create the class
 * http://www.jimilab.com/
 */


package com.jimi.jvm;

/**
 * @author anyant
 * @version 1.0
 * @ProjectName demo
 * @Description
 * @Date 2020/11/18 12:04 下午
 */
public class StringJvm {
//    String s=new String("abc");
//    String s1="abc";
//    String s2=new String("abc");
//    上段代码究竟产生了几个对象？
//    这涉及到JVM中String 的机制，当你new 一个String时，总会在堆中新建一个对象，然后String 引用指向这个对象，然后检查String pool（字符串池）中有没有和这个字符串内容一样的字符串，没有的话，将此字符串加入String pool。
//    当你用形如 String a = "abc"，声明一个字符串时，jvm先检查串池里有没有 abc 这个字符串，有的话直接指向此字符串，没有的话在串池中增加这个字符串，然后指向它。
//    你可以试试 String a ="abc"; String b = "abc";   System.out.print(a == b)  输出true
//    此时，a 和 b都指向 串池中的 "abc"
//    而 String a = new ("abc"); String b = "abc";   System.out.print(a == b)  输出false
//    此时，a指向堆中的"abc"对象，b指向串池中的"abc"对象
//    "=="比较的是两个引用变量所指向的是否是同一个对象，是的话则返回true，否则false
    /**
     *
     * @param args
     */

    public static void main(String[] args) {
        String s1 = new String("abc");
        String s = "abc";
        String s2 = new String("abc");
        String s3 = "abc";

        System.out.println(s==s1);
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
        System.out.println(s == s3);
    }
}
