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
 * 2020/12/30                 anyant           Create the class
 * https://blog.csdn.net/tingfengqianqu
 */


package com.jimi.leetcode;

import java.util.Arrays;

/**
 * @author anyant
 * @version 1.0
 * @ProjectName demo
 * @Description
 * @Date 2020/12/30 23:14
 */
public class MaxAreaSolution {

    public static int maxArea(int[] height) {
        int nums = height.length;
        int maxIndex = 0;
        /**
         * 先找到最大值及其下标
         * 找到离这个最大值得距离以及权重
         */
//        //找到最大值
//        int max = Arrays.stream(height).summaryStatistics().getMax();
//
//        //找到最大值的下标
//        for (int i = 0; i < nums; i++) {
//            if(height[i] == max){
//                //找到第一个最大数的下标
//                maxIndex = i;
//                 break;
//            }
//        }
//    //忘记考虑长宽的差异
//        //找到左边乘积最大的
//        int leftMax = 0;
//        for (int j = 0; j < maxIndex; j++) {
//            if (height[j]*(maxIndex-j) > leftMax){
//                leftMax = height[j]*(maxIndex-j);
//            }
//        }
//        //找到右边乘积最大的
//        int rightMax = 0;
//        for (int k = maxIndex+1; k < nums; k++) {
//            if (height[k]*(k-maxIndex) > rightMax){
//                rightMax = height[k]*(k-maxIndex);
//            }
//        }

        //整体情况
        int sums = 0;
        for (int l = 0; l < nums; l++) {
            for(int r = nums-1;r>l;r--){
                int min = Math.min(height[l], height[r]);
                int sda = min * (r-l);
                sums  = Math.max(sums, sda);
            }
        }
        return sums;
//        return Math.max(sums,Math.max(leftMax, rightMax));
    }

    public static void main(String[] args) {
        int[] hello = new int[]{1,8,6,2,5,4,8,3,7};
        int[] test = new int[]{1,2,1};
        System.out.println(maxArea(test));
    }
}
