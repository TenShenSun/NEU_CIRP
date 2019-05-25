package com.sun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("")
public class CommentController {

    /**
     * 增加comment记录
     * @param comment 前端传递的comment对象
     * @return
     */

    /*@ResponseBody
    @RequestMapping(value="/comment",method = RequestMethod.PUT)
    public int addComment(@ResquestBody Comment comment){
        return 1;
    }*/


    /**
     * 根据commentId删除comment
     * @param commentId
     * @return
     */
    /*@ResponseBody
    @RequestMapping(value="/comment/{commentId}",method = RequestMethod.DELETE)
    public int deleteComment(@PathVariable  int commentId){
        return 1;
    }*/


    /**
     * 根据CommentID修改commment
     * @param comment
     * @return
     */
    /*@RequestMapping(value = "/comment/{commentId}",method = RequestMethod.update)
    @ResponseBody
    public int updateComment(@PathVariable int commentId){
        return 1;
    }*/


    /**
     * 根据infoId查询comment列表
     * @param infoId
     * @return
     */
    /*@ResponseBody
    @RequestMapping(value = "/comment/{infoId}",method = RequestMethod.GET)
    public List<Comment> getCommentList(@PathVariable int infoId){
        return null;
    }*/



}
