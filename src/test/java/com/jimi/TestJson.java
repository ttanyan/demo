package com.jimi;

import com.google.common.collect.Maps;
import com.util.JsonParserUtil;
import org.assertj.core.util.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Tan Lianwang
 * @title: TestJson
 * @date 2022/6/8 14:30
 */
public class TestJson {
    public static void main(String[] args) {
        String json = "[{\"specId\":0,\"specName\":\"开始时间\",\"specType\":2,\"specVal\":\"2022-06-0714:22:59\",\"specValname\":\"开始时间\"},{\"specId\":0,\"specName\":\"结束时间\",\"specType\":3,\"specVal\":\"2022-07-0714:22:59\",\"specValname\":\"结束时间\"},{\"specId\":2736,\"specName\":\"购买时长\",\"specType\":12,\"specVal\":\"1\",\"specValname\":\"1\"},{\"specId\":2735,\"specName\":\"经营地\",\"specType\":1,\"specVal\":\"3729,3732\",\"specValname\":\"3729,3732\"}]";

        JsonParserUtil jsonParserUtil = new JsonParserUtil();
        List<String> list = Lists.newArrayList();
        list.add("specType");
        list.add("specVal");

        List<Map<String, Object>> list1 = jsonParserUtil.JsonParserList(json, list);
        for (int i = 0; i < list1.size(); i++) {
            Map<String, Object> stringObjectMap = list1.get(i);
            for(String key:stringObjectMap.keySet()){
                System.out.println(stringObjectMap.get(key));
            }
        }

    }
}
