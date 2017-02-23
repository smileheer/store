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
 * Date:   2017/2/22 16:43
 * Description:Created with IntelliJ IDEA
 * 和用户相关的servlet
 */
@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends BaseServlet {

    public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("UserServlet的add方法执行了");
        return null;
    }
}
