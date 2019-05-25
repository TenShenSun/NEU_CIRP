package com.sun.service;


import com.sun.model.User;
import com.sun.model.UserExample;

import java.util.List;

public interface UserService {
    public int postUser(User user);

    public User getUserById(String id);

    public List<User> getUsersByCondition(UserExample example,int pageNum,int pageSize);

    public int putUser(User user);

    public int deleteUser(String id);

}
