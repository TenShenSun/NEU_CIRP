package com.sun.controller;

import com.sun.model.Information;
import com.sun.model.TypeInfo;
import com.sun.service.InformationService;
import com.sun.service.TypeInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/list")
public class ListController {
    private static Logger log = LoggerFactory.getLogger(ListController.class);

    @Autowired
    private InformationService service;


    @RequestMapping(value = "/informationOrderByTime", method = RequestMethod.GET)
    @ResponseBody
    public List<Information> listInformationOrderByTime(HttpServletRequest request, Model model) {
        List<Information> informationList = service.getInformationsByConditionOrderByTime();
        return informationList;
    }
    @RequestMapping(value = "/informationOrderByViewAndTime", method = RequestMethod.GET)
    @ResponseBody
    public List<Information> listInformationOrderByViewAndTime(HttpServletRequest request, Model model) {
        List<Information> informationList = service.getInformationsByConditionOrderByViewAndTime();
        return informationList;
    }

}
