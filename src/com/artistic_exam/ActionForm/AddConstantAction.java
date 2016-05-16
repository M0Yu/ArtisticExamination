package com.artistic_exam.ActionForm;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.artistic_exam.Constant.ConstantDate;
import com.artistic_exam.Constant.ConstantDateDAO;
import com.artistic_exam.sessionFactory.HibernateSessionFactory;

public class AddConstantAction {

	private String constant_value;

	private String constant_name;

	private String constant_desc;

	public String getConstant_value() {
		return constant_value;
	}

	public void setConstant_value(String constant_value) {
		this.constant_value = constant_value;
	}

	public String getConstant_name() {
		return constant_name;
	}

	public void setConstant_name(String constant_name) {
		this.constant_name = constant_name;
	}

	public String getConstant_desc() {
		return constant_desc;
	}

	public void setConstant_desc(String constant_desc) {
		this.constant_desc = constant_desc;
	}

	public String execute() {

		Session session = HibernateSessionFactory.getSession();
		boolean sof = false;
		Transaction tran = session.beginTransaction();

		try {
			ConstantDateDAO dao = new ConstantDateDAO();
			ConstantDate constat = new ConstantDate(constant_name, constant_value,
					constant_desc);

			dao.save(constat);;
			tran.commit();

			sof = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			sof = false;
			tran.rollback();
		} finally {
			session.close();
		}

		if (sof) {
			return "success";
		}
		return "fail";
	}
}
