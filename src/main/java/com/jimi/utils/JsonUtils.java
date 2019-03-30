/*
 * COPYRIGHT. ShenZhen JiMi Technology Co., Ltd. 2018.
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
 * 2018/11/23    zhangduanfeng         Create the class
 * http://www.jimilab.com/
 */


package com.jimi.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author zhangduanfeng
 * @version 1.0
 * @date 2018/11/23 17:22
 */
public final class JsonUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtils.class);
    private static final ObjectMapper JACKSON_MAPPER = new ObjectMapper();

    static {
        // 不将时间写为时间戳？？
        JACKSON_MAPPER.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        // 遇到空对象不报错
        JACKSON_MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        // 不输出null
        JACKSON_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // 配置NullValue，不输出null的话，改配置会没有效果
        JACKSON_MAPPER.getSerializerProvider().setNullValueSerializer(new EmptyStringSerializer());
        // 配置Date对象的Format
        JACKSON_MAPPER.setDateFormat(new SimpleDateFormat(DatePattern.DATETIME_YYYY_MM_DD_HH_MM_SS));
        // 配置Java8对象的Format
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDateTime.class,
                new LocalDateTimeSerializer(DatePattern.ofPattern(DatePattern.DATETIME_YYYY_MM_DD_HH_MM_SS)));
        javaTimeModule.addSerializer(LocalDate.class,
                new LocalDateSerializer(DatePattern.ofPattern(DatePattern.DATE_YYYY_MM_DD)));
        javaTimeModule.addSerializer(LocalTime.class,
                new LocalTimeSerializer(DatePattern.ofPattern(DatePattern.TIME_HH_MM_SS)));

        javaTimeModule.addDeserializer(LocalDateTime.class,
                new LocalDateTimeDeserializer(DatePattern.ofPattern(DatePattern.DATETIME_YYYY_MM_DD_HH_MM_SS)));
        javaTimeModule.addDeserializer(LocalDate.class,
                new LocalDateDeserializer(DatePattern.ofPattern(DatePattern.DATE_YYYY_MM_DD)));
        javaTimeModule.addDeserializer(LocalTime.class,
                new LocalTimeDeserializer(DatePattern.ofPattern(DatePattern.TIME_HH_MM_SS)));

        JACKSON_MAPPER.registerModule(new Jdk8Module()).registerModule(new ParameterNamesModule()).registerModule(javaTimeModule);
    }

    private JsonUtils() {
    }

    /**
     * 获取ObjectMapper
     *
     * @return com.fasterxml.jackson.databind.ObjectMapper
     * @author zhangduanfeng
     * @date 2018/12/12 18:08
     */
    public static ObjectMapper getJacksonMapper() {
        return JACKSON_MAPPER;
    }

    /**
     * 将对象转为JSON字符串
     *
     * @param obj
     * @return java.lang.String
     * @author zhangduanfeng
     * @date 2018/12/12 18:08
     */
    public static String toJsonString(Object obj) {
        if (obj == null) {
            return "{}";
        }
        try {
            return getJacksonMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return "{}";
    }

    /**
     * JSON字符串转Map
     *
     * @param jsonStr
     * @return java.util.Map<java.lang.String , java.lang.Object>
     * @author zhangduanfeng
     * @date 2018/12/12 18:09
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> json2Map(String jsonStr) {
        if (StringUtils.isEmpty(jsonStr)) {
            return new HashMap<>(0);
        }
        try {
            return getJacksonMapper().readValue(jsonStr, Map.class);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 判断是否为JSON字符串
     *
     * @param str
     * @return boolean
     * @author zhangduanfeng
     * @date 2018/12/12 18:09
     */
    public static boolean isJson(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        try {
            getJacksonMapper().readValue(str, Map.class);
            return true;
        } catch (Throwable t) {
            return false;
        }
    }

    /**
     * Map转JSON字符串
     *
     * @param map
     * @return java.lang.String
     * @author zhangduanfeng
     * @date 2018/12/12 18:09
     */
    public static String map2Json(Map<String, Object> map) {
        if (map == null) {
            return "{}";
        }
        try {
            return getJacksonMapper().writeValueAsString(map);
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return "{}";
    }

    /**
     * JSON字符串转对象
     *
     * @param jsonStr
     * @param cls
     * @return java.util.Optional<T>
     * @author zhangduanfeng
     * @date 2018/12/12 18:10
     */
    public static <T> Optional<T> json2Obj(String jsonStr, Class<T> cls) {
        if (StringUtils.isEmpty(jsonStr)) {
            return Optional.empty();
        }
        try {
            return Optional.ofNullable(getJacksonMapper().readValue(jsonStr, cls));
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return Optional.empty();
    }

    /**
     * JSON字符串转复杂对象
     *
     * @param jsonStr
     * @param typeReference
     * @return java.util.Optional<T>
     * @author zhangduanfeng
     * @date 2018/12/12 18:10
     */
    public static <T> Optional<T> json2Obj(String jsonStr, TypeReference<T> typeReference) {
        if (StringUtils.isEmpty(jsonStr)) {
            return Optional.empty();
        }
        try {
            return Optional.ofNullable(getJacksonMapper().readValue(jsonStr, typeReference));
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return Optional.empty();
    }

    static class EmptyStringSerializer extends JsonSerializer<Object> {

        @Override
        public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeString(StringUtils.EMPTY);
        }
    }
}
