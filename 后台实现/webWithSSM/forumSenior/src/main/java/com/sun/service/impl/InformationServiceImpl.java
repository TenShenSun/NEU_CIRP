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
    private InformationMapper mapper;

    @Override
    public int postInformation(Information information) {
        return mapper.insertSelective(information);
    }

    @Override
    public Information getInformationById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public Information getInformationByIdWithUserAndTypeInfo(Integer id) {
        return mapper.selectByPrimaryKeyWithUserAndTypeInfo(id);
    }

    @Override
    public List<Information> getInformationsByCondition(InformationExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public List<Information> getInformationsByConditionWithUserAndTypeInfo(InformationExample example) {
        return mapper.selectByExampleWithUserAndTypeInfo(example);
    }

    @Override
    public List<Information> getInformationsByConditionOrderByTime() {
        InformationExample example=new InformationExample();
        return mapper.selectByExampleOrderByTime(example);
    }

    @Override
    public List<Information> getInformationsByConditionOrderByViewAndTime() {
        InformationExample example=new InformationExample();
        return mapper.selectByExampleOrderByViewAndTime(example);
    }

    @Override
    public int putInformation(Information information) {
        return mapper.updateByPrimaryKeySelective(information);
    }

    @Override
    public int deleteInformation(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }
}
