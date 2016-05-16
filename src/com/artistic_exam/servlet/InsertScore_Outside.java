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
 * Servlet implementation class InsertScore
 */
@WebServlet("/InsertScore_Outside")
public class InsertScore_Outside extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertScore_Outside() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected synchronized void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String[] RegNum = request.getParameterValues("RegNum");
		String ExaminerName = request.getParameter("ExaminerName");
		String[] ExaminerScoreString = request
				.getParameterValues("ExaminerScore");

		String msg = null;
		Session session = null;
		Transaction tran = null;

		if (RegNum == null || RegNum.length == 0 || ExaminerName == null
				|| "".equals(ExaminerName) || ExaminerScoreString == null
				|| ExaminerScoreString.length == 0) {
			msg = "fail";
		} else {
			try {
				session = HibernateSessionFactory.getSession();
				tran = session.beginTransaction();

				ExaminationInforOutsideDAO dao = new ExaminationInforOutsideDAO();

				for (int n = 0; n < RegNum.length; n++) {

					if ("".equals(RegNum[n])
							|| "".equals(ExaminerScoreString[n])) {
						throw new Exception();
					}

					int ExaminerScore = Integer
							.parseInt(ExaminerScoreString[n]);
					ExaminationInforOutside ei = dao.findById(RegNum[n]);
					if (ei == null) {
						throw new Exception();
					}

					if (ei.getExaminerName1() == null) {
						ei.setExaminerName1(ExaminerName);
						ei.setExaminerScore1(ExaminerScore);
					} else if (ei.getExaminerName2() == null) {
						ei.setExaminerName2(ExaminerName);
						ei.setExaminerScore2(ExaminerScore);
					} else if (ei.getExaminerName3() == null) {
						ei.setExaminerName3(ExaminerName);
						ei.setExaminerScore3(ExaminerScore);
					} else if (ei.getExaminerName4() == null) {
						ei.setExaminerName4(ExaminerName);
						ei.setExaminerScore4(ExaminerScore);
					} else if (ei.getExaminerName5() == null) {
						ei.setExaminerName5(ExaminerName);
						ei.setExaminerScore5(ExaminerScore);
					} else {
						throw new Exception();
					}

					dao.attachDirty(ei);

				}
				tran.commit();
				msg = "success";

			} catch (Exception e) {
				// TODO: handle exception
				msg = "fail";
				e.printStackTrace();
				tran.rollback();
			} finally {
				session.close();
			}
		}

		PrintWriter out = response.getWriter();
		out.print(msg);
	}
}
