package com.sun.controller;

import com.alibaba.fastjson.JSONObject;
import com.sun.model.Information;
import com.sun.service.InformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;

@Controller
@RequestMapping("")
public class InformationController {
    private static Logger log = LoggerFactory.getLogger(InformationController.class);
    @Autowired
    private InformationService informationService;

    @RequestMapping(value = "/information", method = RequestMethod.POST)
    @ResponseBody
    public String addInformation(@RequestBody Information information) {
        information.setCreatedate(new Timestamp(System.currentTimeMillis()));
        information.setTs(new Timestamp(System.currentTimeMillis()));
        informationService.postInformation(information);
        return "add information success";
    }

    @RequestMapping(value = "/information/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Information selectInformation(@PathVariable Integer id) {
        Information i = informationService.getInformationById(id);
        /*JSONObject json = new JSONObject();
        json.put("information", JSONObject.toJSON(i));
        return json.toJSONString();*/
        return i;
    }

    @RequestMapping(value = "/information", method = RequestMethod.PUT)
    @ResponseBody
    public String updateInformation(@RequestBody Information information) {
        information.setTs(new Timestamp(System.currentTimeMillis()));
        informationService.putInformation(information);
        return "update information success";
    }

    @RequestMapping(value = "/information/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteInformation(@PathVariable Integer id) {
        informationService.deleteInformation(id);
        return "delete information success";
    }
}
