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
 * 2019/10/21    TanLianWang        Create the class
 * http://www.jimilab.com/
 */


package com.jimi.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TanLianWang
 * @version 1.0
 * @ProjectName demo
 * @Description
 * @Date 2019/10/21 18:09
 */
public class String2String {

    public static void main(String[] args) {
        String imei1 = "11,22";
        String imei2 = "33,44";
        String imei = imei2+","+imei1;
        System.out.println(imei);
        List<String> list = new ArrayList<>();
        System.out.println(list.size());
        System.out.println("===========================================");
        String s="{[]}";
        System.out.println(IsVaild.isValid(s));
    }

}
