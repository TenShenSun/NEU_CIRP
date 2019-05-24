package com.sun.service;


import com.sun.model.Behavior;
import com.sun.model.BehaviorExample;

import java.util.Date;
import java.util.List;

public interface BehaviorService {
    public int postBehavior(Behavior behavior);

    public Behavior getBehaviorById(String userId, Date timestamp);

    public List<Behavior> getBehaviorsByCondition(BehaviorExample example);

    public int putBehavior(Behavior behavior);

    public int deleteBehavior(String userId, Date timestamp);
}
