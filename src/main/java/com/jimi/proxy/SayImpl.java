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
 * 2019/1/25    Tanlianwang         Create the class
 * http://www.jimilab.com/
 */


package com.jimi.proxy;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/1/25 18:11
 */
public class SayImpl  implements  Say {
    @Override
    public void sayJimi(String word) {
        System.out.println("hello!"+word);

    }
}
