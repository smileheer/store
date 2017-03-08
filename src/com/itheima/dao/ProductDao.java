package com.itheima.dao;

import com.itheima.domain.Product;

import java.util.List;

/**
 * Author: zhouhe
 * Email:  he.zhou@hpe.com
 * Date:   2017/3/6 13:34
 * Description:Created with IntelliJ IDEA
 */
public interface ProductDao {
    List<Product> findNew() throws Exception;

    List<Product> findHot() throws Exception;

    Product getByPid(String pid) throws Exception;

    List<Product> findByPage(int currPage, int pageSize, String cid) throws Exception;

    int getTotoalCount(String cid) throws Exception;
}
