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

/**
 * 其中每条信息都有readCount和favCount两个字段用来
 * 统计每个信息的总阅读数和总收藏数
 */
@Controller
@RequestMapping("/list")
public class ListController {
    private static Logger log = LoggerFactory.getLogger(ListController.class);

    @Autowired
    private InformationService service;

    /**
     * 返回所有的信息根据创建时间排序后的结果。
     * 方法类型为GET， /informationOrderByTime
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/informationOrderByTime", method = RequestMethod.GET)
    @ResponseBody
    public List<Information> listInformationOrderByTime(HttpServletRequest request, Model model) {
        List<Information> informationList = service.getInformationsByConditionOrderByTime();
        return informationList;
    }

    /**
     * 返回所有的信息先按照查看数后按照时间排序后的结果
     * 方法类型为GET， /informationOrderByViewAndTime
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/informationOrderByViewAndTime", method = RequestMethod.GET)
    @ResponseBody
    public List<Information> listInformationOrderByViewAndTime(HttpServletRequest request, Model model) {
        List<Information> informationList = service.getInformationsByConditionOrderByViewAndTime();
        return informationList;
    }

    /**
     * 返回所有的信息先按照查看数后按照时间排序后的结果的分页版本
     * 方法类型为GET， /informationOrderByViewAndTimeByPage/{pageNum}/{pageSize}
     *
     * @param request
     * @param model
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/informationOrderByViewAndTimeByPage/{pageNum}/{pageSize}", method = RequestMethod.GET)
    @ResponseBody
    public List<Information> listInformationOrderByViewAndTimeByPage(HttpServletRequest request, Model model, @PathVariable int pageNum, @PathVariable int pageSize) {
        List<Information> informationList = service.getInformationsByConditionOrderByViewAndTimeByPage(pageNum, pageSize);
        return informationList;
    }

    /**
     * 返回所有的信息先按照收藏数后按照时间排序后的结果
     * 方法类型为GET，/informationOrderByFavAndTime
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/informationOrderByFavAndTime", method = RequestMethod.GET)
    @ResponseBody
    public List<Information> listInformationOrderByFavAndTime(HttpServletRequest request, Model model) {
        List<Information> informationList = service.getInformationsByConditionOrderByFavAndTime();
        return informationList;
    }

    /**
     * 返回一个用户阅读过的信息列表，浏览历史
     * 方法类型为GET，/informationOnUserWithView/{id}，id为阅读者的id。
     * @param id
     * @return
     */
    @RequestMapping(value = "/informationOnUserWithView/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Information> listInformationOnUserWithView(@PathVariable String id) {
        List<Information> informationList = service.getInformationsByUseridOrderByView(id);
        return informationList;
    }

    /**
     * 返回一个用户收藏过的信息列表,我的收藏
     * 方法类型为GET，/informationOnUserWithFav/{id}，id为收藏者的id。
     * @param id
     * @return
     */
    @RequestMapping(value = "/informationOnUserWithFav/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Information> listInformationOnUserWithFav(@PathVariable String id) {
        List<Information> informationList = service.getInformationsByUseridOrderByFav(id);
        return informationList;
    }

    /**
     * 返回一个用户发布过的信息列表，发布记录
     * 方法类型为GET，/informationOnUserWithPost/{id}，id为发布者的id。
     * @param id
     * @return
     */
    @RequestMapping(value = "/informationOnUserWithPost/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Information> listInformationOnUserWithPost(@PathVariable String id) {
        List<Information> informationList = service.getInformationsByUseridOrderByPost(id);
        return informationList;
    }

    /**
     * 返回有选定的信息类型的信息列表
     * 方法类型为GET，/informationGroupByTypeid/{id}，id为信息类型的id。
     * @param id
     * @return
     */
    @RequestMapping(value = "/informationGroupByTypeid/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Information> listInformationGroupByTypeid(@PathVariable Integer id) {
        List<Information> informationList = service.getInformationsByConditionWithTypeid(id);
        return informationList;
    }


}
