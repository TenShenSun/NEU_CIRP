package com.sun.dao;

import com.sun.model.Information;
import com.sun.model.InformationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InformationMapper {
    int countByExample(InformationExample example);

    int deleteByExample(InformationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Information record);

    int insertSelective(Information record);

    List<Information> selectByExample(InformationExample example);

    List<Information> selectByExampleWithUserAndTypeInfo(InformationExample example);

    List<Information> selectByExampleOrderByTime(InformationExample example);

    List<Information> selectByExampleOrderByViewAndTime(InformationExample example);

    List<Information> selectByExampleOrderByViewAndTimeByPage(InformationExample example,int pageNum,int pageSize);

    List<Information> selectByExampleOrderByFav(InformationExample example);

    List<Information> selectByUseridOrderByView(String userid);

    List<Information> selectByUseridOrderByFav(String userid);

    Information selectByPrimaryKey(Integer id);

    Information selectByPrimaryKeyWithUserAndTypeInfo(Integer id);

    int updateByExampleSelective(@Param("record") Information record, @Param("example") InformationExample example);

    int updateByExample(@Param("record") Information record, @Param("example") InformationExample example);

    int updateByPrimaryKeySelective(Information record);

    int updateByPrimaryKey(Information record);
}