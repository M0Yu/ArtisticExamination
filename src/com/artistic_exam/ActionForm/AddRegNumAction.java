package com.artistic_exam.ActionForm;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.artistic_exam.ExaminationInfor_Outside.ExaminationInforOutside;
import com.artistic_exam.ExaminationInfor_Outside.ExaminationInforOutsideDAO;
import com.artistic_exam.sessionFactory.HibernateSessionFactory;

public class AddRegNumAction {

	private String headNo;

	private String startNo;

	private String endNo;

	public String getHeadNo() {
		return headNo;
	}

	public void setHeadNo(String headNo) {
		this.headNo = headNo;
	}

	public String getStartNo() {
		return startNo;
	}

	public void setStartNo(String startNo) {
		this.startNo = startNo;
	}

	public String getEndNo() {
		return endNo;
	}

	public void setEndNo(String endNo) {
		this.endNo = endNo;
	}

	public String execute() {
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();

		boolean sof = false;
		try {
			sof = insertRegNum();
			
			tran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tran.rollback();
			sof = false;
		}

		if (sof)
			return "success";
		return "fail";
	}

	private boolean insertRegNum() throws Exception {
		// TODO Auto-generated method stub
		ExaminationInforOutsideDAO dao = new ExaminationInforOutsideDAO();
		ExaminationInforOutside eio = null;

		int start = Integer.parseInt(startNo);
		int end = Integer.parseInt(endNo);

		while (start <= end) {
			String no = String.format(headNo + "%04d", start);

			eio = new ExaminationInforOutside(no);
			dao.save(eio);

			start++;
		}

		return true;
	}
}
