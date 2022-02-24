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
 * 2019/3/22    Tanlianwang         Create the class
 * http://www.jimilab.com/
 */


package com.jimi.redis;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/3/22 18:27
 */
public class Test {

        public static void main(String args[]) throws IOException {
            String Str = new String("www.google.com");

            System.out.print("匹配成功返回值 :" );
            System.out.println(Str.replaceAll("(.*)g(.*)", "runoob" ));
            System.out.print("匹配失败返回值 :" );
            System.out.println(Str.replaceAll("(.*)q(.*)", "runoob" ));

            MyRedission myRedission = new MyRedission();
            RedissonClient redisson = myRedission.redisson();
            RLock lock = redisson.getLock("12");
            lock.lock();
            lock.unlock();
            Set set = new HashSet();

              for(int i = 0;i<2000;i++){
                  set.add(i);
              }

                System.out.println("Set集合大小为："+set.size());


        }
}

