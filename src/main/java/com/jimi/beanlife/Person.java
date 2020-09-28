/*
 * COPYRIGHT. ShenZhen JiMi Technology Co., Ltd. 2020.
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
 * 2020/9/28    anyant         Create the class
 * http://www.jimilab.com/
 */


package com.jimi.beanlife;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author anyant
 * @version 1.0
 * @ProjectName demo
 * @Description  探究Springboot的生命周期
 * @Date 2020/9/28 6:30 下午
 */
@Component
public class Person {

    private String name;
    private String age;

    public Person() {
        System.out.println("构造方法");
    }

    @PostConstruct
    public void  apple(){
        System.out.println("吃个apple");
    }
    @PreDestroy
    public void banana(){
        System.out.println("吃个banana");
    }
}
