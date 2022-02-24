/*
 * COPYRIGHT. ShenZhen JiMi Technology Co., Ltd. 2019.
 * ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording,
 * or otherwise, without the prior written permission of ShenZhen JiMi Network Technology Co., Ltd.
 *
 * Amendment History:
 *
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * 2019/1/21    Tanlianwang         Create the class
 * http://www.jimilab.com/
 */


package com.jimi.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/1/21 18:19
 */
public class RedisTest {
    public static void main(String[] args) {

        JedisPoolConfig config = new JedisPoolConfig();
        //最大连接数
        config.setMaxTotal(100);
        //最大空闲值
        config.setMaxIdle(10);

        //连接本地的Redis服务
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        //连接池的方式连接
        try (JedisPool jedisPool = new JedisPool(config, "127.0.0.1", 6379, 3000)) {
            Jedis jedis1 = jedisPool.getResource();


        }

        //输入密码
//        new JedisPoolConfig(config,);
        jedis.auth("199628@tlw");
        System.out.println("连接成功");
        //查看服务是否在运行
        System.out.println("服务正在运行:"+ jedis.ping());

        //Redis  String
        System.out.println("Redis使用字符串");
        jedis.set("1","tanlianwang");
        //相同的键覆盖了前面的值
        jedis.set("1","asdjkhasfd");
        System.out.println(jedis.get("1"));

        //Redis List
        System.out.println("Redis 使用List");
        jedis.lpush("list","hello","hehe");
        jedis.lpush("list","word","xixi");
        jedis.lpush("list","my","name");
        jedis.lpush("list","is","tanlianwang");
        List<String> list = jedis.lrange("list",0,7);
        for (String s:list
             ) {
            System.out.println(s);
        }

        //Redis Keys
        Set<String> keys = jedis.keys("*");
        Iterator<String> it = keys.iterator();
        while (it.hasNext()){
            String key = it.next();
            System.out.println(key);
        }



    }


}
