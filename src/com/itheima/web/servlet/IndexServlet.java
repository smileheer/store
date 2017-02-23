package com.itheima.web.servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author: zhouhe
 * Email:  he.zhou@hpe.com
 * Date:   2017/2/22 17:25
 * Description:Created with IntelliJ IDEA
 * 和首页相关的servlet
 */
@WebServlet(name = "IndexServlet",urlPatterns = "/index")
public class IndexServlet extends BaseServlet {
    public String index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //去数据库中查询最新商品和热门商品，将他们放入request域中请求转发
        return "/jsp/index.jsp";
    }

}
