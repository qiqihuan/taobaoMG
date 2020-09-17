package com.user.mapper;

import java.util.ArrayList;
import java.util.List;

public class PermissionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public PermissionExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUriIsNull() {
            addCriterion("uri is null");
            return (Criteria) this;
        }

        public Criteria andUriIsNotNull() {
            addCriterion("uri is not null");
            return (Criteria) this;
        }

        public Criteria andUriEqualTo(String value) {
            addCriterion("uri =", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriNotEqualTo(String value) {
            addCriterion("uri <>", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriGreaterThan(String value) {
            addCriterion("uri >", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriGreaterThanOrEqualTo(String value) {
            addCriterion("uri >=", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriLessThan(String value) {
            addCriterion("uri <", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriLessThanOrEqualTo(String value) {
            addCriterion("uri <=", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriLike(String value) {
            addCriterion("uri like", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriNotLike(String value) {
            addCriterion("uri not like", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriIn(List<String> values) {
            addCriterion("uri in", values, "uri");
            return (Criteria) this;
        }

        public Criteria andUriNotIn(List<String> values) {
            addCriterion("uri not in", values, "uri");
            return (Criteria) this;
        }

        public Criteria andUriBetween(String value1, String value2) {
            addCriterion("uri between", value1, value2, "uri");
            return (Criteria) this;
        }

        public Criteria andUriNotBetween(String value1, String value2) {
            addCriterion("uri not between", value1, value2, "uri");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("`name` is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("`name` is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("`name` =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("`name` <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("`name` >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("`name` >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("`name` <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("`name` <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("`name` like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("`name` not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("`name` in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("`name` not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("`name` between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("`name` not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andCreateIsNull() {
            addCriterion("`create` is null");
            return (Criteria) this;
        }

        public Criteria andCreateIsNotNull() {
            addCriterion("`create` is not null");
            return (Criteria) this;
        }

        public Criteria andCreateEqualTo(Byte value) {
            addCriterion("`create` =", value, "create");
            return (Criteria) this;
        }

        public Criteria andCreateNotEqualTo(Byte value) {
            addCriterion("`create` <>", value, "create");
            return (Criteria) this;
        }

        public Criteria andCreateGreaterThan(Byte value) {
            addCriterion("`create` >", value, "create");
            return (Criteria) this;
        }

        public Criteria andCreateGreaterThanOrEqualTo(Byte value) {
            addCriterion("`create` >=", value, "create");
            return (Criteria) this;
        }

        public Criteria andCreateLessThan(Byte value) {
            addCriterion("`create` <", value, "create");
            return (Criteria) this;
        }

        public Criteria andCreateLessThanOrEqualTo(Byte value) {
            addCriterion("`create` <=", value, "create");
            return (Criteria) this;
        }

        public Criteria andCreateIn(List<Byte> values) {
            addCriterion("`create` in", values, "create");
            return (Criteria) this;
        }

        public Criteria andCreateNotIn(List<Byte> values) {
            addCriterion("`create` not in", values, "create");
            return (Criteria) this;
        }

        public Criteria andCreateBetween(Byte value1, Byte value2) {
            addCriterion("`create` between", value1, value2, "create");
            return (Criteria) this;
        }

        public Criteria andCreateNotBetween(Byte value1, Byte value2) {
            addCriterion("`create` not between", value1, value2, "create");
            return (Criteria) this;
        }

        public Criteria andRetrieveIsNull() {
            addCriterion("retrieve is null");
            return (Criteria) this;
        }

        public Criteria andRetrieveIsNotNull() {
            addCriterion("retrieve is not null");
            return (Criteria) this;
        }

        public Criteria andRetrieveEqualTo(Byte value) {
            addCriterion("retrieve =", value, "retrieve");
            return (Criteria) this;
        }

        public Criteria andRetrieveNotEqualTo(Byte value) {
            addCriterion("retrieve <>", value, "retrieve");
            return (Criteria) this;
        }

        public Criteria andRetrieveGreaterThan(Byte value) {
            addCriterion("retrieve >", value, "retrieve");
            return (Criteria) this;
        }

        public Criteria andRetrieveGreaterThanOrEqualTo(Byte value) {
            addCriterion("retrieve >=", value, "retrieve");
            return (Criteria) this;
        }

        public Criteria andRetrieveLessThan(Byte value) {
            addCriterion("retrieve <", value, "retrieve");
            return (Criteria) this;
        }

        public Criteria andRetrieveLessThanOrEqualTo(Byte value) {
            addCriterion("retrieve <=", value, "retrieve");
            return (Criteria) this;
        }

        public Criteria andRetrieveIn(List<Byte> values) {
            addCriterion("retrieve in", values, "retrieve");
            return (Criteria) this;
        }

        public Criteria andRetrieveNotIn(List<Byte> values) {
            addCriterion("retrieve not in", values, "retrieve");
            return (Criteria) this;
        }

        public Criteria andRetrieveBetween(Byte value1, Byte value2) {
            addCriterion("retrieve between", value1, value2, "retrieve");
            return (Criteria) this;
        }

        public Criteria andRetrieveNotBetween(Byte value1, Byte value2) {
            addCriterion("retrieve not between", value1, value2, "retrieve");
            return (Criteria) this;
        }

        public Criteria andUpdateIsNull() {
            addCriterion("`update` is null");
            return (Criteria) this;
        }

        public Criteria andUpdateIsNotNull() {
            addCriterion("`update` is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateEqualTo(Byte value) {
            addCriterion("`update` =", value, "update");
            return (Criteria) this;
        }

        public Criteria andUpdateNotEqualTo(Byte value) {
            addCriterion("`update` <>", value, "update");
            return (Criteria) this;
        }

        public Criteria andUpdateGreaterThan(Byte value) {
            addCriterion("`update` >", value, "update");
            return (Criteria) this;
        }

        public Criteria andUpdateGreaterThanOrEqualTo(Byte value) {
            addCriterion("`update` >=", value, "update");
            return (Criteria) this;
        }

        public Criteria andUpdateLessThan(Byte value) {
            addCriterion("`update` <", value, "update");
            return (Criteria) this;
        }

        public Criteria andUpdateLessThanOrEqualTo(Byte value) {
            addCriterion("`update` <=", value, "update");
            return (Criteria) this;
        }

        public Criteria andUpdateIn(List<Byte> values) {
            addCriterion("`update` in", values, "update");
            return (Criteria) this;
        }

        public Criteria andUpdateNotIn(List<Byte> values) {
            addCriterion("`update` not in", values, "update");
            return (Criteria) this;
        }

        public Criteria andUpdateBetween(Byte value1, Byte value2) {
            addCriterion("`update` between", value1, value2, "update");
            return (Criteria) this;
        }

        public Criteria andUpdateNotBetween(Byte value1, Byte value2) {
            addCriterion("`update` not between", value1, value2, "update");
            return (Criteria) this;
        }

        public Criteria andDeleteIsNull() {
            addCriterion("`delete` is null");
            return (Criteria) this;
        }

        public Criteria andDeleteIsNotNull() {
            addCriterion("`delete` is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteEqualTo(Byte value) {
            addCriterion("`delete` =", value, "delete");
            return (Criteria) this;
        }

        public Criteria andDeleteNotEqualTo(Byte value) {
            addCriterion("`delete` <>", value, "delete");
            return (Criteria) this;
        }

        public Criteria andDeleteGreaterThan(Byte value) {
            addCriterion("`delete` >", value, "delete");
            return (Criteria) this;
        }

        public Criteria andDeleteGreaterThanOrEqualTo(Byte value) {
            addCriterion("`delete` >=", value, "delete");
            return (Criteria) this;
        }

        public Criteria andDeleteLessThan(Byte value) {
            addCriterion("`delete` <", value, "delete");
            return (Criteria) this;
        }

        public Criteria andDeleteLessThanOrEqualTo(Byte value) {
            addCriterion("`delete` <=", value, "delete");
            return (Criteria) this;
        }

        public Criteria andDeleteIn(List<Byte> values) {
            addCriterion("`delete` in", values, "delete");
            return (Criteria) this;
        }

        public Criteria andDeleteNotIn(List<Byte> values) {
            addCriterion("`delete` not in", values, "delete");
            return (Criteria) this;
        }

        public Criteria andDeleteBetween(Byte value1, Byte value2) {
            addCriterion("`delete` between", value1, value2, "delete");
            return (Criteria) this;
        }

        public Criteria andDeleteNotBetween(Byte value1, Byte value2) {
            addCriterion("`delete` not between", value1, value2, "delete");
            return (Criteria) this;
        }
    }

    /**
     */
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