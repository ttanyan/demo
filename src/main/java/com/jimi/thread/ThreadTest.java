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
 * 2019/12/24    anyant         Create the class
 * http://www.jimilab.com/
 */


package com.jimi.thread;

/**
 * @author anyant
 * @version 1.0
 * @ProjectName demo
 * @Description
 * @Date 2019/12/24 5:03 下午
 */
public class ThreadTest extends Thread {
    int i = 0;
    @Override
    public void run(){
        for(;i<100;i++){
            System.out.println(getName()+"  "+i);
        }
    }

    public static void main(String[] args) {
        for(int i = 0 ;i<100;i++){
//            System.out.println(Thread.currentThread().getName()+"  :"+i);
            if(i == 20 )
            {
                new ThreadTest().start();
                new ThreadTest().start();
            }

        }



    }
}
