package com.itheima.domain;

import java.util.List;

/**
 * Author: zhouhe
 * Email:  he.zhou@hpe.com
 * Date:   2017/3/7 18:33
 * Description:Created with IntelliJ IDEA
 */
public class PageBean<P> {
    private List list;
    private Integer currPage;
    private Integer pageSize;
    private Integer totalPage;
    private Integer totalCount;

    public PageBean() {
    }

    public PageBean(List list, Integer currPage, Integer pageSize, Integer totalCount) {
        super();
        this.list = list;
        this.currPage = currPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
    }


    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Integer getCurrPage() {
        return currPage;
    }

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getTotalPage() {
        return (int) Math.ceil(totalCount * 1.0 / pageSize);
    }


    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}
