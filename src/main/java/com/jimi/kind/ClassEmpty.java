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
 * 2019/5/27      TanLianWang       Create the class
 * http://www.jimilab.com/
 */


package com.jimi.kind;

import com.jimi.bean2json1.Student;

import static org.springframework.util.ObjectUtils.isEmpty;

/**
 * @author TanLianWang
 * @version 1.0
 * @Description
 * @Date 2019/5/27 0:17
 */
public class ClassEmpty {

    public static void main(String[] args) {
        Student student = new Student();
        student.setAge(1);
        student.setName("鸟");
        student.setNumber(123);
        student.setSex("男");
        System.out.println(student.toString());
        System.out.println(student.toString().isEmpty());
        Student student1 = new Student();
        System.out.println(student1.toString());
        System.out.println(student1.toString().isEmpty());
        System.out.println(isEmpty(student));
        System.out.println(isEmpty(student1));
    }
}
