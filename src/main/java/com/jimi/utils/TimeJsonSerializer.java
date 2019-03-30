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


package com.jimi.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalTime;
import java.time.temporal.ChronoField;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/1/15 13:28
 */
public  class TimeJsonSerializer extends JsonSerializer<Integer> {
    private static final long MAX_MILLIS_OF_DAY = ChronoField.SECOND_OF_DAY.range().getMaximum();
    public static String second2Time(Integer second) {
        if (second == null) {
            return "0天00小时00分00秒";
        }

        StringBuilder builder = new StringBuilder();
        int days = 0;
        if (second > MAX_MILLIS_OF_DAY) {
            days = (int) (second / MAX_MILLIS_OF_DAY);
        }
        if (second > 0) {
            return builder.append(days).append("天").append(DateUtils.format(LocalTime.ofSecondOfDay(second - (days * MAX_MILLIS_OF_DAY)), "HH小时mm分ss秒")).toString();
        } else {
            return builder.append("0天00小时00分00秒").toString();
        }
    }

    @Override
    public void serialize(Integer integer, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(second2Time(integer));

    }
}
