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
 * 2019/4/14    Tanlianwang         Create the class
 * http://www.jimilab.com/
 */


package com.jimi.string;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/4/14 15:06
 */
public class StringLength {
    public static void main(String[] args) {
        String name = "2015132114";
        System.out.println(name.trim().length());


        Set sets = new HashSet();
        Number b = new Number();

        b.setA(1);
        b.setB(2);
        sets.add(b);
        Iterator it = sets.iterator();
        while (it.hasNext()) {
            Number str = (Number)it.next();
            System.out.println(str.getA());
        }

    }
}
