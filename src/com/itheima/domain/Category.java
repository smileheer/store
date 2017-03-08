package com.itheima.domain;

import java.io.Serializable;

/**
 * 分类实体
 * Author: zhouhe
 * Email:  he.zhou@hpe.com
 * Date:   2017/3/3 14:53
 * Description:Created with IntelliJ IDEA
 */
public class Category implements Serializable{
    private String cid;
    private String cname;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
