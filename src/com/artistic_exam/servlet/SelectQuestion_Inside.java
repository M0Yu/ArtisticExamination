package com.artistic_exam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.artisitc_exam.Question_Bank.QuestionBank;
import com.artisitc_exam.Question_Bank.QuestionBankDAO;
import com.artisitc_exam.Question_Bank.QuestionBankId;
import com.artistic_exam.ExaminationInfor_Inside.ExaminationInforInside;
import com.artistic_exam.ExaminationInfor_Inside.ExaminationInforInsideDAO;
import com.artistic_exam.ExaminationInfor_Inside.ExaminationInforInsideId;
import com.artistic_exam.sessionFactory.HibernateSessionFactory;

/**
 * Servlet implementation class SelectQuestionNum
 */
@WebServlet("/SelectQuestion_Inside")
public class SelectQuestion_Inside extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectQuestion_Inside() {
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
		response.setContentType("text/html;charset=utf-8");

		String SeqNum = request.getParameter("SeqNum");
		String QusType = request.getParameter("QusType");

		String msg = null;
		Session session = null;

		if (SeqNum == null || "".equals(SeqNum) || QusType == null
				|| "".equals(QusType)) {
			msg = "fail";
		} else {
			try {
				session = HibernateSessionFactory.getSession();

				ExaminationInforInsideDAO dao = new ExaminationInforInsideDAO();
				ExaminationInforInsideId id = new ExaminationInforInsideId(
						SeqNum, QusType);
				ExaminationInforInside ei = dao.findById(id);
				if (ei == null || ei.getQusNum() == null) {
					throw new Exception("Error SeqNum");
				}
				if (ei.getExaminerScore1() != null) {
					throw new Exception("Scores Exist");
				}
				QuestionBankDAO bDao = new QuestionBankDAO();
				QuestionBankId qid = new QuestionBankId(ei.getQusNum(), QusType);
				QuestionBank qb = bDao.findById(qid);
				if (qb == null) {
					throw new Exception("Error QusNum");
				}
				msg = qb.getQustionContent();
			} catch (Exception e) {
				// TODO: handle exception
				msg = e.getMessage();
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
		PrintWriter out = response.getWriter();
		out.print(msg);
	}

}
