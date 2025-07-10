package com.jimi;

/**
 * @author Tan Lianwang
 * @title: Demo
 * @date 2025/7/9 11:31
 */

import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

/**
 * 传音后端AI助理面试题
 * 已知某 http api (https://bus-ie.aibotplatform.com/echo) 返回一段 json, 格式示意如下
 * {
 * "requestID": "voN_20241107_135603_133_c8k7e44O",
 * "code": 200,
 * "message": "OK",
 * "echoMessage": "",
 * "randomData": "",
 * "clientIP": ""
 * }
 * 要求:
 * 1. 使用 java 或 golang, 或自己熟悉的其它编程语言, 通过系统或第三方类库提供的 http api, 将 json 数据拉取下来
 * 1.1. 将 json 解析到结构体中, 并打印各字段的值.
 * 1.2. 将 http 回包中的 数字, 替换成减号, 并保存在文件中
 */
public class Demo {


    public static void main(String[] args) {
        try {
            // 1. 拉取 API 数据
            String jsonData = fetchApiData();
            System.out.println("原始 JSON 数据: " + jsonData);
            // 1.1. 解析打印各字段的值
            Response response = JSONObject.parseObject(jsonData, Response.class);
            System.out.println("字断值"+JSONObject.toJSONString(response));

            // 1.2. 替换数字并保存到文件
            String modifiedJson = replaceNumbersWithHyphens(jsonData);
            saveFile(modifiedJson, "modified_data.json");
            System.out.println("修改后的 JSON 数据已保存到 modified_data.json");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private  static String fetchApiData() throws IOException {
        URL url = new URL("https://bus-ie.aibotplatform.com/echo");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.setConnectTimeout(5000);

        InputStream inputStream = urlConnection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        return response.toString();
    }


    public  static String replaceNumbersWithHyphens(String json) {
        Pattern pattern = Pattern.compile("\\d+");
        return pattern.matcher(json).replaceAll("-");
    }

    public static void saveFile(String content, String fileName) throws IOException {
        try{
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(content);
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
            throw new IOException("Error writing to file: " + fileName, e);
        }



    }



}
