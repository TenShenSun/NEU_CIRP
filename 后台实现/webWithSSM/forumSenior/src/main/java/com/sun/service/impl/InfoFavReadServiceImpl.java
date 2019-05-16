package com.sun.service.impl;

import com.sun.dao.InfoFavReadMapper;
import com.sun.model.InfoFavRead;
import com.sun.model.InfoFavReadExample;
import com.sun.service.InfoFavReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoFavReadServiceImpl implements InfoFavReadService {
    @Autowired
    private InfoFavReadMapper mapper;

    @Override
    public int postInfoFavRead(InfoFavRead infoFavRead) {
        return mapper.insertSelective(infoFavRead);
    }

    @Override
    public InfoFavRead getInfoFavReadById(String userId, Integer infoId) {
        return mapper.selectByPrimaryKey(userId, infoId);
    }

    @Override
    public InfoFavRead getInfoFavReadByIdWithUserAndInformation(String userId, Integer infoId) {
        return mapper.selectByPrimaryKeyWithUserAndInformation(userId, infoId);
    }

    @Override
    public List<InfoFavRead> getInfoFavReadsByCondition(InfoFavReadExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public List<InfoFavRead> getInfoFavReadsByConditionWithUserAndInformation(InfoFavReadExample example) {
        return mapper.selectByExampleWithUserAndInformation(example);
    }

    @Override
    public int putInfoFavRead(InfoFavRead infoFavRead) {
        return mapper.updateByPrimaryKeySelective(infoFavRead);
    }

    @Override
    public int deleteInfoFavRead(String userId, Integer infoId) {
        return mapper.deleteByPrimaryKey(userId, infoId);
    }
}
