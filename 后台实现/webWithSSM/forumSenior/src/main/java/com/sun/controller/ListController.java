package com.sun.controller;

import com.sun.model.Information;
import com.sun.service.InformationService;
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

    //OK
    @RequestMapping(value = "/informationOrderByTime", method = RequestMethod.GET)
    @ResponseBody
    public List<Information> listInformationOrderByTime(HttpServletRequest request, Model model) {
        List<Information> informationList = service.getInformationsByConditionOrderByTime();
        return informationList;
    }

    //OK
    @RequestMapping(value = "/informationOrderByViewAndTime", method = RequestMethod.GET)
    @ResponseBody
    public List<Information> listInformationOrderByViewAndTime(HttpServletRequest request, Model model) {
        List<Information> informationList = service.getInformationsByConditionOrderByViewAndTime();
        return informationList;
    }

    //OK
    @RequestMapping(value = "/informationOrderByViewAndTimeByPage/{pageNum}/{pageSize}", method = RequestMethod.GET)
    @ResponseBody
    public List<Information> listInformationOrderByViewAndTimeByPage(HttpServletRequest request, Model model, @PathVariable int pageNum, @PathVariable int pageSize) {
        List<Information> informationList = service.getInformationsByConditionOrderByViewAndTimeByPage(pageNum, pageSize);
        return informationList;
    }

    //OK
    @RequestMapping(value = "/informationOrderByFavAndTime", method = RequestMethod.GET)
    @ResponseBody
    public List<Information> listInformationOrderByFavAndTime(HttpServletRequest request, Model model) {
        List<Information> informationList = service.getInformationsByConditionOrderByFavAndTime();
        return informationList;
    }
// OK
    @RequestMapping(value = "/informationOnUserWithView/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Information> listInformationOnUserWithView(@PathVariable String id) {
        List<Information> informationList = service.getInformationsByUseridOrderByView(id);
        return informationList;
    }
// OK
    @RequestMapping(value = "/informationOnUserWithFav/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Information> listInformationOnUserWithFav(@PathVariable String id) {
        List<Information> informationList = service.getInformationsByUseridOrderByFav(id);
        return informationList;
    }

    @RequestMapping(value = "/informationOnUserWithPost/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Information> listInformationOnUserWithPost(@PathVariable String id) {
        List<Information> informationList = service.getInformationsByUseridOrderByPost(id);
        return informationList;
    }

    @RequestMapping(value = "/informationGroupByTypeid/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Information> listInformationGroupByTypeid(@PathVariable Integer id) {
        List<Information> informationList = service.getInformationsByConditionWithTypeid(id);
        return informationList;
    }


}
