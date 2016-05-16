package com.artistic_exam.ExaminationInfor_Outside;

/**
 * AbstractExaminationInforOutside entity provides the base persistence
 * definition of the ExaminationInforOutside entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractExaminationInforOutside implements
		java.io.Serializable {

	// Fields

	private String regNum;
	private String examTime;
	private String qusNum1;
	private String qusNum2;
	private String qusNum3;
	private String examinerName1;
	private Integer examinerScore1;
	private String examinerName2;
	private Integer examinerScore2;
	private String examinerName3;
	private Integer examinerScore3;
	private String examinerName4;
	private Integer examinerScore4;
	private String examinerName5;
	private Integer examinerScore5;

	// Constructors

	/** default constructor */
	public AbstractExaminationInforOutside() {
	}

	/** minimal constructor */
	public AbstractExaminationInforOutside(String regNum) {
		this.regNum = regNum;
	}

	/** full constructor */
	public AbstractExaminationInforOutside(String regNum, String examTime,
			String qusNum1, String qusNum2, String qusNum3,
			String examinerName1, Integer examinerScore1, String examinerName2,
			Integer examinerScore2, String examinerName3,
			Integer examinerScore3, String examinerName4,
			Integer examinerScore4, String examinerName5, Integer examinerScore5) {
		this.regNum = regNum;
		this.examTime = examTime;
		this.qusNum1 = qusNum1;
		this.qusNum2 = qusNum2;
		this.qusNum3 = qusNum3;
		this.examinerName1 = examinerName1;
		this.examinerScore1 = examinerScore1;
		this.examinerName2 = examinerName2;
		this.examinerScore2 = examinerScore2;
		this.examinerName3 = examinerName3;
		this.examinerScore3 = examinerScore3;
		this.examinerName4 = examinerName4;
		this.examinerScore4 = examinerScore4;
		this.examinerName5 = examinerName5;
		this.examinerScore5 = examinerScore5;
	}

	// Property accessors

	public String getRegNum() {
		return this.regNum;
	}

	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}

	public String getExamTime() {
		return this.examTime;
	}

	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}

	public String getQusNum1() {
		return this.qusNum1;
	}

	public void setQusNum1(String qusNum1) {
		this.qusNum1 = qusNum1;
	}

	public String getQusNum2() {
		return this.qusNum2;
	}

	public void setQusNum2(String qusNum2) {
		this.qusNum2 = qusNum2;
	}

	public String getQusNum3() {
		return this.qusNum3;
	}

	public void setQusNum3(String qusNum3) {
		this.qusNum3 = qusNum3;
	}

	public String getExaminerName1() {
		return this.examinerName1;
	}

	public void setExaminerName1(String examinerName1) {
		this.examinerName1 = examinerName1;
	}

	public Integer getExaminerScore1() {
		return this.examinerScore1;
	}

	public void setExaminerScore1(Integer examinerScore1) {
		this.examinerScore1 = examinerScore1;
	}

	public String getExaminerName2() {
		return this.examinerName2;
	}

	public void setExaminerName2(String examinerName2) {
		this.examinerName2 = examinerName2;
	}

	public Integer getExaminerScore2() {
		return this.examinerScore2;
	}

	public void setExaminerScore2(Integer examinerScore2) {
		this.examinerScore2 = examinerScore2;
	}

	public String getExaminerName3() {
		return this.examinerName3;
	}

	public void setExaminerName3(String examinerName3) {
		this.examinerName3 = examinerName3;
	}

	public Integer getExaminerScore3() {
		return this.examinerScore3;
	}

	public void setExaminerScore3(Integer examinerScore3) {
		this.examinerScore3 = examinerScore3;
	}

	public String getExaminerName4() {
		return this.examinerName4;
	}

	public void setExaminerName4(String examinerName4) {
		this.examinerName4 = examinerName4;
	}

	public Integer getExaminerScore4() {
		return this.examinerScore4;
	}

	public void setExaminerScore4(Integer examinerScore4) {
		this.examinerScore4 = examinerScore4;
	}

	public String getExaminerName5() {
		return this.examinerName5;
	}

	public void setExaminerName5(String examinerName5) {
		this.examinerName5 = examinerName5;
	}

	public Integer getExaminerScore5() {
		return this.examinerScore5;
	}

	public void setExaminerScore5(Integer examinerScore5) {
		this.examinerScore5 = examinerScore5;
	}

}