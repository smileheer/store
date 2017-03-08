package com.itheima.dao.impl;

import com.itheima.dao.ProductDao;
import com.itheima.domain.Product;
import com.itheima.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;

/**
 * Author: zhouhe
 * Email:  he.zhou@hpe.com
 * Date:   2017/3/6 13:34
 * Description:Created with IntelliJ IDEA
 */
public class ProductDaoImpl implements ProductDao {
    /**
     * 查询最新
     * @return
     * @throws Exception
     */
    @Override
    public List<Product> findNew() throws Exception {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from product order by pdate limit 9";
        return qr.query(sql,new BeanListHandler<>(Product.class));
    }

    /**
     * 查询热门
     * @return
     * @throws Exception
     */
    @Override
    public List<Product> findHot() throws Exception {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from product where is_hot=1 order by pdate limit 9";
        return qr.query(sql,new BeanListHandler<>(Product.class));
    }

    /**
     * 通过商品id获取商品详情
     * @param pid
     * @return
     * @throws Exception
     */
    @Override
    public Product getByPid(String pid) throws Exception {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from product where pid =?";
        return qr.query(sql,new BeanHandler<>(Product.class),pid);
    }

    @Override
    public List<Product> findByPage(int currPage, int pageSize, String cid) throws Exception {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from product where cid=? limit ?,?";
        return qr.query(sql,new BeanListHandler<>(Product.class),cid,(currPage-1)*pageSize,currPage*pageSize);
    }

    @Override
    public int getTotoalCount(String cid) throws Exception {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select count(*) from product where cid=？";
        return ((Long)qr.query(sql,new ScalarHandler(),cid)).intValue();
    }
}
