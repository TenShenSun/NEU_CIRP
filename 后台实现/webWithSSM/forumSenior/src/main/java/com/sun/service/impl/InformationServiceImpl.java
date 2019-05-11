package com.sun.service.impl;

import com.sun.dao.InformationMapper;
import com.sun.model.Information;
import com.sun.model.InformationExample;
import com.sun.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationServiceImpl implements InformationService {
    @Autowired
    private InformationMapper informationMapper;

    @Override
    public int postInformation(Information information) {
        return informationMapper.insertSelective(information);
    }

    @Override
    public Information getInformationById(Integer id) {
        return informationMapper.selectByPrimaryKey(id);
    }

    @Override
    public Information getInformationWithUserTypeById(Integer id) {
        return informationMapper.selectByPrimaryKeyWithUserType(id);
    }

    @Override
    public List<Information> getInformationsByCondition(InformationExample example) {
        return informationMapper.selectByExample(example);
    }

    @Override
    public List<Information> getInformationsWithUserTypeByCondition(InformationExample example) {
        return informationMapper.selectByExampleWithUserType(example);
    }

    @Override
    public int putInformation(Information information) {
        return informationMapper.updateByPrimaryKeySelective(information);
    }

    @Override
    public int deleteInformation(Integer id) {
        return informationMapper.deleteByPrimaryKey(id);
    }
}
