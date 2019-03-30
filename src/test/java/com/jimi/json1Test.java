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


package com.jimi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jimi.bean2json1.Student;
import com.jimi.bean2json1.StudentsReport;

import static com.google.common.collect.Lists.newArrayList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/1/15 13:44
 */
public class json1Test {
    public static void main(String[] args) throws JsonProcessingException {

        Student student1 = new Student("乔布斯",12,2,"女");
        Student student2 = new Student("张小龙",23,124123,"男");
        Student student = new Student("李小龙",12,23,"gay");

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student);

        List<String> studentsName = newArrayList(student1.getName(),student2.getName(),student.getName());


        StudentsReport report = new StudentsReport(studentsName,studentList);

        ObjectMapper mapper = new ObjectMapper();
        String jsonReport = mapper.writeValueAsString(report);
        System.out.println(jsonReport);

    }

}
