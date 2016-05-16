package com.artistic_exam.SessionInfor;

/**
 * SessionInfor entity. @author MyEclipse Persistence Tools
 */
public class SessionInfor extends AbstractSessionInfor implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public SessionInfor() {
	}

	/** minimal constructor */
	public SessionInfor(String sessionNum) {
		super(sessionNum);
	}

	/** full constructor */
	public SessionInfor(String sessionNum, String dateTime, Integer personNum) {
		super(sessionNum, dateTime, personNum);
	}

}
