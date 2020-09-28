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
 * 2019/9/4    TanLianWang        Create the class
 * http://www.jimilab.com/
 */


package com.jimi.utils;

import java.util.Random;

/**
 * @author TanLianWang
 * @version 1.0
 * @ProjectName demo
 * @Description
 * @Date 2019/9/4 18:28
 */
public class AuthCode {
    public static String getCaptcha() {
        Random random = new Random();
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            ret.append(random.nextInt(10));
        }
        return ret.toString();
    }

    public static String getCode(){
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder(4);
        for ( int i = 0; i < 4; i++) {
            char ch = str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);
        }
       return sb.toString();
    }


    public static void main(String[] args) {
        for(int i=0;i<1000;i++){
            System.out.println(getCaptcha());
        }
//        for(int i=0;i<6;i++) {
//            System.out.println(getCode());
//        }

    }
}
