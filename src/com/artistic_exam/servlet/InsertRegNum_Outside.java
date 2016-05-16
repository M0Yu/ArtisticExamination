package com.artistic_exam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.artistic_exam.ExaminationInfor_Outside.ExaminationInforOutside;
import com.artistic_exam.ExaminationInfor_Outside.ExaminationInforOutsideDAO;
import com.artistic_exam.sessionFactory.HibernateSessionFactory;

/**
 * Servlet implementation class InsertRegNum_Outside
 */
@WebServlet("/InsertRegNum_Outside")
public class InsertRegNum_Outside extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertRegNum_Outside() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/htm;charset=utf-8");

		String RegNum = request.getParameter("RegNum");

		String msg = null;
		Session session = null;
		Transaction tran = null;

		if (RegNum == null || "".equals(RegNum)) {
			msg = "fail";
		} else {
			try {
				session = HibernateSessionFactory.getSession();
				tran = session.beginTransaction();

				ExaminationInforOutsideDAO dao = new ExaminationInforOutsideDAO();
				ExaminationInforOutside ei = new ExaminationInforOutside(RegNum);
				dao.save(ei);

				tran.commit();
				msg = "success";
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				tran.rollback();
				msg = "fail";
			} finally {
				session.close();
			}
		}

		PrintWriter out = response.getWriter();
		out.print(msg);
	}

}
