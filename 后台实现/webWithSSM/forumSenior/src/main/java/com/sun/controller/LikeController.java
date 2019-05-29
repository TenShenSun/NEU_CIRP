package com.sun.controller;

import com.sun.model.Comment;
import com.sun.model.CommentLike;
import com.sun.model.CommentLikeExample;
import com.sun.service.CommentLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

/**
 * 实现点赞功能
 * 2019/5/28
 */
@Controller
@RequestMapping("")
public class LikeController {

    @Autowired
    private CommentLikeService service;

    /**
     * 点赞，CommentLike中有LikeId(Integer),CommentId(Integer),UserId(String),
     * IsLike(boolean) 方法为POST
     *
     * @param commentLike 点赞实体
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/commentLike", method = RequestMethod.POST)
    public String addIsLike(@RequestBody CommentLike commentLike) {
        CommentLikeExample example = new CommentLikeExample();
        CommentLikeExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(commentLike.getUserId());
        criteria.andCommentIdEqualTo(commentLike.getCommentId());
        List<CommentLike> list = service.getCommentLikesByCondition(example);
        commentLike.setCreatedate(new Timestamp(System.currentTimeMillis()));
        commentLike.setUpdatedate(new Timestamp(System.currentTimeMillis()));
        commentLike.setCommentId(commentLike.getCommentId());
        commentLike.setUserId(commentLike.getUserId());
        if (list.size() == 0) {
            commentLike.setIsLike(true);
            service.postCommentLike(commentLike);
            return "add CommentLike success";
        } else {
            commentLike.setYn(true);
            commentLike.setLikeId(list.get(0).getLikeId());
            commentLike.setIsLike(!(list.get(0).getIsLike()));
            service.putCommentLike(commentLike);
            return "update CommentLike success";
        }
    }

    /**
     * 取消点赞，isLike字段置为false
     * 访问/comment/{infoId}
     * 前台只需要传递commentId和isLike字段
     *
     * @param commentLike
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/commentLike", method = RequestMethod.PUT)
    public String updateIsLike(@RequestBody CommentLike commentLike) {
        commentLike.setCommentId(commentLike.getCommentId());
        commentLike.setIsLike(commentLike.getIsLike());
        service.putCommentLike(commentLike);
        return "update success";

    }


}
