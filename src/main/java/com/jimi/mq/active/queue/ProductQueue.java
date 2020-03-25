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
 * 2019/1/29    Tanlianwang         Create the class
 * http://www.jimilab.com/
 */


package com.jimi.mq.active.queue;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/1/29 14:21
 */
public class ProductQueue {
    public static void main(String[] args) throws  Exception{
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");
        //1、创建工厂连接对象，需要制定ip和端口号
        ActiveMQConnectionFactory activeMQConnectionFactory =
                new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,ActiveMQConnection.DEFAULT_PASSWORD, ActiveMQConnection.DEFAULT_BROKER_URL);
        //2、使用连接工厂创建一个连接对象
        Connection connection = activeMQConnectionFactory.createConnection();
        //3、开启连接
        connection.start();
        //4、使用连接对象创建会话（session）对象
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5、使用会话对象创建目标对象，包含queue
        Queue queue = session.createQueue("myqueue");
        //6、使用会话对象创建生产者对象
        MessageProducer producer = session.createProducer(queue);
        //7、使用会话对象创建一个消息对象
        TextMessage textMessage = session.createTextMessage(dateTimeFormatter.format(LocalDateTime.now())+"hello!JIMI");
        //8、发送消息
        producer.send(textMessage);
        System.out.println(dateTimeFormatter.format(LocalDateTime.now())+" 发送成功");
        //9、关闭资源
        producer.close();
        session.close();
        connection.close();
    }
}
