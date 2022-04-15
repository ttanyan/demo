package com.bingfa.thread;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author Tan Lianwang
 * @title: test
 * @date 2022/2/9 10:12
 */
public class test {

    public volatile Map sensitiveWordMap = null;

    public volatile Map relevanceWordMap = null;
    public  void addSensitiveWordToHashMap(Set<String> keyWordSet, Map<String, String> relevancyMap) {

//         sensitiveWordMap = new HashMap(keyWordSet.size());
        Map newSensitiveMap = new HashMap();
        String key;
        //引用指向的使用
        Map nowMap;
        Map<String, String> newWorMap = null;

        Iterator<String> iterator = keyWordSet.iterator();
        while (iterator.hasNext()) {
            key = iterator.next();
            if (StringUtils.isNotBlank(key)) {
                nowMap = newSensitiveMap;
                for (int i = 0; i < key.length(); i++) {
//                    System.out.println(newSensitiveMap.keySet()+" "+newSensitiveMap.hashCode());
//                    System.out.println(nowMap.keySet()+""+nowMap.hashCode());
                    char keyChar = key.charAt(i);
                    Object wordMap = nowMap.get(keyChar);
                    if (wordMap != null) {
                        nowMap = (Map) wordMap;
                    } else {
                        newWorMap = new HashMap<String, String>();
                        newWorMap.put("isEnd", "0");
                        nowMap.put(keyChar, newWorMap);
                        nowMap = newWorMap;
                    }
                    if (i == key.length() - 1)
                        nowMap.put("isEnd", "1");
                }
            }
        }

        sensitiveWordMap = newSensitiveMap;
        relevanceWordMap = relevancyMap;
    }


    public static void main(String[] args) throws InterruptedException {
        double n = 10;
        System.out.println("本金10W");
        for (int i = 1; i <=10; i++) {
            n=n+n*0.1;
            BigDecimal bigDecimal = new BigDecimal(n);
            System.out.println("第"+i+"个涨停:"+bigDecimal.toString());
//            if(n > 100000000){
//                return;
//            }
        }

//        Set<String> keyWordSet = new HashSet<>();
//        Map<String, String> relevancyMap = new HashMap<>();
//        keyWordSet.add("习近平");
//        keyWordSet.add("李克强");
//        relevancyMap.put("习近平","领导");
//        relevancyMap.put("李克强","领导");
//        test test = new test();
//        test.addSensitiveWordToHashMap(keyWordSet,relevancyMap);
//        System.out.println(test.sensitiveWordMap.keySet());
        Map newSensitiveMap = new HashMap();
        String key;
        //引用指向的使用
        Map nowMap;
        Map<String, String> newWorMap = null;




        DefaultThreadPool<Runnable> threadPool = new DefaultThreadPool<>();

        for (int i = 0; i < 1000; i++) {
            Job job = new Job(i);
            threadPool.execute(job);
        }
    }
    static class Job implements Runnable{
        private int test;

        public Job(Integer test) {
            this.test = test;
        }

        @Override
        public void run() {
            System.out.println("job被执行"+test);
            System.out.println(Thread.currentThread().getName());
        }
    }
}
