package com.jimi.java8.streamapi;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


/**
 * @author test
 */
public class StreamApi {
    public static void main(String[] args) {
        //通过串行流实现过滤判断。
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abed", "", "jkl");
        //Tips limit获取指定数量的流
        List<String> filtered = strings.stream().limit(3).filter(string -> !string.isEmpty()).collect(Collectors.toList());
        filtered.forEach(System.out::println);
        System.out.println("====================");
        //通过并行流实现迭代
        List<String> parallelString = strings.parallelStream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        parallelString.forEach(System.out::println);

        //forEach来迭代流中的每个数据
        System.out.println("forEach来迭代流中的每个数据");
        parallelString.forEach(s->{
            s="er";
            System.out.println(s);
        });


        //map 方法用于映射每个元素到对应的结果，也可以用于迭代流中的元素
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        //Tips: distinct:去重作用
        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        squaresList.forEach(System.out::println);

        List<String> stringList = parallelString.stream().map(s -> s + s).distinct().collect(Collectors.toList());
        stringList.forEach(System.out::println);

        //filter 方法用于通过设置的条件过滤出元素。以下代码片段使用 filter 方法过滤出空字符串：
        List<String> filterString = Arrays.asList("abc", "", "bc", "efg", "abed", "", "jkl");
        // 获取空字符串的数量
        long count = filterString.stream().filter(String::isEmpty).count();
        List<String> filterCollect = filterString.stream().filter(String::isEmpty).collect(Collectors.toList());
        System.out.println(count);
        System.out.println(filterCollect.size());

        //sorted 方法用于对流进行排序。以下代码片段使用 sorted 方法对输出的 10 个随机数进行排序!
        Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);

        //Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素。Collectors 可用于返回列表或字符串
        List<String> collectList = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("筛选列表: " + collectList);

        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);

        List<Integer> integerList = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        //一些产生统计结果的收集器也非常有用。它们主要用于int、double、long等基本类型上，它们可以用来产生类似如下的统计结果。
        IntSummaryStatistics stats = integerList.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());

    }
}
