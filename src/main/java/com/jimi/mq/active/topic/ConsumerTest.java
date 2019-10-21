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
 * @date 2019/1/29 11:06
 * 消费
 */
public class ConsumerTest {
    public static void main(String[] args)  throws  Exception{
        //1、创建工厂连接，指定ip、用户名、密码
        ActiveMQConnectionFactory activeMQConnectionFactory =
                new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,ActiveMQConnection.DEFAULT_PASSWORD, ActiveMQConnection.DEFAULT_BROKER_URL);
        //2、使用连接工厂创建一个连接对象
        Connection connection = activeMQConnectionFactory.createConnection();
        //3、开启连接
        connection.start();
        System.out.println("连接成功");
        //4、使用连接对象创建会话对象
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        //5、使用会话对象创建目标对象
//        Topic topic = session.createTopic("mytopic");
        Queue queue =session.createQueue("myqueue");
        //6、使用会话对象创建消费者
        MessageConsumer consumer = session.createConsumer(queue);
        //7、向消费者对象中设置一个messageListener对象，用来接受消息
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                //判断消息是否为TextMessage的实例,如果是，则创建一个textMessage
                if(message instanceof  TextMessage){
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        System.out.println(textMessage.getText()+"==============================================");
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        //8、程序等待接收用户消息
        System.in.read();
        System.out.println(System.in.read());
        //9、关闭资源
        consumer.close();
        session.close();
        connection.close();
    }





}
