package com.sun.controller;

import com.sun.dao.CommentMapper;
import com.sun.model.Comment;
import com.sun.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("")
public class CommentController {
    @Autowired
    private CommentService service;

    /**
     * 增加comment记录
     *
     * @param comment 前端传递的comment对象
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public String addComment(@RequestBody Comment comment) {
        service.postComment(comment);
        return "add comment success";
    }

    /**
     * 根据infoId查询comment列表
     *
     * @param infoId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/comment/{infoId}", method = RequestMethod.GET)
    public List<Comment> getCommentList(@PathVariable int infoId) {
        return service.getCommentsByInfoId(infoId);
    }

    /**
     * 根据commentId删除comment
     *
     * @param commentId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/comment/{commentId}", method = RequestMethod.DELETE)
    public String deleteComment(@PathVariable int commentId) {
        service.deleteComment(commentId);
        return "delete comment success";
    }


    /**
     * 根据CommentID修改commment
     *
     * @param comment
     * @return
     */
    @RequestMapping(value = "/comment", method = RequestMethod.PUT)
    @ResponseBody
    public String updateComment(@RequestBody Comment comment) {
        service.putComment(comment);
        return "update comment success";
    }


}
