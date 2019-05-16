package com.sun.dao;

import com.sun.model.Behavior;
import com.sun.model.BehaviorExample;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BehaviorMapper {
    int countByExample(BehaviorExample example);

    int deleteByExample(BehaviorExample example);

    int deleteByPrimaryKey(@Param("userId") String userId, @Param("timestamp") Date timestamp);

    int insert(Behavior record);

    int insertSelective(Behavior record);

    List<Behavior> selectByExample(BehaviorExample example);

    List<Behavior> selectByExampleWithUser(BehaviorExample example);

    Behavior selectByPrimaryKey(@Param("userId") String userId, @Param("timestamp") Date timestamp);

    Behavior selectByPrimaryKeyWithUser(@Param("userId") String userId, @Param("timestamp") Date timestamp);

    int updateByExampleSelective(@Param("record") Behavior record, @Param("example") BehaviorExample example);

    int updateByExample(@Param("record") Behavior record, @Param("example") BehaviorExample example);

    int updateByPrimaryKeySelective(Behavior record);

    int updateByPrimaryKey(Behavior record);
}