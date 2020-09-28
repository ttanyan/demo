/*
 * COPYRIGHT. ChongQing UTECH Technology Co., Ltd. 2020.
 * ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording,
 * or otherwise, without the prior written permission of ChongQing UTECH Network Technology Co., Ltd.
 *
 * Amendment History:
 *
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * 2020-04-29 13:37                  TanLianWang          Create the class
 * http://www.chinautech.com/
 */

package com.jimi.utils;

import java.util.*;

/**
 * 
 * @author TanLianWang 
 * @version 1.0 
 * @date 2020/4/29 13:38
 */
public class getSetListHashSetValue {

    public static class Stu{
        private String id;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    public static void main(String[] args) {

            Map<String,String> map= new HashMap<>();
            map.forEach((k,v)->{
                // 打印键
                System.out.println(k);
                // 打印值
                System.out.println(v);
            });

            List<Stu> list = new ArrayList();
            list.forEach((l)->{
                System.out.println(l.getId());
                System.out.println(l.getName());
            });

            Set<Stu> set = new HashSet<>();
            set.forEach((s)->{
                System.out.println(s.getId());
                System.out.println(s.getName());
            });
        }


}
