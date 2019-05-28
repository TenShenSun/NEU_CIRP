package com.sun.service;


import com.sun.model.CommentLike;
import com.sun.model.CommentLikeExample;

import java.util.List;

public interface CommentLikeService {
    public int postCommentLike(CommentLike commentLike);

    public CommentLike getCommentLikeById(Integer likeId);

    public List<CommentLike> getCommentLikesByCondition(CommentLikeExample example);

    public List<CommentLike> getCommentLikesByCommentId(Integer commentId);

    public List<CommentLike> getCommentLikesByUserId(String userId);

    public int putCommentLike(CommentLike commentLike);

    public int deleteCommentLike(Integer likeId);
}
