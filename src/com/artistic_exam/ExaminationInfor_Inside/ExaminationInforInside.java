package com.artistic_exam.ExaminationInfor_Inside;

/**
 * ExaminationInforInside entity. @author MyEclipse Persistence Tools
 */
public class ExaminationInforInside extends AbstractExaminationInforInside
		implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public ExaminationInforInside() {
	}

	/** minimal constructor */
	public ExaminationInforInside(ExaminationInforInsideId id) {
		super(id);
	}

	/** full constructor */
	public ExaminationInforInside(ExaminationInforInsideId id,
			String sessionNum, String qusNum, String examinerName1,
			Integer examinerScore1, String examinerName2,
			Integer examinerScore2, String examinerName3,
			Integer examinerScore3, String examinerName4,
			Integer examinerScore4, String examinerName5, Integer examinerScore5) {
		super(id, sessionNum, qusNum, examinerName1, examinerScore1,
				examinerName2, examinerScore2, examinerName3, examinerScore3,
				examinerName4, examinerScore4, examinerName5, examinerScore5);
	}

}
