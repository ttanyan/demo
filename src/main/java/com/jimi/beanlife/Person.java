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
        System.out.println("Bean的生命周期-----我是Bean的构造方法");
    }

    /**
     * 被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器执行一次。PostConstruct在构造函数之后执行，init（）方法之前执行。
     * PreDestroy（）方法在destroy（）方法知性之后执行
     *
     */
    @PostConstruct
    public void  apple(){
        System.out.println("Bean的生命周期-----我是@PostConstruct注解的方法");
    }
    @PreDestroy
    public void banana(){
        System.out.println("容器销毁之前执行-----我是@PreDestroy注解的方法");
    }
}
