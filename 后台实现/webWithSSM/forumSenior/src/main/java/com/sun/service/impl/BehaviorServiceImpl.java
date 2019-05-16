package com.sun.service.impl;

import com.sun.dao.BehaviorMapper;
import com.sun.model.Behavior;
import com.sun.model.BehaviorExample;
import com.sun.service.BehaviorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BehaviorServiceImpl implements BehaviorService {
    @Autowired
    private BehaviorMapper mapper;

    @Override
    public int postBehavior(Behavior behavior) {
        return mapper.insertSelective(behavior);
    }

    @Override
    public Behavior getBehaviorById(String userId, Date timestamp) {
        return mapper.selectByPrimaryKeyWithUser(userId, timestamp);
    }

    @Override
    public List<Behavior> getBehaviorsByCondition(BehaviorExample example) {
        return mapper.selectByExampleWithUser(example);
    }

    @Override
    public int putBehavior(Behavior behavior) {
        return mapper.updateByPrimaryKeySelective(behavior);
    }

    @Override
    public int deleteBehavior(String userId, Date timestamp) {
        return mapper.deleteByPrimaryKey(userId, timestamp);
    }
}
