package com.itheima.web.servlet;

import com.itheima.domain.Category;
import com.itheima.domain.Product;
import com.itheima.service.CategoryService;
import com.itheima.service.ProductService;
import com.itheima.service.impl.CategoryServiceImpl;
import com.itheima.service.impl.ProductServiceImpl;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Author: zhouhe
 * Email:  he.zhou@hpe.com
 * Date:   2017/2/22 17:25
 * Description:Created with IntelliJ IDEA
 * 和首页相关的servlet
 */
@WebServlet(name = "IndexServlet",urlPatterns = "/index")
public class IndexServlet extends BaseServlet {
    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //去数据库中查询最新商品和热门商品，将他们放入request域中请求转发
        ProductService ps=new ProductServiceImpl();
        //最新商品
        List<Product> newList=ps.findNew();
        //热门商品
        List<Product> hotList=ps.findHot();
        //将两个list放入域中
        request.setAttribute("nList",newList);
        request.setAttribute("hList",hotList);
        return "/jsp/index.jsp";
    }

}
