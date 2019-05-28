package com.sun.controller;

import com.sun.dao.CommentMapper;
import com.sun.model.Comment;
import com.sun.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping("")
public class CommentController {
    @Autowired
    private CommentService service;

    /**
     * 增加评论，comment中有commentId(Integer),pCommentId(Integer),userId(String),
     * infoId(Integer),content(String)，方法为POST，在content中json传入Comment
     *
     * @param comment
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Comment addComment(@RequestBody Comment comment) {
        comment.setCreatedate(new Timestamp(System.currentTimeMillis()));
        comment.setUpdatedate(new Timestamp(System.currentTimeMillis()));
        return service.postComment(comment);
    }

    /**
     * 获取评论，根据InfoId获取，通过信息的InfoId获取这个下的所有评论，infoId（int）。方法为GET
     * 访问/comment/{infoId}
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
     * 获取评论，根据InfoId获取，通过信息的InfoId获取这个下的所有评论,user和点赞信息，infoId（int）。方法为GET
     * 访问/comment/{infoId}
     *
     * @param infoId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/commentWithUserAndLike/{infoId}/{userId}", method = RequestMethod.GET)
    public List<Comment> getCommentWithUserAndLikeList(@PathVariable int infoId,@PathVariable String userId) {
        return service.getCommentsWithUserAndLikeByInfoId(infoId,userId);
    }




    /**
     * 删除评论，根据主键commentId删除，commentId（int），方法为DELETE
     * 访问/comment/{commentId}
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
     * 修改评论，更新Comment，要求是必须传入一个CommentId然后按主键对其他字段进行更新。方法为PUT。
     * 在Content中json传入comment
     *
     * @param comment
     * @return
     */
    @RequestMapping(value = "/comment", method = RequestMethod.PUT)
    @ResponseBody
    public String updateComment(@RequestBody Comment comment) {
        comment.setUpdatedate(new Timestamp(System.currentTimeMillis()));
        service.putComment(comment);
        return "update comment success";
    }


}
