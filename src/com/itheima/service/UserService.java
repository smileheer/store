package com.itheima.service;

import com.itheima.domain.User;

/**
 * Author: zhouhe
 * Email:  he.zhou@hpe.com
 * Date:   2017/2/22 13:03
 * Description:Created with IntelliJ IDEA
 */
public interface UserService {
    void regist(User user) throws Exception;

    User active(String code) throws Exception;

    User login(String username, String password) throws Exception;
}
