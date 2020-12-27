/*
 * COPYRIGHT. ShenZhen JiMi Technology Co., Ltd. 2020.
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
 * 2020/12/27    anyant         Create the class
 * http://www.jimilab.com/
 */


package com.jimi.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author anyant
 * @version 1.0
 * @ProjectName demo
 * @Description
 * @Date 2020/12/27 17:24
 */
public class FindMedianSorted {

    public static double findMedia(int[] nums1, int[] nums2){
        int[] sumNums;
        int size =  nums1.length+nums2.length;
        sumNums = Arrays.copyOf(nums1,size);
        //源数组，源数组起始位置，目标数组，目标数组其实位置，要复制的源素组数量
        System.arraycopy(nums2,0,sumNums,nums1.length,nums2.length);
      List<Integer> list =   Arrays.stream(sumNums).sorted().boxed().collect(Collectors.toList());
        int size1 = list.size();

        if(size1%2 == 0){
            return (list.get(size1 / 2) + list.get(size1 / 2 - 1)) / 2.0;

      }else{

            return list.get(list.size()/2);
        }

    }
    public static void main(String[] args) {
       int[] nums1 =  new int[]{1,2};
       int[] nums2 =  new int[]{3,4,5,6};
        System.out.println(findMedia(nums1,nums2));
//        System.out.println();
    }
}
