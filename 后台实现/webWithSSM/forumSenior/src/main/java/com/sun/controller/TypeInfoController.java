package com.sun.controller;

import com.sun.model.TypeInfo;
import com.sun.service.TypeInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;


@Controller
@RequestMapping("")
public class TypeInfoController {
    private static Logger log = LoggerFactory.getLogger(TypeInfoController.class);

    @Autowired
    private TypeInfoService service;


    @RequestMapping(value = "/typeInfo", method = RequestMethod.POST)
    @ResponseBody
    public String addTypeInfo(@RequestBody TypeInfo typeInfo) {
        typeInfo.setTs(new Timestamp(System.currentTimeMillis()));
        typeInfo.setCreatedate(new Timestamp(System.currentTimeMillis()));
        service.postTypeInfo(typeInfo);
        return "add typeinfo success";
    }

    @RequestMapping(value = "/typeInfo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public TypeInfo selectTypeInfo(@PathVariable Integer id) {
        TypeInfo t = service.getTypeInfoById(id);
        /*JSONObject json = new JSONObject();
        json.put("typeinfo", JSONObject.toJSON(t));
        return json.toJSONString();*/
        return t;
    }

    @RequestMapping(value = "/typeInfo", method = RequestMethod.PUT)
    @ResponseBody
    public String updateTypeInfo(@RequestBody TypeInfo typeInfo) {
        typeInfo.setTs(new Timestamp(System.currentTimeMillis()));
        service.putTypeInfo(typeInfo);
        return "update typeinfo success";
    }

    @RequestMapping(value = "/typeInfo/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteTypeInfo(@PathVariable Integer id) {
        service.deleteTypeInfo(id);
        return "delete typeinfo success";
    }
}
