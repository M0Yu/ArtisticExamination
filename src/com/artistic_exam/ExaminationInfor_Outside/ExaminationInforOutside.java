package com.artistic_exam.ExaminationInfor_Outside;

/**
 * ExaminationInforOutside entity. @author MyEclipse Persistence Tools
 */
public class ExaminationInforOutside extends AbstractExaminationInforOutside
		implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public ExaminationInforOutside() {
	}

	/** minimal constructor */
	public ExaminationInforOutside(String regNum) {
		super(regNum);
	}

	/** full constructor */
	public ExaminationInforOutside(String regNum, String examTime,
			String qusNum1, String qusNum2, String qusNum3,
			String examinerName1, Integer examinerScore1, String examinerName2,
			Integer examinerScore2, String examinerName3,
			Integer examinerScore3, String examinerName4,
			Integer examinerScore4, String examinerName5, Integer examinerScore5) {
		super(regNum, examTime, qusNum1, qusNum2, qusNum3, examinerName1,
				examinerScore1, examinerName2, examinerScore2, examinerName3,
				examinerScore3, examinerName4, examinerScore4, examinerName5,
				examinerScore5);
	}

}
