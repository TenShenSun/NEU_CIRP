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

    /**
     * 增加类型信息，参数有name(String)。
     * 方法类型为POST，在content中json封装成一个实体。前台基本用不到这个接口，或者增加后台管理模块
     * @param typeInfo
     * @return
     */
    @RequestMapping(value = "/typeInfo", method = RequestMethod.POST)
    @ResponseBody
    public String addTypeInfo(@RequestBody TypeInfo typeInfo) {
        typeInfo.setTs(new Timestamp(System.currentTimeMillis()));
        typeInfo.setCreatedate(new Timestamp(System.currentTimeMillis()));
        service.postTypeInfo(typeInfo);
        return "add typeinfo success";
    }

    /**
     * 查询类型信息，根据主键查询
     * 方法类型为GET，/typeInfo/{id}，前台基本用不到这个接口，或者增加后台管理模块
     * @param id
     * @return
     */
    @RequestMapping(value = "/typeInfo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public TypeInfo selectTypeInfo(@PathVariable Integer id) {
        TypeInfo t = service.getTypeInfoById(id);
        return t;
    }

    /**
     * 更新类型信息，参数有name(String)。根据主键进行更新，必须传入主键，然后对非主键属性进行更新
     * 方法类型为PUT，在content中json封装成一个实体。前台基本用不到这个接口，或者增加后台管理模块
     * @param typeInfo
     * @return
     */
    @RequestMapping(value = "/typeInfo", method = RequestMethod.PUT)
    @ResponseBody
    public String updateTypeInfo(@RequestBody TypeInfo typeInfo) {
        typeInfo.setTs(new Timestamp(System.currentTimeMillis()));
        service.putTypeInfo(typeInfo);
        return "update typeinfo success";
    }

    /**
     * 删除类型信息，参数为id，根据主键进行删除。
     * 方法类型为delete,/typeInfo/{id}，传入Typeinfo的id，前台基本用不到这个接口，或者增加后台管理模块
     * @param id
     * @return
     */
    @RequestMapping(value = "/typeInfo/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteTypeInfo(@PathVariable Integer id) {
        service.deleteTypeInfo(id);
        return "delete typeinfo success";
    }
}
