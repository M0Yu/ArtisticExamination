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

import com.artistic_exam.ExaminationInfor_Inside.ExaminationInforInside;
import com.artistic_exam.ExaminationInfor_Inside.ExaminationInforInsideDAO;
import com.artistic_exam.ExaminationInfor_Inside.ExaminationInforInsideId;
import com.artistic_exam.sessionFactory.HibernateSessionFactory;

/**
 * Servlet implementation class InsertScore
 */
@WebServlet("/InsertScore_Inside")
public class InsertScore_Inside extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertScore_Inside() {
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

		String QusType = request.getParameter("QusType");
		String ExaminerName = request.getParameter("ExaminerName");
		String[] ExaminerScoreString = request
				.getParameterValues("ExaminerScore");
		String[] SeqNum = request.getParameterValues("SeqNum");

		String msg = null;
		Session session = null;
		Transaction tran = null;

		if (SeqNum == null || SeqNum.length == 0 || QusType == null
				|| "".equals(QusType) || ExaminerName == null
				|| "".equals(ExaminerName) || ExaminerScoreString == null
				|| ExaminerScoreString.length == 0) {
			msg = "fail";
		} else {
			try {
				session = HibernateSessionFactory.getSession();

				tran = session.beginTransaction();
				ExaminationInforInsideDAO dao = new ExaminationInforInsideDAO();
				for (int i = 0; i < SeqNum.length; i++) {
					
					if ("".equals(SeqNum[i])
							|| "".equals(ExaminerScoreString[i])) {
						throw new Exception();
					}

					int ExaminerScore = Integer
							.parseInt(ExaminerScoreString[i]);
					ExaminationInforInsideId id = new ExaminationInforInsideId(
							SeqNum[i], QusType);
					ExaminationInforInside ei = dao.findById(id);
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
