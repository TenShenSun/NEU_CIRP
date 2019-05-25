package com.sun.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCommentIdIsNull() {
            addCriterion("comment_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentIdIsNotNull() {
            addCriterion("comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentIdEqualTo(Integer value) {
            addCriterion("comment_id =", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotEqualTo(Integer value) {
            addCriterion("comment_id <>", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThan(Integer value) {
            addCriterion("comment_id >", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_id >=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThan(Integer value) {
            addCriterion("comment_id <", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThanOrEqualTo(Integer value) {
            addCriterion("comment_id <=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdIn(List<Integer> values) {
            addCriterion("comment_id in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotIn(List<Integer> values) {
            addCriterion("comment_id not in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdBetween(Integer value1, Integer value2) {
            addCriterion("comment_id between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_id not between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andPCommentIdIsNull() {
            addCriterion("p_comment_id is null");
            return (Criteria) this;
        }

        public Criteria andPCommentIdIsNotNull() {
            addCriterion("p_comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andPCommentIdEqualTo(Integer value) {
            addCriterion("p_comment_id =", value, "pCommentId");
            return (Criteria) this;
        }

        public Criteria andPCommentIdNotEqualTo(Integer value) {
            addCriterion("p_comment_id <>", value, "pCommentId");
            return (Criteria) this;
        }

        public Criteria andPCommentIdGreaterThan(Integer value) {
            addCriterion("p_comment_id >", value, "pCommentId");
            return (Criteria) this;
        }

        public Criteria andPCommentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_comment_id >=", value, "pCommentId");
            return (Criteria) this;
        }

        public Criteria andPCommentIdLessThan(Integer value) {
            addCriterion("p_comment_id <", value, "pCommentId");
            return (Criteria) this;
        }

        public Criteria andPCommentIdLessThanOrEqualTo(Integer value) {
            addCriterion("p_comment_id <=", value, "pCommentId");
            return (Criteria) this;
        }

        public Criteria andPCommentIdIn(List<Integer> values) {
            addCriterion("p_comment_id in", values, "pCommentId");
            return (Criteria) this;
        }

        public Criteria andPCommentIdNotIn(List<Integer> values) {
            addCriterion("p_comment_id not in", values, "pCommentId");
            return (Criteria) this;
        }

        public Criteria andPCommentIdBetween(Integer value1, Integer value2) {
            addCriterion("p_comment_id between", value1, value2, "pCommentId");
            return (Criteria) this;
        }

        public Criteria andPCommentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("p_comment_id not between", value1, value2, "pCommentId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andInfoIdIsNull() {
            addCriterion("info_id is null");
            return (Criteria) this;
        }

        public Criteria andInfoIdIsNotNull() {
            addCriterion("info_id is not null");
            return (Criteria) this;
        }

        public Criteria andInfoIdEqualTo(Integer value) {
            addCriterion("info_id =", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotEqualTo(Integer value) {
            addCriterion("info_id <>", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdGreaterThan(Integer value) {
            addCriterion("info_id >", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("info_id >=", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdLessThan(Integer value) {
            addCriterion("info_id <", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdLessThanOrEqualTo(Integer value) {
            addCriterion("info_id <=", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdIn(List<Integer> values) {
            addCriterion("info_id in", values, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotIn(List<Integer> values) {
            addCriterion("info_id not in", values, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdBetween(Integer value1, Integer value2) {
            addCriterion("info_id between", value1, value2, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("info_id not between", value1, value2, "infoId");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNull() {
            addCriterion("createDate is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("createDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(Date value) {
            addCriterion("createDate =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(Date value) {
            addCriterion("createDate <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(Date value) {
            addCriterion("createDate >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("createDate >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(Date value) {
            addCriterion("createDate <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(Date value) {
            addCriterion("createDate <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<Date> values) {
            addCriterion("createDate in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<Date> values) {
            addCriterion("createDate not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(Date value1, Date value2) {
            addCriterion("createDate between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(Date value1, Date value2) {
            addCriterion("createDate not between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andYnIsNull() {
            addCriterion("yn is null");
            return (Criteria) this;
        }

        public Criteria andYnIsNotNull() {
            addCriterion("yn is not null");
            return (Criteria) this;
        }

        public Criteria andYnEqualTo(Boolean value) {
            addCriterion("yn =", value, "yn");
            return (Criteria) this;
        }

        public Criteria andYnNotEqualTo(Boolean value) {
            addCriterion("yn <>", value, "yn");
            return (Criteria) this;
        }

        public Criteria andYnGreaterThan(Boolean value) {
            addCriterion("yn >", value, "yn");
            return (Criteria) this;
        }

        public Criteria andYnGreaterThanOrEqualTo(Boolean value) {
            addCriterion("yn >=", value, "yn");
            return (Criteria) this;
        }

        public Criteria andYnLessThan(Boolean value) {
            addCriterion("yn <", value, "yn");
            return (Criteria) this;
        }

        public Criteria andYnLessThanOrEqualTo(Boolean value) {
            addCriterion("yn <=", value, "yn");
            return (Criteria) this;
        }

        public Criteria andYnIn(List<Boolean> values) {
            addCriterion("yn in", values, "yn");
            return (Criteria) this;
        }

        public Criteria andYnNotIn(List<Boolean> values) {
            addCriterion("yn not in", values, "yn");
            return (Criteria) this;
        }

        public Criteria andYnBetween(Boolean value1, Boolean value2) {
            addCriterion("yn between", value1, value2, "yn");
            return (Criteria) this;
        }

        public Criteria andYnNotBetween(Boolean value1, Boolean value2) {
            addCriterion("yn not between", value1, value2, "yn");
            return (Criteria) this;
        }

        public Criteria andUpdatedateIsNull() {
            addCriterion("updateDate is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedateIsNotNull() {
            addCriterion("updateDate is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedateEqualTo(Date value) {
            addCriterion("updateDate =", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateNotEqualTo(Date value) {
            addCriterion("updateDate <>", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateGreaterThan(Date value) {
            addCriterion("updateDate >", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("updateDate >=", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateLessThan(Date value) {
            addCriterion("updateDate <", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateLessThanOrEqualTo(Date value) {
            addCriterion("updateDate <=", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateIn(List<Date> values) {
            addCriterion("updateDate in", values, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateNotIn(List<Date> values) {
            addCriterion("updateDate not in", values, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateBetween(Date value1, Date value2) {
            addCriterion("updateDate between", value1, value2, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateNotBetween(Date value1, Date value2) {
            addCriterion("updateDate not between", value1, value2, "updatedate");
            return (Criteria) this;
        }

        public Criteria andExtensive1IsNull() {
            addCriterion("extensive1 is null");
            return (Criteria) this;
        }

        public Criteria andExtensive1IsNotNull() {
            addCriterion("extensive1 is not null");
            return (Criteria) this;
        }

        public Criteria andExtensive1EqualTo(String value) {
            addCriterion("extensive1 =", value, "extensive1");
            return (Criteria) this;
        }

        public Criteria andExtensive1NotEqualTo(String value) {
            addCriterion("extensive1 <>", value, "extensive1");
            return (Criteria) this;
        }

        public Criteria andExtensive1GreaterThan(String value) {
            addCriterion("extensive1 >", value, "extensive1");
            return (Criteria) this;
        }

        public Criteria andExtensive1GreaterThanOrEqualTo(String value) {
            addCriterion("extensive1 >=", value, "extensive1");
            return (Criteria) this;
        }

        public Criteria andExtensive1LessThan(String value) {
            addCriterion("extensive1 <", value, "extensive1");
            return (Criteria) this;
        }

        public Criteria andExtensive1LessThanOrEqualTo(String value) {
            addCriterion("extensive1 <=", value, "extensive1");
            return (Criteria) this;
        }

        public Criteria andExtensive1Like(String value) {
            addCriterion("extensive1 like", value, "extensive1");
            return (Criteria) this;
        }

        public Criteria andExtensive1NotLike(String value) {
            addCriterion("extensive1 not like", value, "extensive1");
            return (Criteria) this;
        }

        public Criteria andExtensive1In(List<String> values) {
            addCriterion("extensive1 in", values, "extensive1");
            return (Criteria) this;
        }

        public Criteria andExtensive1NotIn(List<String> values) {
            addCriterion("extensive1 not in", values, "extensive1");
            return (Criteria) this;
        }

        public Criteria andExtensive1Between(String value1, String value2) {
            addCriterion("extensive1 between", value1, value2, "extensive1");
            return (Criteria) this;
        }

        public Criteria andExtensive1NotBetween(String value1, String value2) {
            addCriterion("extensive1 not between", value1, value2, "extensive1");
            return (Criteria) this;
        }

        public Criteria andExtensive2IsNull() {
            addCriterion("extensive2 is null");
            return (Criteria) this;
        }

        public Criteria andExtensive2IsNotNull() {
            addCriterion("extensive2 is not null");
            return (Criteria) this;
        }

        public Criteria andExtensive2EqualTo(String value) {
            addCriterion("extensive2 =", value, "extensive2");
            return (Criteria) this;
        }

        public Criteria andExtensive2NotEqualTo(String value) {
            addCriterion("extensive2 <>", value, "extensive2");
            return (Criteria) this;
        }

        public Criteria andExtensive2GreaterThan(String value) {
            addCriterion("extensive2 >", value, "extensive2");
            return (Criteria) this;
        }

        public Criteria andExtensive2GreaterThanOrEqualTo(String value) {
            addCriterion("extensive2 >=", value, "extensive2");
            return (Criteria) this;
        }

        public Criteria andExtensive2LessThan(String value) {
            addCriterion("extensive2 <", value, "extensive2");
            return (Criteria) this;
        }

        public Criteria andExtensive2LessThanOrEqualTo(String value) {
            addCriterion("extensive2 <=", value, "extensive2");
            return (Criteria) this;
        }

        public Criteria andExtensive2Like(String value) {
            addCriterion("extensive2 like", value, "extensive2");
            return (Criteria) this;
        }

        public Criteria andExtensive2NotLike(String value) {
            addCriterion("extensive2 not like", value, "extensive2");
            return (Criteria) this;
        }

        public Criteria andExtensive2In(List<String> values) {
            addCriterion("extensive2 in", values, "extensive2");
            return (Criteria) this;
        }

        public Criteria andExtensive2NotIn(List<String> values) {
            addCriterion("extensive2 not in", values, "extensive2");
            return (Criteria) this;
        }

        public Criteria andExtensive2Between(String value1, String value2) {
            addCriterion("extensive2 between", value1, value2, "extensive2");
            return (Criteria) this;
        }

        public Criteria andExtensive2NotBetween(String value1, String value2) {
            addCriterion("extensive2 not between", value1, value2, "extensive2");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}