package com.itheima.dao.impl;

import com.itheima.dao.CategoryDao;
import com.itheima.domain.Category;
import com.itheima.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * Author: zhouhe
 * Email:  he.zhou@hpe.com
 * Date:   2017/3/3 14:58
 * Description:Created with IntelliJ IDEA
 */
public class CategoryDaoImpl implements CategoryDao {
    @Override
    public List<Category> findAll() throws Exception {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from category";
        return qr.query(sql,new BeanListHandler<>(Category.class));
    }
}
