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
 * 2020-04-27 10:45                  TanLianWang          Create the class
 * http://www.chinautech.com/
 */

package com.jimi.utils;

import org.apache.commons.codec.binary.Base64;

import java.nio.ByteBuffer;
import java.util.UUID;

public class token {

    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        long mostSignificantBits = uuid.getMostSignificantBits();
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[16]);
        byteBuffer.putLong(leastSignificantBits);
        byteBuffer.putLong(mostSignificantBits);
        String token = Base64.encodeBase64URLSafeString(byteBuffer.array());
        System.out.println(token);
    }
}
