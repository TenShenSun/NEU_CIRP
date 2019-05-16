package com.sun.service;

import com.sun.model.*;

import java.util.Date;
import java.util.List;

public interface InfoFavReadService {
    public int postInfoFavRead(InfoFavRead infoFavRead);

    public InfoFavRead getInfoFavReadById(String userId, Integer infoId);

    public InfoFavRead getInfoFavReadByIdWithUserAndInformation(String userId, Integer infoId);

    public List<InfoFavRead> getInfoFavReadsByCondition(InfoFavReadExample example);

    public List<InfoFavRead> getInfoFavReadsByConditionWithUserAndInformation(InfoFavReadExample example);

    public int putInfoFavRead(InfoFavRead infoFavRead);

    public int deleteInfoFavRead(String userId, Integer infoId);
}
