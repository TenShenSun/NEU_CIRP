package com.sun.dao;

import com.sun.model.Information;
import com.sun.model.InformationExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.GenericXmlContextLoader;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"}, loader = GenericXmlContextLoader.class)
public class InformationMapperTest {
    @Autowired
    InformationMapper informationMapper;

    @Test
    public void selectByExampleWithUserType() {
        InformationExample informationExample=new InformationExample();
        InformationExample.Criteria criteria=informationExample.createCriteria();
        criteria.andContentIsNotNull();
        List<Information> list=informationMapper.selectByExampleWithUserType(informationExample);
        for (Information information:list
             ) {
            System.out.println(information.getId());
            System.out.println(information.getContent());
        }
    }

    @Test
    public void selectByPrimaryKeyWithUserType() {
        /*Information information=informationMapper.selectByPrimaryKeyWithUserType(4);
        System.out.println(information.getId());
        System.out.println(information.getUserId());
        System.out.println(information.getTypeId());
        System.out.println(information.getLocation());
        System.out.println(information.getTopic());
        System.out.println(information.getContent());
        System.out.println(information.getUser().getUsername());
        System.out.println(information.getUser().getOrgName());
        System.out.println(information.getTypeInfo().getName());*/
    }
}