package com.artistic_exam.ExaminationInfor_Inside;

/**
 * AbstractExaminationInforInside entity provides the base persistence
 * definition of the ExaminationInforInside entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractExaminationInforInside implements
		java.io.Serializable {

	// Fields

	private ExaminationInforInsideId id;
	private String sessionNum;
	private String qusNum;
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
	public AbstractExaminationInforInside() {
	}

	/** minimal constructor */
	public AbstractExaminationInforInside(ExaminationInforInsideId id) {
		this.id = id;
	}

	/** full constructor */
	public AbstractExaminationInforInside(ExaminationInforInsideId id,
			String sessionNum, String qusNum, String examinerName1,
			Integer examinerScore1, String examinerName2,
			Integer examinerScore2, String examinerName3,
			Integer examinerScore3, String examinerName4,
			Integer examinerScore4, String examinerName5, Integer examinerScore5) {
		this.id = id;
		this.sessionNum = sessionNum;
		this.qusNum = qusNum;
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

	public ExaminationInforInsideId getId() {
		return this.id;
	}

	public void setId(ExaminationInforInsideId id) {
		this.id = id;
	}

	public String getSessionNum() {
		return this.sessionNum;
	}

	public void setSessionNum(String sessionNum) {
		this.sessionNum = sessionNum;
	}

	public String getQusNum() {
		return this.qusNum;
	}

	public void setQusNum(String qusNum) {
		this.qusNum = qusNum;
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