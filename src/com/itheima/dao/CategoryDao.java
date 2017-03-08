package com.itheima.dao;

import com.itheima.domain.Category;

import java.util.List;

/**
 * Author: zhouhe
 * Email:  he.zhou@hpe.com
 * Date:   2017/3/3 14:57
 * Description:Created with IntelliJ IDEA
 */
public interface CategoryDao {
    List<Category> findAll() throws Exception;
}
