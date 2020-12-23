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
 * 2020/12/22    anyant         Create the class
 * http://www.jimilab.com/
 */


package com.jimi.nacoscontorller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author anyant
 * @version 1.0
 * @ProjectName demo
 * @Description
 * @Date 2020/12/22 下午11:43
 */
@Slf4j
@Controller
@RequestMapping("/config")
public class ConfigController {
    @NacosValue(value = "${useLocalCache:true}", autoRefreshed = true)
    private boolean useLocalCache;

    @RequestMapping(value = "/get", method = GET)
    @ResponseBody
    public boolean get() {
        log.info("NaCosConfigValue:"+useLocalCache);
        return useLocalCache;
    }
}
