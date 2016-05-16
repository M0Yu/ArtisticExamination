package com.artistic_exam.ScoreSumma_Outside;

/**
 * ScoreSummaOutside entity. @author MyEclipse Persistence Tools
 */
public class ScoreSummaOutside extends AbstractScoreSummaOutside implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public ScoreSummaOutside() {
	}

	/** minimal constructor */
	public ScoreSummaOutside(String regNum) {
		super(regNum);
	}

	/** full constructor */
	public ScoreSummaOutside(String regNum, Double sumScore, String height) {
		super(regNum, sumScore, height);
	}

}
