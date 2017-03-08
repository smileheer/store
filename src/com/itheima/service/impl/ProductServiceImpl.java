package com.itheima.service.impl;

import com.itheima.dao.ProductDao;
import com.itheima.dao.impl.ProductDaoImpl;
import com.itheima.domain.PageBean;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;

import java.util.List;

/**
 * Author: zhouhe
 * Email:  he.zhou@hpe.com
 * Date:   2017/3/6 13:33
 * Description:Created with IntelliJ IDEA
 */
public class ProductServiceImpl implements ProductService {
    /**
     * 查询最新
     * @return
     * @throws Exception
     */
    @Override
    public List<Product> findNew() throws Exception {
        ProductDaoImpl pdao = new ProductDaoImpl();
        return pdao.findNew();
    }

    /**
     * 查询热门
     * @return
     * @throws Exception
     */
    @Override
    public List<Product> findHot() throws Exception {
        ProductDaoImpl pdao = new ProductDaoImpl();
        return pdao.findHot();
    }

    /**
     * 查询单个商品
     * @param pid
     * @return
     * @throws Exception
     */
    @Override
    public Product getById(String pid) throws Exception {
        ProductDao pdao=new ProductDaoImpl();
        return pdao.getByPid(pid);
    }

    /**
     * 按类别分页查询商品
     * @param currPage
     * @param pageSize
     * @param cid
     * @return
     * @throws Exception
     */
    @Override
    public PageBean<Product> findByPage(int currPage, int pageSize, String cid) throws Exception {
        ProductDaoImpl pDao = new ProductDaoImpl();
        //当前页数据
        List<Product> list=pDao.findByPage(currPage,pageSize,cid);
        // 总条数
        int totalCount=pDao.getTotoalCount(cid);
       new PageBean(new List<>, Integer currPage, Integer pageSize, Integer totalCount);
        return null;
    }


}
