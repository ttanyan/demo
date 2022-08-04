package com.jimi;

import org.assertj.core.util.Lists;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Tan Lianwang
 * @title: ListTest
 * @date 2022/5/19 11:40
 */
public class ListTest {
    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(0);
//        list.add(0);
//        list.add(0);
//        list.add(0);
//        list.add(0);
//        list.add(0);
//        list.add(1);
//        list.add(0);
//        System.out.println(list.contains(1));
//
//        ArrayList<String> strings = new ArrayList<>();
//        strings.add("tags");
//        strings.add("dev");
//        strings.add("test");
//        strings.add("tags");
//        strings.add("tags");
//        List<String> collect = strings.stream().filter(string -> !"tags".equals(string)).collect(Collectors.toList());
//        System.out.println(collect);
//
//        String productId = "55858,55807,55822,55859,55811,55823,55860,55813,55861,55818,55825,55821,55803,55824,55806,55820";
//        System.out.println(productId.contains("55825"));


//        List<Map<String, Object>> maplist = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            Map<String, Object> map = new HashMap<>();
//            map.put("type", i);
//            maplist.add(map);
//        }
//        System.out.println("list过滤前的数据:" + maplist);
//        System.out.println("list过滤前的数量:" + maplist.size());
//        //过滤获取 type=2的数据
//        List<Map<String, Object>> list2 = maplist.stream().filter((Map a) -> ("2".equals(a.get("type").toString()))).collect(Collectors.toList());
//        //只获取数量也可以这样写
//        Long list2Count = list2.stream().filter((Map a) -> ("2".equals(a.get("type").toString()))).count();
//        System.out.println("list过滤后的数据:" + list2);
//        System.out.println("list过滤后的数量:" + list2Count);
//        System.out.println("list过滤后的数量:" + list2.size());


        ArrayList<Integer> list = Lists.newArrayList(1,1,3,4,4);
        HashSet<Integer> integers = new HashSet<>(list);

        System.out.println(integers);



    }
}
