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
 * @date 2019/1/15 14:33
 */

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * 对应的格式化类
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/1/15 14:34
 */
public class StudentsReportSerializer extends JsonSerializer<StudentsReport> {

    @Override
    public void serialize(StudentsReport studentsReport, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();//start write:{


        jsonGenerator.writeFieldName("studentName");

        jsonGenerator.writeStartArray();
        for(String name:studentsReport.getNames()){
            jsonGenerator.writeObject(name);
        }
        jsonGenerator.writeEndArray();


        jsonGenerator.writeFieldName("studentsData");
        jsonGenerator.writeStartArray();
        for(Student student: studentsReport.getStudentList()){
            jsonGenerator.writeStartObject();

            jsonGenerator.writeStringField("name",student.getName());
            jsonGenerator.writeNumberField("age", student.getAge());
            jsonGenerator.writeNumberField("number",student.getNumber());
            jsonGenerator.writeStringField("sex",student.getSex());

            jsonGenerator.writeEndObject();
        }

        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();//end }




    }
}
