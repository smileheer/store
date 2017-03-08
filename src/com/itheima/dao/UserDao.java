package com.itheima.dao;

import com.itheima.domain.User;

import java.sql.SQLException;

/**
 * Author: zhouhe
 * Email:  he.zhou@hpe.com
 * Date:   2017/2/22 13:05
 * Description:Created with IntelliJ IDEA
 */
public interface UserDao {
    void add(User user) throws Exception;


    void update(User user) throws Exception;

    User getByCode(String code) throws SQLException;


    User getByUsernameAndPwd(String username, String password) throws SQLException;
}
