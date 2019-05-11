package com.sun.dao;

import com.sun.model.User;
import com.sun.model.UserExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.GenericXmlContextLoader;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"}, loader = GenericXmlContextLoader.class)
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void countByExample() {
        UserExample example = new UserExample();
        UserExample.Criteria criteria=example.createCriteria();
        criteria.andUsernameEqualTo("张三");
        int count=userMapper.countByExample(example);
        System.out.println(count);
    }

    @Test
    public void deleteByExample() {

    }

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
        userMapper.insert(new User("wxid_fortest_insert", "username_test_insert"));
    }

    @Test
    public void insertSelective() {
        userMapper.insert(new User("wxid_fortest_insertSelective", "username_test_insertSelective"));
    }

    @Test
    public void selectByExample() {
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void updateByExampleSelective() {
    }

    @Test
    public void updateByExample() {
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }
}
