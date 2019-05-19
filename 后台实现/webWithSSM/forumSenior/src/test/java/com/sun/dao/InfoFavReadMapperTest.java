package com.sun.dao;

import com.sun.model.InfoFavRead;
import com.sun.model.InfoFavReadExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class InfoFavReadMapperTest {
    @Autowired
    InfoFavReadMapper mapper;

    @Test
    public void selectByExampleWithUserAndInformation() {
        InfoFavReadExample example=new InfoFavReadExample();
        InfoFavReadExample.Criteria criteria=example.createCriteria();
        criteria.andInfoIdEqualTo(2);
        List<InfoFavRead> infoFavReadList=mapper.selectByExampleWithUserAndInformation(example);
        for (InfoFavRead i:infoFavReadList
             ) {
            System.out.println("next line");
            System.out.println(i.getUserId());
            System.out.println(i.getInfoId());
            System.out.println(i.getIsFav());
            System.out.println(i.getIsRead());
            System.out.println(i.getUser().getUsername());
            System.out.println(i.getInformation().getTopic());
        }
    }

    @Test
    public void selectByPrimaryKeyWithUserAndInformation() {
        InfoFavRead infoFavRead=mapper.selectByPrimaryKeyWithUserAndInformation("tianshengdagoudan111",2);
        System.out.println(infoFavRead.getUser().getUsername());
        System.out.println(infoFavRead.getInformation().getTopic());
    }
}