package com.itheima.web.servlet;

import com.itheima.constant.Constant;
import com.itheima.domain.User;
import com.itheima.myconventer.MyConverter;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import com.itheima.utils.MD5Utils;
import com.itheima.utils.UUIDUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

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

    /**
     * 跳转到注册页面
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String registUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("UserServlet的add方法执行了");
        return "/jsp/register.jsp";
    }

    /**
     * 跳转到登录页面
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String loginUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("UserServlet的add方法执行了");
        return "/jsp/login.jsp";
    }

    public String logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //干掉session
        request.getSession().invalidate();
        //重定向
        response.sendRedirect(request.getContextPath());
        //处理自动登录
        return null;
    }

    /**
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //调用service完成登录操作、返回user
        UserService s = new UserServiceImpl();
        User user = s.login(username, password);
        //判断用户
        if (user == null) {
            //用户名密码匹配
            request.setAttribute("msg", "用户名密码不匹配");
//            request.getRequestDispatcher("/jsp/login.jsp").forward(request,response);
            return "/jsp/login.jsp";
        } else {
            //继续判断用户的状态是否激活
            if (Constant.USER_IS_ACTIVE == user.getState()) {
                request.setAttribute("msg", "用户未激活");
                return "/jsp/login.jsp";
            }
        }

        //将user放入session中重定向
        request.getSession().setAttribute("user", user);
        response.sendRedirect(request.getContextPath() + "/");//store
        return null;
    }

    /**
     * 用户注册
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String regist(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //封装数据
        User user = new User();
        ConvertUtils.register(new MyConverter(), Date.class);
        BeanUtils.populate(user, request.getParameterMap());
        //设置用户id
        user.setUid(UUIDUtils.getId());
        //设置激活码
        user.setCode(UUIDUtils.getCode());
        //加密密码
        user.setPassword(MD5Utils.md5(user.getPassword()));
        //调用service完成注册
        UserService s = new UserServiceImpl();
        s.regist(user);
        //页面请求转发
        request.setAttribute("msg", "用户注册已成功，请去邮箱激活");

        return "/jsp/msg.jsp";
    }

    /**
     * 用户激活     *
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public String active(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取激活码
        String code = request.getParameter("code");
        //调用service完成激活
        UserService s = new UserServiceImpl();
        User user = s.active(code);
        if (user == null) {
            //通过激活码没有找到用户
            request.setAttribute("msg", "请重新激活");
        } else {
            request.setAttribute("msg", "激活成功");
        }

        return "/jsp/msg.jsp";
    }
}
