package com.sun.controller;

import com.sun.model.InfoFavRead;
import com.sun.model.TypeInfo;
import com.sun.service.InfoFavReadService;
import com.sun.service.TypeInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("")
public class InfoFavReadController {
    private static Logger log = LoggerFactory.getLogger(InfoFavReadController.class);

    @Autowired
    private InfoFavReadService service;


    @RequestMapping(value = "/infoFavRead", method = RequestMethod.POST)
    @ResponseBody
    public String addInfoFavRead(@RequestBody InfoFavRead infoFavRead) {
        service.postInfoFavRead(infoFavRead);
        return "add";
    }

    @RequestMapping(value = "/infoFavRead/{userid}/{infoid}", method = RequestMethod.GET)
    @ResponseBody
    public InfoFavRead selectInfoFavRead(@PathVariable String userid,@PathVariable Integer infoid) {
        InfoFavRead i = service.getInfoFavReadById(userid, infoid);
        return i;
    }

    @RequestMapping(value = "/infoFavRead", method = RequestMethod.PUT)
    @ResponseBody
    public String updateInfoFavRead(@RequestBody InfoFavRead infoFavRead) {
        service.putInfoFavRead(infoFavRead);
        return "update";
    }

    @RequestMapping(value = "/infoFavRead/{userid}/{infoid}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteInfoFavRead(@PathVariable String userid,@PathVariable Integer infoid) {
        service.deleteInfoFavRead(userid, infoid);
        return "delete";
    }
}
