package com.sun.service;


import com.sun.model.*;

import java.util.List;

public interface InformationService {
    public int postInformation(Information information);

    public Information getInformationById(Integer id);

    public Information getInformationByIdWithUserAndTypeInfo(Integer id);

    public List<Information> getInformationsByCondition(InformationExample example);

    public List<Information> getInformationsByConditionWithTypeid(Integer typeid);

    public List<Information> getInformationsByConditionWithUserAndTypeInfo(InformationExample example);

    public List<Information> getInformationsByConditionOrderByTime();

    public List<Information> getInformationsByConditionOrderByViewAndTime();

    List<Information> getInformationsByConditionOrderByViewAndTimeByPage(int pageNum, int pageSize);

    public List<Information> getInformationsByConditionOrderByFavAndTime();

    public List<Information> getInformationsByUseridOrderByView(String userid);

    public List<Information> getInformationsByUseridOrderByFav(String userid);

    public List<Information> getInformationsByUseridOrderByPost(String userid);

    public int putInformation(Information information);

    public int deleteInformation(Integer id);


}
