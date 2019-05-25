package com.sun.service.impl;

import com.sun.dao.CommentMapper;
import com.sun.model.Comment;
import com.sun.model.CommentExample;
import com.sun.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper mapper;

    @Override
    public int postComment(Comment comment) {
        return mapper.insertSelective(comment);
    }

    @Override
    public Comment getCommentById(Integer commentId) {
        return mapper.selectByPrimaryKey(commentId);
    }

    @Override
    public List<Comment> getCommentsByCondition(CommentExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public List<Comment> getCommentsByInfoId(Integer infoId) {
        CommentExample example=new CommentExample();
        CommentExample.Criteria criteria=example.createCriteria();
        criteria.andInfoIdEqualTo(infoId);
        return mapper.selectByExample(example);
    }

    @Override
    public int putComment(Comment comment) {
        return mapper.updateByPrimaryKeySelective(comment);
    }

    @Override
    public int deleteComment(Integer commentId) {
        return mapper.deleteByPrimaryKey(commentId);
    }
}
