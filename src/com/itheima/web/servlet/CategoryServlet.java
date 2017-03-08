package com.itheima.web.servlet;

import com.itheima.domain.Category;
import com.itheima.service.CategoryService;
import com.itheima.service.impl.CategoryServiceImpl;
import com.itheima.utils.JsonUtil;

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
 * Date:   2017/3/3 16:01
 * Description:Created with IntelliJ IDEA
 */
@WebServlet(name = "CategoryServlet",urlPatterns = "/category")
public class CategoryServlet extends BaseServlet {
    /**
     * 查询所有的分类
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public String findAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //调用CategoryService查询所有的分类，返回值list
        CategoryService cs=new CategoryServiceImpl();
        List<Category> clist= cs.findAll();
        //将返回值转为json格式返回到页面上
//        request.setAttribute("clist",clist);
        String json = JsonUtil.list2json(clist);
        //写回页面
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().println(json);
        return null;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
