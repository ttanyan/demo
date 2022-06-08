package com.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Tan Lianwang
 * @title: JsonParserUtil
 * @date 2022/6/8 11:25
 */
public class JsonParserUtil {

    ObjectMapper objectMapper = new ObjectMapper();


    public List<Map<String,Object>> JsonParserList(String sourceData, List<String> sourceList)  {

        objectMapperConfig();
        ArrayList<Map<String,Object>> list = Lists.newArrayList();
        try {
            JsonNode jsonNode = objectMapper.readTree(sourceData);
            for (int i = 0; i < jsonNode.size(); i++) {
                for(String key:sourceList){
                    HashMap<String, Object> targetMap = new HashMap<>();
                    String value = jsonNode.get(i).get(key).asText();
                    targetMap.put(key,value);
                    list.add(targetMap);
                }


            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return list;

    }

    public void  objectMapperConfig(){
        //允许为null，将设置为java默认值
        objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
        //允许未知字段
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }




}
