package com.sun.service.impl;

import com.sun.dao.TypeInfoMapper;
import com.sun.model.TypeInfo;
import com.sun.model.TypeInfoExample;
import com.sun.service.TypeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeInfoServiceImpl implements TypeInfoService {
    @Autowired
    private TypeInfoMapper typeInfoMapper;

    @Override
    public int postTypeInfo(TypeInfo typeInfo) {
        return typeInfoMapper.insertSelective(typeInfo);
    }

    @Override
    public TypeInfo getTypeInfoById(Integer id) {
        return typeInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TypeInfo> getTypeInfosByCondition(TypeInfoExample example) {
        return typeInfoMapper.selectByExample(example);
    }

    @Override
    public int putTypeInfo(TypeInfo typeInfo) {
        return typeInfoMapper.updateByPrimaryKeySelective(typeInfo);
    }

    @Override
    public int deleteTypeInfo(Integer id) {
        return typeInfoMapper.deleteByPrimaryKey(id);
    }
}
