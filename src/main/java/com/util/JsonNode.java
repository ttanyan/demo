package com.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author Tan Lianwang
 * @title: JsonNode
 * @date 2022/6/8 11:39
 */
public class JsonNode {
    public static void main(String[] args) {
        String carJson = "[{\"specId\":0,\"specName\":\"开始时间\",\"specType\":2,\"specVal\":\"2022-06-0714:22:59\",\"specValname\":\"开始时间\"},{\"specId\":0,\"specName\":\"结束时间\",\"specType\":3,\"specVal\":\"2022-07-0714:22:59\",\"specValname\":\"结束时间\"},{\"specId\":2736,\"specName\":\"购买时长\",\"specType\":12,\"specVal\":\"1\",\"specValname\":\"1\"},{\"specId\":2735,\"specName\":\"经营地\",\"specType\":1,\"specVal\":\"3729,3732\",\"specValname\":\"3729,3732\"}]";

        ObjectMapper objectMapper = new ObjectMapper();


        try {

            com.fasterxml.jackson.databind.JsonNode jsonNode = objectMapper.readTree(carJson);
            for (int i = 0; i < jsonNode.size(); i++) {
                com.fasterxml.jackson.databind.JsonNode jsonNode1 = jsonNode.get(i);
                String specId = jsonNode1.get("specId").asText();
                System.out.println(specId);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }




//            com.fasterxml.jackson.databind.JsonNode brandNode = jsonNode.get("specId");



//            String brand = brandNode.asText();
//            System.out.println("brand = " + brand);


//            com.fasterxml.jackson.databind.JsonNode doorsNode = jsonNode.get("doors");
//            int doors = doorsNode.asInt();
//            System.out.println("doors = " + doors);
//
//            com.fasterxml.jackson.databind.JsonNode array = jsonNode.get("owners");
//            com.fasterxml.jackson.databind.JsonNode jsonNode1 = array.get(0);
//            String john = jsonNode1.asText();
//            System.out.println("owners  = " + array.toString());
//
//            com.fasterxml.jackson.databind.JsonNode child = jsonNode.get("nestedObject");
//            com.fasterxml.jackson.databind.JsonNode childField = child.get("field");
//            String field = childField.asText();
//            System.out.println("field = " + field);
//

    }
}
