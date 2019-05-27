package com.sun.controller;

import com.sun.model.InfoFavRead;
import com.sun.service.InfoFavReadService;
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

    /**
     * 增加用户和信息之间的阅读收藏关系，userId（String),infoId(Integer),isFav(Boolean),isRead(Boolean)。
     * 方法类型为POST，在Content中json传入对象infoFavRead，增加方法用来阅读行为
     * @param infoFavRead
     * @return
     */
    @RequestMapping(value = "/infofavread", method = RequestMethod.POST)
    @ResponseBody
    public String addInfoFavRead(@RequestBody InfoFavRead infoFavRead) {
        service.postInfoFavRead(infoFavRead);
        return "add inforavread success";
    }

    /**
     * 获取用户和信息之间的阅读收藏关系，根据主键查询，主键为userid(String)和infoid(Integer)。
     * 方法类型为GET，查询结果中还有连表查询得到的USer信息和Information信息
     * @param userid
     * @param infoid
     * @return
     */
    @RequestMapping(value = "/infofavread/{userid}/{infoid}", method = RequestMethod.GET)
    @ResponseBody
    public InfoFavRead selectInfoFavRead(@PathVariable String userid, @PathVariable Integer infoid) {
        InfoFavRead i = service.getInfoFavReadById(userid, infoid);
        return i;
    }

    /**
     * 更新用户和信息之间的阅读收藏关系,根据主键进行更新，必须要传入userid(String)和infoid(Integer)来定位InfoFavRead。
     * 方法类型为PUT，在content中json中传入对象，更新方法用来收藏和取消收藏行为
     * @param infoFavRead
     * @return
     */
    @RequestMapping(value = "/infofavread", method = RequestMethod.PUT)
    @ResponseBody
    public String updateInfoFavRead(@RequestBody InfoFavRead infoFavRead) {
        service.putInfoFavRead(infoFavRead);
        return "update inforavread success";
    }

    /**
     * 删除用户和信息之间的阅读收藏关系，根据主键将InfoFavRead删除
     * 方法类型为DELETE。前台基本用不到这个接口，不能删除自己的浏览记录
     * @param userid
     * @param infoid
     * @return
     */
    @RequestMapping(value = "/infofavread/{userid}/{infoid}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteInfoFavRead(@PathVariable String userid, @PathVariable Integer infoid) {
        service.deleteInfoFavRead(userid, infoid);
        return "delete inforavread success";
    }
}
