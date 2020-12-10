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
 * 2020/12/10    anyant         Create the class
 * http://www.jimilab.com/
 */


package com.jimi.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author anyant
 * @version 1.0
 * @ProjectName demo
 * @Description
 * @Date 2020/12/10 下午1:13
 */
//@org.springframework.context.annotation.Configuration
@Component
public class Configuration {
    @Bean
    public Driver driver(){
        Driver driver = new Driver();
        driver.setId("1");
        driver.setName("driver");
        driver.setCar(car());
        return driver;
    }

    @Bean
    public Car car(){
        Car car = new Car();
        car.setId("1");
        car.setName("car");
        return car;
    }

}
