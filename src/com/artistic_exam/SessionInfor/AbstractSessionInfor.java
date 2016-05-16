package com.artistic_exam.SessionInfor;

/**
 * AbstractSessionInfor entity provides the base persistence definition of the
 * SessionInfor entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractSessionInfor implements java.io.Serializable {

	// Fields

	private String sessionNum;
	private String dateTime;
	private Integer personNum;

	// Constructors

	/** default constructor */
	public AbstractSessionInfor() {
	}

	/** minimal constructor */
	public AbstractSessionInfor(String sessionNum) {
		this.sessionNum = sessionNum;
	}

	/** full constructor */
	public AbstractSessionInfor(String sessionNum, String dateTime,
			Integer personNum) {
		this.sessionNum = sessionNum;
		this.dateTime = dateTime;
		this.personNum = personNum;
	}

	// Property accessors

	public String getSessionNum() {
		return this.sessionNum;
	}

	public void setSessionNum(String sessionNum) {
		this.sessionNum = sessionNum;
	}

	public String getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public Integer getPersonNum() {
		return this.personNum;
	}

	public void setPersonNum(Integer personNum) {
		this.personNum = personNum;
	}

}