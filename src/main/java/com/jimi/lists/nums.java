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
 * 2020/12/21    anyant         Create the class
 * http://www.jimilab.com/
 */


package com.jimi.lists;

import java.util.ArrayList;

/**
 * @author anyant
 * @version 1.0
 * @ProjectName demo
 * @Description
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * @Date 2020/12/21 上午12:56
 */
public class nums {
   private static ArrayList targets = new ArrayList();
     static void twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    targets.add(i);
                    targets.add(j);
                    break;
                }
            }
        }
    }

    public static void main(String[] args){
        int[] nums12 = {1,7,2,15};
        twoSum(nums12,9);
        for (int i = 0; i < targets.size(); i++) {
            System.out.println(targets.get(i));
        }
    }

}
