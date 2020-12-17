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
 * 2020/12/17    anyant         Create the class
 * http://www.jimilab.com/
 */


package com.jimi.string;

/**
 * @author anyant
 * @version 1.0
 * @ProjectName demo
 * @Description
 * @Date 2020/12/17 下午11:34
 */
public class IsVaild {

    public static boolean isValid(String s) {
        final int j = s.length();
        if (j % 2 != 0) {
            return false;
        }

        for (int i = 0; i < j / 2; i++) {
            s = s.replace("()", "")
                    .replace("{}", "")
                    .replace("[]", "");
        }
        if (s.equals("")) {
            return true;
        } else {
            return false;
        }
    }
}
