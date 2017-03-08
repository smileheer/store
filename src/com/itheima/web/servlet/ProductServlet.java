package com.itheima.web.servlet;

import com.itheima.domain.PageBean;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import com.itheima.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author: zhouhe
 * Email:  he.zhou@hpe.com
 * Date:   2017/3/6 17:05
 * Description:Created with IntelliJ IDEA
 */

/**
 * 商品模块
 */
@WebServlet(name = "ProductServlet", urlPatterns = "")
public class ProductServlet extends BaseServlet {
    /**
     * 通过id查询单个商品详情
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected String getById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取商品的id
        String pid = request.getParameter("pid");
        //调用Service
        ProductService ps = new ProductServiceImpl();
        Product p = ps.getById(pid);
        //将结果放入request中请求转发
        request.setAttribute("bean", p);
        return "/jsp/product_info.jsp";
    }

    /**
     * 分页查询数据
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    protected String findByPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //获取类别、当前页、设置pageSize
        String cid = request.getParameter("cid");
        int currPage = Integer.parseInt(request.getParameter("currPage"));
        int pageSize = 12;

        //调用Service 返回值pageBean
        ProductService ps = new ProductServiceImpl();
        PageBean<Product> bean = ps.findByPage(currPage, pageSize, cid);
        //结果放入request中请求转发
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
