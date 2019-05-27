package com.sun.controller;

import com.sun.model.Information;
import com.sun.service.InformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@Controller
@RequestMapping("")
public class InformationController {
    private static Logger log = LoggerFactory.getLogger(InformationController.class);
    @Autowired
    private InformationService informationService;

    /**
     * 增加信息操作，information中字段有userId(String),typeId(Integer),location(String),topic(String),
     * isAnnoy(Boolean),activityTime(String),phoneNum(String),content(String),
     * isAnnoy中匿名是true，不匿名是false。
     * 方法类型是POST，通过在content中传入json封装的Information实体来完成信息传递
     * @param information
     * @return
     */
    @RequestMapping(value = "/information", method = RequestMethod.POST)
    @ResponseBody
    public String addInformation(@RequestBody Information information) {
        information.setCreatedate(new Timestamp(System.currentTimeMillis()));
        information.setTs(new Timestamp(System.currentTimeMillis()));
        informationService.postInformation(information);
        return "add information success";
    }

    /**
     * 查询信息操作，通过信息的id进行查询。
     * 方法类型为GET，/information/{id}，通过id进行主键查询，返回的结果还包括了User和TypeInfo这两个对象。
     * @param id
     * @return
     */
    @RequestMapping(value = "/information/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Information selectInformation(@PathVariable Integer id) {
        Information i = informationService.getInformationById(id);
        /*JSONObject json = new JSONObject();
        json.put("information", JSONObject.toJSON(i));
        return json.toJSONString();*/
        return i;
    }

    /**
     * 更新信息操作，通过信息的主键id定位信息进行更新操作
     * 方法类型为PUT，通过传入信息中的id定位信息，然后更新剩下的非主键字段
     * @param information
     * @return
     */
    @RequestMapping(value = "/information", method = RequestMethod.PUT)
    @ResponseBody
    public String updateInformation(@RequestBody Information information) {
        information.setTs(new Timestamp(System.currentTimeMillis()));
        informationService.putInformation(information);
        return "update information success";
    }

    /**
     * 删除信息操作，通过信息的主键id定位信息进行删除操作
     * 方法类型为DELETE，/information/{id}
     * @param id
     * @return
     */
    @RequestMapping(value = "/information/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteInformation(@PathVariable Integer id) {
        informationService.deleteInformation(id);
        return "delete information success";
    }
}
