/*
 * COPYRIGHT. AnyanT tanlianwang@qq.com
 * ALL RIGHTS RESERVED
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording,
 * or otherwise, without the prior written permission of AnyanT.
 * Amendment History:
 * Amendment History:
 *
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * 2021/8/5                 anyant           Create the class
 * https://blog.csdn.net/tingfengqianqu
 */


package com.jimi.thread;

/**
 * @author anyant
 * @version 1.0
 * @Description
 * @Date 2021/8/5 23:21
 */
public class MyRunnable implements Runnable{

    private int i;


    @Override
    public void run() {
        System.out.println(System.currentTimeMillis()+i);
    }
    public MyRunnable(int s){
        this.i=s;

    }

}
