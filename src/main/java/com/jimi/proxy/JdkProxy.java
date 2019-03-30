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

import java.lang.reflect.Proxy;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/1/25 18:10
 */
public class JdkProxy {
    public static void main(String[] args) {
        TestInvocationHandler testInvocationHandler = new TestInvocationHandler(new SayImpl());
        Say say = (Say) Proxy.newProxyInstance(SayImpl.class.getClassLoader(),SayImpl.class.getInterfaces(),testInvocationHandler);
        say.sayJimi("几米");

    }
}
