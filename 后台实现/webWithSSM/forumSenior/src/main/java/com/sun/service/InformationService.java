package com.sun.service;


import com.sun.model.*;

import java.util.List;

public interface InformationService {
    public int postInformation(Information information);

    public Information getInformationById(Integer id);

    public Information getInformationWithUserTypeById(Integer id);

    public List<Information> getInformationsByCondition(InformationExample example);

    public List<Information> getInformationsWithUserTypeByCondition(InformationExample example);

    public int putInformation(Information information);

    public int deleteInformation(Integer id);

}
