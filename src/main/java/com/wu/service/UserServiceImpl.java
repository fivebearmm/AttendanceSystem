package com.wu.service;

import com.wu.mapper.UserMapper;
import com.wu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> queryUserList() {

        List<User> users = userMapper.queryUserList();
        return users;
    }
}
