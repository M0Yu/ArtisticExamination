package com.artistic_exam.ScoreSumma_Outside;

/**
 * AbstractScoreSummaOutside entity provides the base persistence definition of
 * the ScoreSummaOutside entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractScoreSummaOutside implements java.io.Serializable {

	// Fields

	private String regNum;
	private Double sumScore;
	private String height;

	// Constructors

	/** default constructor */
	public AbstractScoreSummaOutside() {
	}

	/** minimal constructor */
	public AbstractScoreSummaOutside(String regNum) {
		this.regNum = regNum;
	}

	/** full constructor */
	public AbstractScoreSummaOutside(String regNum, Double sumScore,
			String height) {
		this.regNum = regNum;
		this.sumScore = sumScore;
		this.height = height;
	}

	// Property accessors

	public String getRegNum() {
		return this.regNum;
	}

	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}

	public Double getSumScore() {
		return this.sumScore;
	}

	public void setSumScore(Double sumScore) {
		this.sumScore = sumScore;
	}

	public String getHeight() {
		return this.height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

}