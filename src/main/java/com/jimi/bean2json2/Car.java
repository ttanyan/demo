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
 * 2019/1/18    Tanlianwang         Create the class
 * http://www.jimilab.com/
 */


package com.jimi.bean2json2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/1/18 16:38
 */
public class Car {
    private String  name;
    private String type;
    private Integer number;
    private List<Person> person = new ArrayList<Person>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List getPerson() {
        return person;
    }

    public void setPerson(List person) {
        this.person = person;
    }

    public Car(String name, String type, Integer number, List person) {
        this.name = name;
        this.type = type;
        this.number = number;
        this.person = person;
    }
}
