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
// * 2019/1/29    Tanlianwang         Create the class
// * http://www.jimilab.com/
// */
//
//
//package com.jimi.mq.active.topic;
//
//import javax.jms.JMSException;
//import java.util.Random;
//
///**
// * @author Tanlianwang
// * @version 1.0
// * @date 2019/1/29 10:23
// */
//public class ProduceTest {
//    public static void main(String[] args) throws InterruptedException, JMSException {
//        ProducePool producePool = new ProducePool();
//        Random random = new Random();
//        for(int i = 0;i<20;i++){
//            Thread.sleep(random.nextInt(3)*1000);
//            producePool.produceMessage("Hello,ActiveMQ! Number:"+i);
//            producePool.close();
//        }
//        producePool.initializa();
//    }
//}
