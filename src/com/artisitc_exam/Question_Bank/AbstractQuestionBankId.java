package com.artisitc_exam.Question_Bank;

/**
 * AbstractQuestionBankId entity provides the base persistence definition of the
 * QuestionBankId entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractQuestionBankId implements java.io.Serializable {

	// Fields

	private String qusNum;
	private String qustionType;

	// Constructors

	/** default constructor */
	public AbstractQuestionBankId() {
	}

	/** full constructor */
	public AbstractQuestionBankId(String qusNum, String qustionType) {
		this.qusNum = qusNum;
		this.qustionType = qustionType;
	}

	// Property accessors

	public String getQusNum() {
		return this.qusNum;
	}

	public void setQusNum(String qusNum) {
		this.qusNum = qusNum;
	}

	public String getQustionType() {
		return this.qustionType;
	}

	public void setQustionType(String qustionType) {
		this.qustionType = qustionType;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AbstractQuestionBankId))
			return false;
		AbstractQuestionBankId castOther = (AbstractQuestionBankId) other;

		return ((this.getQusNum() == castOther.getQusNum()) || (this
				.getQusNum() != null && castOther.getQusNum() != null && this
				.getQusNum().equals(castOther.getQusNum())))
				&& ((this.getQustionType() == castOther.getQustionType()) || (this
						.getQustionType() != null
						&& castOther.getQustionType() != null && this
						.getQustionType().equals(castOther.getQustionType())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getQusNum() == null ? 0 : this.getQusNum().hashCode());
		result = 37
				* result
				+ (getQustionType() == null ? 0 : this.getQustionType()
						.hashCode());
		return result;
	}

}