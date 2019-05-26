package com.sun.dao;

import com.sun.model.InfoFavRead;
import com.sun.model.InfoFavReadExample;
import com.sun.model.Information;
import com.sun.model.InformationExample;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
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
    public void insert(){
        Information i=new Information();
        i.setId(45);
        i.setUserId("孙狗蛋蛋蛋蛋大");
        mapper.insertSelective(i);
    }
    @Test
    public void selectByExampleWithUserAndTypeInfo() {
        InformationExample example = new InformationExample();
        InformationExample.Criteria criteria = example.createCriteria();
        long startTime = System.currentTimeMillis();
        List<Information> list = mapper.selectByExampleWithUserAndTypeInfo(example);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms"); //输出程序运行时间
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
        long startTime = System.currentTimeMillis();
        List<Information> list = mapper.selectByExampleOrderByViewAndTime(example);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms"); //输出程序运行时间

        System.out.println(list.size());
        for (Information i : list
        ) {
            System.out.println(i.getId());
//            System.out.println(i.getCount());
            System.out.println(i.getUser().getUsername());
            System.out.println(i.getTypeInfo().getName());
        }
    }

    @Test
    public void selectByPrimaryKeyWithUserAndTypeInfo() {
        long startTime1 = System.currentTimeMillis();
        long startTime = System.currentTimeMillis();
        Information information = mapper.selectByPrimaryKeyWithUserAndTypeInfo(4);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms"); //输出程序运行时间
        System.out.println(information.getUser().getUsername());
        System.out.println(information.getTypeInfo().getName());
    }

    @Test
    public void selectByUseridOrderByView() {
        List<Information> information=mapper.selectByUseridOrderByView("tianshengdagoudan");
        for (Information i :information
                ) {
            System.out.println(i.getId());
        }
    }

    @Test
    public void selectByUseridOrderByFav() {
        List<Information> information=mapper.selectByUseridOrderByFav("tianshengdagoudan");
        for (Information i :information
        ) {
            System.out.println(i.getId());
        }
    }
    @Test
    public void selectByTypeId() {
        InformationExample example = new InformationExample();
        InformationExample.Criteria criteria = example.createCriteria();
        criteria.andTypeIdEqualTo(7);
        List<Information> list = mapper.selectByExampleWithUserAndTypeInfo(example);
        System.out.println(list.size());
        for (Information i : list
        ) {
            System.out.println(i.getId());
        }
    }
}