package com.artistic_exam.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.artisitc_exam.Question_Bank.QuestionBank;
import com.artisitc_exam.Question_Bank.QuestionBankDAO;
import com.artistic_exam.sessionFactory.HibernateSessionFactory;

/**
 * Servlet implementation class ClearQuestionBnak
 */
@WebServlet("/ClearQuestionBank")
public class ClearQuestionBank extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClearQuestionBank() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();

		boolean sof = false;
		try {
			sof = ClearAll();
			tran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			sof = false;
			e.printStackTrace();
			tran.rollback();
		} finally {
			session.close();
		}

		if (sof)
			response.sendRedirect("result_success.jsp?url=questionbank/indexofquestion.jsp");
		else
			response.sendRedirect("result_fail.jsp?url=questionbank/indexofquestion.jsp");
	}

	@SuppressWarnings("unchecked")
	private boolean ClearAll() {
		// TODO Auto-generated method stub
		QuestionBankDAO dao = new QuestionBankDAO();
		List<QuestionBank> bank = dao.findAll();

		if (bank.isEmpty())
			return true;

		for (QuestionBank question : bank) {
			dao.delete(question);
		}
		return true;
	}

}
