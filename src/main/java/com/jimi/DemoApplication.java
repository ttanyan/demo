package com.jimi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 启动类
 * @author Tanlianwang
 * @version 1.0 
 * @date 2019/1/15 15:06
 */
@SpringBootApplication
public class DemoApplication {
    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        logger.info("====================JavaWeb项目启动成功======================");

    }

}

