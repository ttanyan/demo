///*
// * COPYRIGHT. ShenZhen JiMi Technology Co., Ltd. 2019.
// * ALL RIGHTS RESERVED.
// *
// * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
// * on any form or by any means, electronic, mechanical, photocopying, recording,
// * or otherwise, without the prior written permission of ShenZhen JiMi Network Technology Co., Ltd.
// *
// * Amendment History:
// *
// * Date                   By              Description
// * -------------------    -----------     -------------------------------------------
// * 2019/1/28    Tanlianwang         Create the class
// * http://www.jimilab.com/
// */
//
//
//package com.jimi.mongo;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.data.mongodb.core.query.Update;
//import org.springframework.stereotype.Component;
//
///**
// * @author Tanlianwang
// * @version 1.0
// * @date 2019/1/28 14:33
// */
//@Component
//public class MongoDao {
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    /**
//     * 创建对象
//     */
//    public void save(Book book){
//        mongoTemplate.save(book);
//    }
//
//    /**
//     * 根据用户名查询对象
//     */
//    public Book findByTitle(String title){
//        Query query = new Query(Criteria.where("title").is(title));
//        Book book = mongoTemplate.findOne(query,Book.class);
//        return book;
//    }
//    /**
//     * 更新对象
//     */
//    public void updateByBook(Book book){
//        Query query = new Query(Criteria.where("title").is(book.getTitle()));
//        Update update = new Update().set("description",book.getDescription()).set("by",book.getBy());
//        mongoTemplate.updateFirst(query,update,Book.class);
//    }
//    /**
//     * 删除对象
//     */
//    public void delete(String title){
//        Query query = new Query(Criteria.where("title").is(title));
//        mongoTemplate.remove(query,Book.class);
//    }
//}
//
//
