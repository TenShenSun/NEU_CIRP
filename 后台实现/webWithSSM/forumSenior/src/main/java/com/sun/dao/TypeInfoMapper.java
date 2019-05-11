package com.sun.dao;

import com.sun.model.TypeInfo;
import com.sun.model.TypeInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TypeInfoMapper {
    int countByExample(TypeInfoExample example);

    int deleteByExample(TypeInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TypeInfo record);

    int insertSelective(TypeInfo record);

    List<TypeInfo> selectByExample(TypeInfoExample example);

    TypeInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TypeInfo record, @Param("example") TypeInfoExample example);

    int updateByExample(@Param("record") TypeInfo record, @Param("example") TypeInfoExample example);

    int updateByPrimaryKeySelective(TypeInfo record);

    int updateByPrimaryKey(TypeInfo record);
}