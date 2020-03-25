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


package com.jimi.mq.active.topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/1/29 9:50
 */
public class ProducePool {

    private String user = ActiveMQConnection.DEFAULT_USER;
    private String password = ActiveMQConnection.DEFAULT_PASSWORD;
    private String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    private String subject = "myqueue";
    private Destination destination = null;
    private Connection connection = null;
    private Session session = null;
    private MessageProducer producer = null;

    /**
     * 初始化工作
     * @throws JMSException
     */
    public void initializa() throws JMSException{

        //1、创建工厂连接对象，需要指定ip和端口号。
        ActiveMQConnectionFactory activeMQConnectionFactory
                = new ActiveMQConnectionFactory(user,password,url);
        //2、使用连接工厂创建一个连接对象
         connection = activeMQConnectionFactory.createConnection();
         //3、使用连接对象创建会话（session）对象
         session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
         //使用会话对象创建生产者
        destination =session.createQueue(subject);
        producer = session.createProducer(destination);

        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
    }


    public void produceMessage(String message) throws JMSException{
        initializa();
        //使用会话对象创建一个消息对象
        TextMessage textMessage = session.createTextMessage(message);
        //开启连接
        connection.start();
        System.out.println("Produce -> Send Message:" + message);
        //发送消息
        producer.send(textMessage);
        System.out.println("Produce -> Send Message complete!");
    }

    public void close() throws JMSException{
        System.out.println("prodcer ->  connection close！");
        if(producer != null){
            producer.close();
        }
        if(session != null){
            session.close();
        }
        if(connection != null){
            connection.close();
        }
    }


}
