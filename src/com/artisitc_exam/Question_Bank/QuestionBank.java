package com.artisitc_exam.Question_Bank;

/**
 * QuestionBank entity. @author MyEclipse Persistence Tools
 */
public class QuestionBank extends AbstractQuestionBank implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public QuestionBank() {
	}

	/** minimal constructor */
	public QuestionBank(QuestionBankId id) {
		super(id);
	}

	/** full constructor */
	public QuestionBank(QuestionBankId id, String qustionContent) {
		super(id, qustionContent);
	}

}
