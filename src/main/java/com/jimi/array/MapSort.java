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
 * 2019/12/27    anyant         Create the class
 * http://www.jimilab.com/
 */


package com.jimi.array;

import java.lang.reflect.Array;
import java.util.HashMap;

/**
 * @author anyant
 * @version 1.0
 * @ProjectName demo
 * @Description
 * @Date 2019/12/27 1:29 上午
 */
public class MapSort {
    public static int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for(int i=0;i<array.length;i++) {
            int a = array[i];
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            }else{
                map.put(a, 1);
            }
        }
        if (map.get(k) != null) {
            result = map.get(k);
        }
        return result;
    }

    public static void main(String[] args) {
       int array[] = new int[]{1,1,2,2,3,3,4,4,4};
        System.out.println(GetNumberOfK(array,4));
    }

}
