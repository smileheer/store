package com.itheima.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Author: zhouhe
 * Email:  he.zhou@hpe.com
 * Date:   2017/2/22 15:48
 * Description:Created with IntelliJ IDEA
 */
@WebServlet(name = "BaseServlet")
public class BaseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
//        获取子类
            Class clazz = this.getClass();
//            System.out.println(this);
//        获取请求方法
            String m = request.getParameter("method");
            if (m == null) {
                m = "index";
            }
//            System.out.println(m);
//        获取方法对象

            Method method = clazz.getMethod(m, HttpServletRequest.class, HttpServletResponse.class);
//            让方法执行
            String s = (String) method.invoke(this, request, response);
//            判断s是否为空
            if (s != null) {
                request.getRequestDispatcher(s).forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public String index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    return null;
    }

}
