package com.ys.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ys.dao.IUserDao;
import com.ys.model.*;
import com.ys.service.UserService;


@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {
    //自动注入iuserdao 用于访问数据库
    @Autowired
    IUserDao Mapper;

    public boolean login(String username, String password) {

        User user = Mapper.queryUserByName(username);

        if (user != null) {

            if (user.getUsername().equals(username) && user.getPassword().equals(password))
                return true;

        }
        return false;

    }
    //注册
    public boolean Register(String username,String password) {
    		Mapper.insertUser(username, password);
    		User user=Mapper.queryUserByName(username);
    		System.out.println(user.getUsername()+"   is registered");
    		if(user!=null) {
    			return true;
    		}else {
    			return false;
    		}
    }
    


	
}