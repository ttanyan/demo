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
 * 2019/1/15    Tanlianwang         Create the class
 * http://www.jimilab.com/
 */


package com.jimi.bean2json1;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/1/15 14:29
 */

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
/**
 * 定义一个要格式化的类 StudentsReport，
 * 使用@JsonSerialize进行格式化，对应的格式化类为 StudentsReportSerializer
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/1/15 14:29
 */
@JsonSerialize(using = StudentsReportSerializer.class)
public class StudentsReport {
    List<String> names = newArrayList();
    List<Student> studentList =  newArrayList();

    public List<String> getNames() {
        return names;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public StudentsReport(List<String> names, List<Student> studentList) {
        this.names = names;
        this.studentList = studentList;
    }
}
