package com.sun.dao;

import com.sun.model.Behavior;
import com.sun.model.BehaviorExample;
import com.sun.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class BehaviorMapperTest {
    @Autowired
    BehaviorMapper mapper;

    @Test
    public void selectByExample() {
        System.out.println(0);
        BehaviorExample example = new BehaviorExample();
        BehaviorExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo("wxid_00000002");
        List<Behavior> behaviorList = mapper.selectByExample(example);
        for (Behavior b : behaviorList
        ) {
            System.out.println(b.getUserId());
            System.out.println(b.getTimestamp());
            System.out.println(b.getBehavior());
        }
    }

    @Test
    public void selectByExampleWithUser() {
        System.out.println(0);
        BehaviorExample example = new BehaviorExample();
        BehaviorExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo("wxid_00000002");
        List<Behavior> behaviorList = mapper.selectByExampleWithUser(example);
        for (Behavior b : behaviorList
        ) {
            System.out.println(b.getUserId());
            System.out.println(b.getTimestamp());
            System.out.println(b.getBehavior());
            System.out.println(b.getUser().getUsername());
        }
    }

    @Test
    public void selectByPrimaryKey() throws ParseException {
//        System.out.println(new Date("2019-05-14 21:48:24"));
        String string = "2019-05-14 21:48:24";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.parse(string));
        Behavior behavior = mapper.selectByPrimaryKey("wxid_00000002", sdf.parse(string));
    }

    @Test
    public void selectByPrimaryKeyWithUser() throws Exception {
        String string = "2019-05-14 21:48:24";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.parse(string));
        Behavior behavior = mapper.selectByPrimaryKeyWithUser("wxid_00000002", sdf.parse(string));
        System.out.println(behavior.getUser().getUsername());
    }

    @Test
    public void insertSelective() throws Exception{
        Behavior behavior=new Behavior();
        behavior.setUserId("123456789");
        behavior.setTimestamp(new Timestamp(new Date().getTime()));
        behavior.setBehavior("qwerty");
        mapper.insertSelective(behavior);
    }
}