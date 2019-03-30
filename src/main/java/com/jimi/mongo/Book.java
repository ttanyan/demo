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
 * 2019/1/28    Tanlianwang         Create the class
 * http://www.jimilab.com/
 */


package com.jimi.mongo;

import java.io.Serializable;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/1/28 14:13
 */
public class Book implements Serializable {

    private static final long serialVersionUID = 3792078319011094046L;
    private String title;
    private String description;
    private String by;
    private String url;
    private String likes;

    public Book() {
    }

    public Book(String title, String description, String by, String url, String likes) {
        this.title = title;
        this.description = description;
        this.by = by;
        this.url = url;
        this.likes = likes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }
}
