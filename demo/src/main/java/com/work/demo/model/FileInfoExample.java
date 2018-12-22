package com.work.demo.model;

import java.util.ArrayList;
import java.util.List;

public class FileInfoExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table FILE_INFO
	 * @mbg.generated  Tue Oct 23 16:48:47 CST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table FILE_INFO
	 * @mbg.generated  Tue Oct 23 16:48:47 CST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table FILE_INFO
	 * @mbg.generated  Tue Oct 23 16:48:47 CST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FILE_INFO
	 * @mbg.generated  Tue Oct 23 16:48:47 CST 2018
	 */
	public FileInfoExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FILE_INFO
	 * @mbg.generated  Tue Oct 23 16:48:47 CST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FILE_INFO
	 * @mbg.generated  Tue Oct 23 16:48:47 CST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FILE_INFO
	 * @mbg.generated  Tue Oct 23 16:48:47 CST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FILE_INFO
	 * @mbg.generated  Tue Oct 23 16:48:47 CST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FILE_INFO
	 * @mbg.generated  Tue Oct 23 16:48:47 CST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FILE_INFO
	 * @mbg.generated  Tue Oct 23 16:48:47 CST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FILE_INFO
	 * @mbg.generated  Tue Oct 23 16:48:47 CST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FILE_INFO
	 * @mbg.generated  Tue Oct 23 16:48:47 CST 2018
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FILE_INFO
	 * @mbg.generated  Tue Oct 23 16:48:47 CST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FILE_INFO
	 * @mbg.generated  Tue Oct 23 16:48:47 CST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table FILE_INFO
	 * @mbg.generated  Tue Oct 23 16:48:47 CST 2018
	 */
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

		public Criteria andUuidIsNull() {
			addCriterion("UUID is null");
			return (Criteria) this;
		}

		public Criteria andUuidIsNotNull() {
			addCriterion("UUID is not null");
			return (Criteria) this;
		}

		public Criteria andUuidEqualTo(String value) {
			addCriterion("UUID =", value, "uuid");
			return (Criteria) this;
		}

		public Criteria andUuidNotEqualTo(String value) {
			addCriterion("UUID <>", value, "uuid");
			return (Criteria) this;
		}

		public Criteria andUuidGreaterThan(String value) {
			addCriterion("UUID >", value, "uuid");
			return (Criteria) this;
		}

		public Criteria andUuidGreaterThanOrEqualTo(String value) {
			addCriterion("UUID >=", value, "uuid");
			return (Criteria) this;
		}

		public Criteria andUuidLessThan(String value) {
			addCriterion("UUID <", value, "uuid");
			return (Criteria) this;
		}

		public Criteria andUuidLessThanOrEqualTo(String value) {
			addCriterion("UUID <=", value, "uuid");
			return (Criteria) this;
		}

		public Criteria andUuidLike(String value) {
			addCriterion("UUID like", value, "uuid");
			return (Criteria) this;
		}

		public Criteria andUuidNotLike(String value) {
			addCriterion("UUID not like", value, "uuid");
			return (Criteria) this;
		}

		public Criteria andUuidIn(List<String> values) {
			addCriterion("UUID in", values, "uuid");
			return (Criteria) this;
		}

		public Criteria andUuidNotIn(List<String> values) {
			addCriterion("UUID not in", values, "uuid");
			return (Criteria) this;
		}

		public Criteria andUuidBetween(String value1, String value2) {
			addCriterion("UUID between", value1, value2, "uuid");
			return (Criteria) this;
		}

		public Criteria andUuidNotBetween(String value1, String value2) {
			addCriterion("UUID not between", value1, value2, "uuid");
			return (Criteria) this;
		}

		public Criteria andFilenameIsNull() {
			addCriterion("FILENAME is null");
			return (Criteria) this;
		}

		public Criteria andFilenameIsNotNull() {
			addCriterion("FILENAME is not null");
			return (Criteria) this;
		}

		public Criteria andFilenameEqualTo(String value) {
			addCriterion("FILENAME =", value, "filename");
			return (Criteria) this;
		}

		public Criteria andFilenameNotEqualTo(String value) {
			addCriterion("FILENAME <>", value, "filename");
			return (Criteria) this;
		}

		public Criteria andFilenameGreaterThan(String value) {
			addCriterion("FILENAME >", value, "filename");
			return (Criteria) this;
		}

		public Criteria andFilenameGreaterThanOrEqualTo(String value) {
			addCriterion("FILENAME >=", value, "filename");
			return (Criteria) this;
		}

		public Criteria andFilenameLessThan(String value) {
			addCriterion("FILENAME <", value, "filename");
			return (Criteria) this;
		}

		public Criteria andFilenameLessThanOrEqualTo(String value) {
			addCriterion("FILENAME <=", value, "filename");
			return (Criteria) this;
		}

		public Criteria andFilenameLike(String value) {
			addCriterion("FILENAME like", value, "filename");
			return (Criteria) this;
		}

		public Criteria andFilenameNotLike(String value) {
			addCriterion("FILENAME not like", value, "filename");
			return (Criteria) this;
		}

		public Criteria andFilenameIn(List<String> values) {
			addCriterion("FILENAME in", values, "filename");
			return (Criteria) this;
		}

		public Criteria andFilenameNotIn(List<String> values) {
			addCriterion("FILENAME not in", values, "filename");
			return (Criteria) this;
		}

		public Criteria andFilenameBetween(String value1, String value2) {
			addCriterion("FILENAME between", value1, value2, "filename");
			return (Criteria) this;
		}

		public Criteria andFilenameNotBetween(String value1, String value2) {
			addCriterion("FILENAME not between", value1, value2, "filename");
			return (Criteria) this;
		}

		public Criteria andFilepathIsNull() {
			addCriterion("FILEPATH is null");
			return (Criteria) this;
		}

		public Criteria andFilepathIsNotNull() {
			addCriterion("FILEPATH is not null");
			return (Criteria) this;
		}

		public Criteria andFilepathEqualTo(String value) {
			addCriterion("FILEPATH =", value, "filepath");
			return (Criteria) this;
		}

		public Criteria andFilepathNotEqualTo(String value) {
			addCriterion("FILEPATH <>", value, "filepath");
			return (Criteria) this;
		}

		public Criteria andFilepathGreaterThan(String value) {
			addCriterion("FILEPATH >", value, "filepath");
			return (Criteria) this;
		}

		public Criteria andFilepathGreaterThanOrEqualTo(String value) {
			addCriterion("FILEPATH >=", value, "filepath");
			return (Criteria) this;
		}

		public Criteria andFilepathLessThan(String value) {
			addCriterion("FILEPATH <", value, "filepath");
			return (Criteria) this;
		}

		public Criteria andFilepathLessThanOrEqualTo(String value) {
			addCriterion("FILEPATH <=", value, "filepath");
			return (Criteria) this;
		}

		public Criteria andFilepathLike(String value) {
			addCriterion("FILEPATH like", value, "filepath");
			return (Criteria) this;
		}

		public Criteria andFilepathNotLike(String value) {
			addCriterion("FILEPATH not like", value, "filepath");
			return (Criteria) this;
		}

		public Criteria andFilepathIn(List<String> values) {
			addCriterion("FILEPATH in", values, "filepath");
			return (Criteria) this;
		}

		public Criteria andFilepathNotIn(List<String> values) {
			addCriterion("FILEPATH not in", values, "filepath");
			return (Criteria) this;
		}

		public Criteria andFilepathBetween(String value1, String value2) {
			addCriterion("FILEPATH between", value1, value2, "filepath");
			return (Criteria) this;
		}

		public Criteria andFilepathNotBetween(String value1, String value2) {
			addCriterion("FILEPATH not between", value1, value2, "filepath");
			return (Criteria) this;
		}

		public Criteria andUuidLikeInsensitive(String value) {
			addCriterion("upper(UUID) like", value.toUpperCase(), "uuid");
			return (Criteria) this;
		}

		public Criteria andFilenameLikeInsensitive(String value) {
			addCriterion("upper(FILENAME) like", value.toUpperCase(), "filename");
			return (Criteria) this;
		}

		public Criteria andFilepathLikeInsensitive(String value) {
			addCriterion("upper(FILEPATH) like", value.toUpperCase(), "filepath");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table FILE_INFO
	 * @mbg.generated  Tue Oct 23 16:48:47 CST 2018
	 */
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FILE_INFO
     *
     * @mbg.generated do_not_delete_during_merge Tue Oct 23 16:47:23 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}