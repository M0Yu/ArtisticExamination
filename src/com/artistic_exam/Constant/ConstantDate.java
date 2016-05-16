package com.artistic_exam.Constant;

/**
 * ConstantDate entity. @author MyEclipse Persistence Tools
 */
public class ConstantDate extends AbstractConstantDate implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public ConstantDate() {
	}

	/** minimal constructor */
	public ConstantDate(String constantName) {
		super(constantName);
	}

	/** full constructor */
	public ConstantDate(String constantName, String constantValue,
			String constantDes) {
		super(constantName, constantValue, constantDes);
	}

}
