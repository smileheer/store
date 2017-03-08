package com.itheima.service;

import com.itheima.domain.Category;

import java.util.List;

/**
 * Author: zhouhe
 * Email:  he.zhou@hpe.com
 * Date:   2017/3/3 14:55
 * Description:Created with IntelliJ IDEA
 */
public interface CategoryService{
    List<Category> findAll() throws Exception;
}
