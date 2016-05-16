package com.artistic_exam.ActionForm;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.artistic_exam.Constant.ConstantDate;
import com.artistic_exam.Constant.ConstantDateDAO;
import com.artistic_exam.sessionFactory.HibernateSessionFactory;

public class DeleteConstantAction {

	private String constant_name;

	public String getConstant_name() {
		return constant_name;
	}

	public void setConstant_name(String constant_name) {
		this.constant_name = constant_name;
	}

	public String execute() {
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();

		boolean sof = false;
		try {
			if ("all".equals(constant_name))
				sof = deleteAll();
			else
				sof = deleteObject(constant_name);

			tran.commit();
			sof = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tran.rollback();
			sof = false;
		} finally {
			session.close();
		}

		if (sof)
			return "success";
		return "false";
	}

	private boolean deleteObject(String id) throws Exception {
		ConstantDateDAO dao = new ConstantDateDAO();
		ConstantDate constant = dao.findById(id);
		if (constant == null)
			throw new Exception();
		dao.delete(constant);

		return true;
	}

	private boolean deleteAll() throws Exception {
		ConstantDateDAO dao = new ConstantDateDAO();
		@SuppressWarnings("unchecked")
		List<ConstantDate> constants = dao.findAll();

		for (ConstantDate constant : constants) {
			dao.delete(constant);
		}

		return true;
	}
}
