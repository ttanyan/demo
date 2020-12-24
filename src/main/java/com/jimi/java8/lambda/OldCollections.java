package com.jimi.java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author test
 */
public class OldCollections {
    public static void main(String[] args) {
        //用ASCII排序对数组排序

        //以前的方法
        List<String> names = Arrays.asList("al","ab","za","lf");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        //现在的方法
        names.sort(String::compareTo);

        System.out.println(names);

        List<Integer> list = Arrays.asList(1, 54, 234, 23, 532);
        //倒序
        list.sort(Comparator.reverseOrder());
        System.out.println(list);
        //正序
        names.sort(Comparator.reverseOrder());
        System.out.println(names);

    }



}
