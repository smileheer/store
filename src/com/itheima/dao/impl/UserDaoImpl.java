package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * Author: zhouhe
 * Email:  he.zhou@hpe.com
 * Date:   2017/2/22 13:06
 * Description:Created with IntelliJ IDEA
 */
public class UserDaoImpl implements UserDao {
    /**
     * 用户注册
     * @param user
     */
    @Override
    public void add(User user) throws SQLException {
        QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
    String sql="insert into user value(?,?,?,?,?,?,?,?,?,?)";
        qr.update(sql,user.getUid(),user.getUsername(),user.getPassword(),user.getName(),
                user.getEmail(),user.getTelephone(),user.getBirthday(),
                user.getSex(),user.getState(),user.getCode());
    }

    /**
     * 修改用户
     * @param user
     * @throws Exception
     */
    @Override
    public void update(User user) throws Exception {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql="update user set username=?,password=?,name=?,birthday=?,email=?,state=?,code=? where uid=?";
        qr.update(sql,user.getUsername(),user.getPassword(),user.getName(),user.getBirthday(),user.getEmail(),user.getState(),user.getCode(),user.getUid());

    }

    /**
     * 通过激活码获取一个用户
     * @param code
     * @return
     * @throws SQLException
     */
    @Override
    public User getByCode(String code) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from user where code=? limit 1";
        return qr.query(sql,new BeanHandler<>(User.class),code);
    }

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     * @throws SQLException
     */
    @Override
    public User getByUsernameAndPwd(String username, String password) throws SQLException {
        QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from user where username=? and password=? limit 1";
        return qr.query(sql,new BeanHandler<>(User.class),username,password);
    }
}
