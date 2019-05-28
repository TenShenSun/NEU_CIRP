package com.sun.service.impl;

import com.sun.dao.CommentLikeMapper;
import com.sun.model.CommentLike;
import com.sun.model.CommentLikeExample;
import com.sun.service.CommentLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentLikeServiceImpl implements CommentLikeService {
    @Autowired
    CommentLikeMapper mapper;

    @Override
    public int postCommentLike(CommentLike commentLike) {
        return mapper.insertSelective(commentLike);
    }

    @Override
    public CommentLike getCommentLikeById(Integer likeId) {
        return mapper.selectByPrimaryKey(likeId);
    }

    @Override
    public List<CommentLike> getCommentLikesByCondition(CommentLikeExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public List<CommentLike> getCommentLikesByCommentId(Integer commentId) {
        CommentLikeExample example=new CommentLikeExample();
        CommentLikeExample.Criteria criteria=example.createCriteria();
        return mapper.selectByExample(example);
    }

    @Override
    public List<CommentLike> getCommentLikesByUserId(String userId) {
        CommentLikeExample example=new CommentLikeExample();
        CommentLikeExample.Criteria criteria=example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        example.setOrderByClause("createDate");
        return mapper.selectByExample(example);
    }

    @Override
    public int putCommentLike(CommentLike commentLike) {
        return mapper.updateByPrimaryKey(commentLike);
    }

    @Override
    public int deleteCommentLike(Integer likeId) {
        return mapper.deleteByPrimaryKey(likeId);
    }
}
