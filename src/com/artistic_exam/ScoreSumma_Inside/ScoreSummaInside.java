package com.artistic_exam.ScoreSumma_Inside;

/**
 * ScoreSummaInside entity. @author MyEclipse Persistence Tools
 */
public class ScoreSummaInside extends AbstractScoreSummaInside implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public ScoreSummaInside() {
	}

	/** minimal constructor */
	public ScoreSummaInside(String seqNum) {
		super(seqNum);
	}

	/** full constructor */
	public ScoreSummaInside(String seqNum, Double qusType1score,
			Double qusType2score, Double qusType3score, Double sumScore,
			String height) {
		super(seqNum, qusType1score, qusType2score, qusType3score, sumScore,
				height);
	}

}
