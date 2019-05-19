package com.sun.dao;

import com.sun.model.InfoFavRead;
import com.sun.model.InfoFavReadExample;
import com.sun.model.Information;
import com.sun.model.InformationExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class InformationMapperTest {
    @Autowired
    InformationMapper mapper;

    @Test
    public void selectByExampleWithUserAndTypeInfo() {
        InformationExample example = new InformationExample();
        InformationExample.Criteria criteria = example.createCriteria();
        List<Information> list = mapper.selectByExampleWithUserAndTypeInfo(example);
    }

    @Test
    public void selectByExampleOrderByTime() {
        InformationExample example = new InformationExample();
        InformationExample.Criteria criteria = example.createCriteria();
        List<Information> list = mapper.selectByExampleOrderByTime(example);
        for (Information i : list
        ) {
            System.out.println("===============");
            System.out.println(i.getId());
            System.out.println(i.getCreatedate());
        }
    }


    @Test
    public void selectByExampleOrderByViewAndTime() {
        InformationExample example = new InformationExample();
        InformationExample.Criteria criteria = example.createCriteria();
        List<Information> list = mapper.selectByExampleOrderByViewAndTime(example);
        System.out.println(list.size());
        for (Information i : list
        ) {
            System.out.println(i.getId());
            System.out.println(i.getCount());
            System.out.println(i.getUser().getUsername());
            System.out.println(i.getTypeInfo().getName());
        }
    }

    @Test
    public void selectByPrimaryKeyWithUserAndTypeInfo() {
        Information information = mapper.selectByPrimaryKeyWithUserAndTypeInfo(4);
        System.out.println(information.getUser().getUsername());
        System.out.println(information.getTypeInfo().getName());
    }
}