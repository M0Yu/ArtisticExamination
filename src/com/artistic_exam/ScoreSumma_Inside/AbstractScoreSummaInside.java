package com.artistic_exam.ScoreSumma_Inside;

/**
 * AbstractScoreSummaInside entity provides the base persistence definition of
 * the ScoreSummaInside entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractScoreSummaInside implements java.io.Serializable {

	// Fields

	private String seqNum;
	private Double qusType1score;
	private Double qusType2score;
	private Double qusType3score;
	private Double sumScore;
	private String height;

	// Constructors

	/** default constructor */
	public AbstractScoreSummaInside() {
	}

	/** minimal constructor */
	public AbstractScoreSummaInside(String seqNum) {
		this.seqNum = seqNum;
	}

	/** full constructor */
	public AbstractScoreSummaInside(String seqNum, Double qusType1score,
			Double qusType2score, Double qusType3score, Double sumScore,
			String height) {
		this.seqNum = seqNum;
		this.qusType1score = qusType1score;
		this.qusType2score = qusType2score;
		this.qusType3score = qusType3score;
		this.sumScore = sumScore;
		this.height = height;
	}

	// Property accessors

	public String getSeqNum() {
		return this.seqNum;
	}

	public void setSeqNum(String seqNum) {
		this.seqNum = seqNum;
	}

	public Double getQusType1score() {
		return this.qusType1score;
	}

	public void setQusType1score(Double qusType1score) {
		this.qusType1score = qusType1score;
	}

	public Double getQusType2score() {
		return this.qusType2score;
	}

	public void setQusType2score(Double qusType2score) {
		this.qusType2score = qusType2score;
	}

	public Double getQusType3score() {
		return this.qusType3score;
	}

	public void setQusType3score(Double qusType3score) {
		this.qusType3score = qusType3score;
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