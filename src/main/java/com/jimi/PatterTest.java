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
 * 2019/4/19    Tanlianwang         Create the class
 * http://www.jimilab.com/
 */


package com.jimi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/4/19 11:12
 */
public class PatterTest {
    public static void main(String[] args) {
//        String regex = "^\\d{10}$";
        /**
         * *重复零次或更多次
         * +重复一次或更多次
         * ?重复零次或一次
         * {n}重复n次
         * {n,}重复n次或更多次
         * {n,m}重复n到m次
         */
        String regex = "^[1-9]([0-9]){9}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("2015132114");
        boolean isMatch = matcher.matches();
        System.out.println(isMatch);
    }
}
