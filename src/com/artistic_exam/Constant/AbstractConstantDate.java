package com.artistic_exam.Constant;

/**
 * AbstractConstantDate entity provides the base persistence definition of the
 * ConstantDate entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractConstantDate implements java.io.Serializable {

	// Fields

	private String constantName;
	private String constantValue;
	private String constantDes;

	// Constructors

	/** default constructor */
	public AbstractConstantDate() {
	}

	/** minimal constructor */
	public AbstractConstantDate(String constantName) {
		this.constantName = constantName;
	}

	/** full constructor */
	public AbstractConstantDate(String constantName, String constantValue,
			String constantDes) {
		this.constantName = constantName;
		this.constantValue = constantValue;
		this.constantDes = constantDes;
	}

	// Property accessors

	public String getConstantName() {
		return this.constantName;
	}

	public void setConstantName(String constantName) {
		this.constantName = constantName;
	}

	public String getConstantValue() {
		return this.constantValue;
	}

	public void setConstantValue(String constantValue) {
		this.constantValue = constantValue;
	}

	public String getConstantDes() {
		return this.constantDes;
	}

	public void setConstantDes(String constantDes) {
		this.constantDes = constantDes;
	}

}