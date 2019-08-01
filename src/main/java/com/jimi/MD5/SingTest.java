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
 * 2019/7/23    TanLianWang        Create the class
 * http://www.jimilab.com/
 */


package com.jimi.MD5;

import java.util.*;

/**
 * @author TanLianWang
 * @version 1.0
 * @ProjectName demo
 * @Description
 * @Date 2019/7/23 16:58
 */
public class SingTest {
    public static String putPairsSequenceAndTogether(Map<String, String> info) {
        List<Map.Entry<String, String>> infoIds = new ArrayList<Map.Entry<String, String>>(info.entrySet());
        Collections.sort(infoIds, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> arg0, Map.Entry<String, String> arg1) {
                return (arg0.getKey()).compareTo(arg1.getKey());
            }
        });
        String ret = "";
        for (Map.Entry<String, String> entry : infoIds) {
            ret += entry.getKey();
            ret += "=";
            ret += entry.getValue();
            ret += "&";
        }
        ret = ret.substring(0, ret.length() - 1);
        return ret;
    }
    public static void main(String[] args) {


    }
}
