package com.artistic_exam.Workers;

/**
 * AbstractWorkers entity provides the base persistence definition of the
 * Workers entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractWorkers implements java.io.Serializable {

	// Fields

	private String name;
	private String idenType;
	private String qusType;

	// Constructors

	/** default constructor */
	public AbstractWorkers() {
	}

	/** minimal constructor */
	public AbstractWorkers(String name, String idenType) {
		this.name = name;
		this.idenType = idenType;
	}

	/** full constructor */
	public AbstractWorkers(String name, String idenType, String qusType) {
		this.name = name;
		this.idenType = idenType;
		this.qusType = qusType;
	}

	// Property accessors

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdenType() {
		return this.idenType;
	}

	public void setIdenType(String idenType) {
		this.idenType = idenType;
	}

	public String getQusType() {
		return this.qusType;
	}

	public void setQusType(String qusType) {
		this.qusType = qusType;
	}

}