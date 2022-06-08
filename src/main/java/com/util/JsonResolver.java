package com.util;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.codec.json.Jackson2JsonDecoder;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/**
 * @author Tan Lianwang
 * @title: JsonResolver
 * @date 2022/6/8 10:31
 */
public class JsonResolver {

    public static void main(String[] args) throws IOException {
//        String json = "[{\"specId\":2422,\"specName\":\"产品数量\",\"specType\":15,\"specVal\":\"5\",\"specValname\":\"5\"},{\"specId\":0,\"specName\":\"开始时间\",\"specType\":2,\"specVal\":\"2022-04-11 15:18:51\",\"specValname\":\"开始时间\"},{\"specId\":0,\"specName\":\"结束时间\",\"specType\":3,\"specVal\":\"2022-04-16 15:18:51\",\"specValname\":\"结束时间\"},{\"specId\":2423,\"specName\":\"有效期\",\"specType\":11,\"specVal\":\"5\",\"specValname\":\"5\"}]";
        ObjectMapper objectMapper = new ObjectMapper();


        String carJson =
                "{ \"brand\" : \"Mercedes\", \"doors\" : 4 }";
//        Reader reader = new StringReader(carJson);


        try {

            JsonNode jsonNode = objectMapper.readValue(carJson, JsonNode.class);
            JsonNode jsonNode1 = objectMapper.readTree(carJson);
            System.out.println(jsonNode1.get("doors"));
            System.out.println(jsonNode.get("brand"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        Car car = objectMapper.readValue(carJson, Car.class);

        //允许为null，将设置为java默认值
        objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
        //允许未知字段
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        String carJson1 = "{ \"brand\":\"null\", \"doors\":null }";

        Car car1 = objectMapper.readValue(carJson1, Car.class);
        System.out.println(JSONObject.toJSON(car1));
    }
}
