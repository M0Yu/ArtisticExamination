package com.artistic_exam.ExaminationInfor_Inside;

/**
 * AbstractExaminationInforInsideId entity provides the base persistence
 * definition of the ExaminationInforInsideId entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractExaminationInforInsideId implements
		java.io.Serializable {

	// Fields

	private String seqNum;
	private String qusType;

	// Constructors

	/** default constructor */
	public AbstractExaminationInforInsideId() {
	}

	/** full constructor */
	public AbstractExaminationInforInsideId(String seqNum, String qusType) {
		this.seqNum = seqNum;
		this.qusType = qusType;
	}

	// Property accessors

	public String getSeqNum() {
		return this.seqNum;
	}

	public void setSeqNum(String seqNum) {
		this.seqNum = seqNum;
	}

	public String getQusType() {
		return this.qusType;
	}

	public void setQusType(String qusType) {
		this.qusType = qusType;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AbstractExaminationInforInsideId))
			return false;
		AbstractExaminationInforInsideId castOther = (AbstractExaminationInforInsideId) other;

		return ((this.getSeqNum() == castOther.getSeqNum()) || (this
				.getSeqNum() != null && castOther.getSeqNum() != null && this
				.getSeqNum().equals(castOther.getSeqNum())))
				&& ((this.getQusType() == castOther.getQusType()) || (this
						.getQusType() != null && castOther.getQusType() != null && this
						.getQusType().equals(castOther.getQusType())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getSeqNum() == null ? 0 : this.getSeqNum().hashCode());
		result = 37 * result
				+ (getQusType() == null ? 0 : this.getQusType().hashCode());
		return result;
	}

}