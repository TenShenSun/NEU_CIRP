package com.sun.service.impl;

import com.sun.dao.CommentMapper;
import com.sun.model.Comment;
import com.sun.service.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class CommentServiceImplTest {
    @Autowired
    CommentService service;

    @Test
    public void postComment() {
        Comment comment=new Comment();
        comment.setInfoId(456);
        comment.setContent("123as");
        service.postComment(comment);
    }

    @Test
    public void getCommentById() {
        Comment comment=new Comment();
    }

    @Test
    public void getCommentsByCondition() {
    }

    @Test
    public void getCommentsByInfoId() {
    }

    @Test
    public void putComment() {
    }

    @Test
    public void deleteComment() {
    }
}