package com.artistic_exam.Workers;

/**
 * Workers entity. @author MyEclipse Persistence Tools
 */
public class Workers extends AbstractWorkers implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Workers() {
	}

	/** minimal constructor */
	public Workers(String name, String idenType) {
		super(name, idenType);
	}

	/** full constructor */
	public Workers(String name, String idenType, String qusType) {
		super(name, idenType, qusType);
	}

}
