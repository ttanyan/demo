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
 * 2019/1/25    Tanlianwang         Create the class
 * http://www.jimilab.com/
 */


package com.jimi.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/1/25 18:12
 */
public class TestInvocationHandler implements InvocationHandler {
    private Object target;
    public TestInvocationHandler(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke begin");
        System.out.println("method :" + method.getName()+"：is invoke");
        method.invoke(target,args);
        System.out.println("invoke end"+"------------");
        return null;
    }
}
