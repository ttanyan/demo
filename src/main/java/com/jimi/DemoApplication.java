package com.jimi;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

/**
 * 启动类
 * @author Tanlianwang
 * @version 1.0 
 * @date 2019/1/15 15:06
 */
@SpringBootApplication
@NacosPropertySource(dataId = "demo", autoRefreshed = true)
public class DemoApplication {
    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        logger.info("====================Demo启动成功======================");

    }

}

