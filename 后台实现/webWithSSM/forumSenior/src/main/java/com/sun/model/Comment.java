package com.sun.model;

import java.util.Date;

public class Comment {
    private Integer commentId;

    private Integer pCommentId;

    private String userId;

    private Integer infoId;

    private Date createdate;

    private String content;

    private Boolean yn;

    private Date updatedate;

    private String extensive1;

    private String extensive2;

    private User user;

    private Boolean isLike;


    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getpCommentId() {
        return pCommentId;
    }

    public void setpCommentId(Integer pCommentId) {
        this.pCommentId = pCommentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Boolean getYn() {
        return yn;
    }

    public void setYn(Boolean yn) {
        this.yn = yn;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public String getExtensive1() {
        return extensive1;
    }

    public void setExtensive1(String extensive1) {
        this.extensive1 = extensive1 == null ? null : extensive1.trim();
    }

    public String getExtensive2() {
        return extensive2;
    }

    public void setExtensive2(String extensive2) {
        this.extensive2 = extensive2 == null ? null : extensive2.trim();
    }

    public Boolean getIsLike() {
        return isLike;
    }

    public void setIsLike(Boolean isLike) {
        this.isLike = isLike;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}