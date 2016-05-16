package com.artistic_exam.ActionForm;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.artistic_exam.Workers.Workers;
import com.artistic_exam.Workers.WorkersDAO;
import com.artistic_exam.sessionFactory.HibernateSessionFactory;

public class InsertWorkersAction {
	private String IdenType;
	private String Name;
	private String QusType;

	public String getIdenType() {
		return IdenType;
	}

	public void setIdenType(String idenType) {
		IdenType = idenType;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getQusType() {
		return QusType;
	}

	public void setQusType(String qusType) {
		QusType = qusType;
	}

	public String execute() {	
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();

		boolean sof = false;
		try {

			WorkersDAO dao = new WorkersDAO();
			Workers worker = new Workers(Name, IdenType, QusType);

			dao.save(worker);

			tran.commit();
			sof = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
