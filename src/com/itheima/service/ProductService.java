package com.itheima.service;

import com.itheima.domain.PageBean;
import com.itheima.domain.Product;

import java.util.List;

/**
 * Author: zhouhe
 * Email:  he.zhou@hpe.com
 * Date:   2017/3/6 13:33
 * Description:Created with IntelliJ IDEA
 */
public interface ProductService {
    List<Product> findNew() throws Exception;

    List<Product> findHot() throws Exception;

    Product getById(String pid) throws Exception;

    PageBean<Product> findByPage(int currPage, int pageSize, String cid) throws Exception;
}
