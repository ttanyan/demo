package com;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

/**
 * @author Tan Lianwang
 * @title: test
 * @date 2022/3/22 16:33
 */
public class test {
    public static void main(String[] args) {
        Properties properties = System.getProperties();
        CollectionUtils.isEmpty(new ArrayList<>());
        ArrayList<Object> list = null;
        System.out.println(CollectionUtils.isEmpty(list));
        System.out.println(properties.getProperty("os.name"));
        System.out.println(new Date().getTime());
        System.out.println(System.currentTimeMillis());
    }
}
