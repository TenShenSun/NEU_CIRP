package com.sun.service.impl;


import com.sun.dao.UserMapper;
import com.sun.model.User;
import com.sun.model.UserExample;
import com.sun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int postUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public User getUserById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> getUsersByCondition(UserExample example) {
        return userMapper.selectByExample(example);
    }

    @Override
    public int putUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int deleteUser(String id) {
        return userMapper.deleteByPrimaryKey(id);
    }
}
