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
 * @date 2019/1/29 14:25
 */
public class ConsumerQueue {

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
        MessageConsumer consumer = session.createConsumer(queue);
        //7、向consumer对象中设置一个messageListener对象，用来接收消息
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                if(message instanceof TextMessage){
                    TextMessage textMessage = (TextMessage)message;
                    try {
                        System.out.println("\n");
                        System.out.println("\n");
                        System.out.println("\n");
                        System.out.println(dateTimeFormatter.format(LocalDateTime.now()) +"接收到了："+textMessage.getText());
                        System.out.println("\n");
                        System.out.println("\n");
                        System.out.println("\n");
                    } catch (JMSException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        //8、程序等待接收用户消息
        System.in.read();
        //9、关闭资源
        consumer.close();
        session.close();
        connection.close();

    }
}
