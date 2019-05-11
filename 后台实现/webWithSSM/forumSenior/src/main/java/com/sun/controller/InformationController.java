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

@Controller
@RequestMapping("")
public class InformationController {
    private static Logger log = LoggerFactory.getLogger(InformationController.class);
    @Autowired
    private InformationService informationService;

    @RequestMapping(value = "/information", method = RequestMethod.POST)
    public String addInformation(@RequestBody Information information) {
        informationService.postInformation(information);
        return "add";
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
    public String updateInformation(@RequestBody Information information) {
        informationService.putInformation(information);
        return "update";
    }

    @RequestMapping(value = "/information/{id}", method = RequestMethod.DELETE)
    public String deleteInformation(@PathVariable Integer id) {
        informationService.deleteInformation(id);
        return "delete";
    }
}
