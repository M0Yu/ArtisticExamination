package com.artistic_exam.ActionForm;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.artistic_exam.Workers.Workers;
import com.artistic_exam.Workers.WorkersDAO;
import com.artistic_exam.sessionFactory.HibernateSessionFactory;

public class DeleteWorkersAction {
	private String Name;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String execute() {

		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();

		boolean sof = false;
		try {
			if ("all".equals(Name))
				sof = deleteAll();
			else
				sof = deleteObject(Name);

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
		WorkersDAO dao = new WorkersDAO();
		Workers worker = dao.findById(id);
		if (worker == null)
			throw new Exception();
		dao.delete(worker);

		return true;
	}

	private boolean deleteAll() throws Exception {
		WorkersDAO dao = new WorkersDAO();
		@SuppressWarnings("unchecked")
		List<Workers> workers = dao.findAll();

		for (Workers worker : workers) {
			dao.delete(worker);
		}

		return true;
	}
}
