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
 * 2019/1/28    Tanlianwang         Create the class
 * http://www.jimilab.com/
 */


package com.jimi.mongo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/1/28 10:56
 */
@RestController
@RequestMapping(value = "/admin")
public class MongoTest {
    @Autowired
    private MongoDao mongoDao;

    @GetMapping(value = "/save")
    public void saveTest() throws  Exception{
        Book book = new Book("MySQL","MySQL是关系型数据库","23元","mydql.com","200");
        mongoDao.save(book);
    }

    @GetMapping(value = "/find")
    public Book findTest(){
        Book book = mongoDao.findByTitle("MySQL");
        System.out.println(book.getDescription());
        return book;
    }

    @GetMapping(value = "/update")
    public void uodateTest(){
        Book book = new Book();
        book.setTitle("MySQL");
        book.setBy("Redis");
        book.setDescription("Redis 是非关系型数据库");
        mongoDao.updateByBook(book);
    }

    @GetMapping(value = "/delete")
    public void deleteTest(){
        mongoDao.delete("MySQL");
    }
}
