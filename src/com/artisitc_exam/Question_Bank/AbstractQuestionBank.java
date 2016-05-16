package com.artisitc_exam.Question_Bank;

/**
 * AbstractQuestionBank entity provides the base persistence definition of the
 * QuestionBank entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractQuestionBank implements java.io.Serializable {

	// Fields

	private QuestionBankId id;
	private String qustionContent;

	// Constructors

	/** default constructor */
	public AbstractQuestionBank() {
	}

	/** minimal constructor */
	public AbstractQuestionBank(QuestionBankId id) {
		this.id = id;
	}

	/** full constructor */
	public AbstractQuestionBank(QuestionBankId id, String qustionContent) {
		this.id = id;
		this.qustionContent = qustionContent;
	}

	// Property accessors

	public QuestionBankId getId() {
		return this.id;
	}

	public void setId(QuestionBankId id) {
		this.id = id;
	}

	public String getQustionContent() {
		return this.qustionContent;
	}

	public void setQustionContent(String qustionContent) {
		this.qustionContent = qustionContent;
	}

}