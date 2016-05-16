package com.artistic_exam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.artisitc_exam.Question_Bank.QuestionBank;
import com.artisitc_exam.Question_Bank.QuestionBankDAO;
import com.artisitc_exam.Question_Bank.QuestionBankId;
import com.artistic_exam.ExaminationInfor_Outside.ExaminationInforOutside;
import com.artistic_exam.ExaminationInfor_Outside.ExaminationInforOutsideDAO;
import com.artistic_exam.sessionFactory.HibernateSessionFactory;

/**
 * Servlet implementation class SelectQuestionNum_Outside
 */
@WebServlet("/SelectQuestion_Outside")
public class SelectQuestion_Outside extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectQuestion_Outside() {
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

		String RegNum = request.getParameter("RegNum");

		String msg = "";
		Session session = null;

		if (RegNum == null || "".equals(RegNum)) {
			msg = "fail";
		} else {
			try {
				session = HibernateSessionFactory.getSession();

				ExaminationInforOutsideDAO dao = new ExaminationInforOutsideDAO();
				QuestionBankDAO qDao = new QuestionBankDAO();

				ExaminationInforOutside ei = dao.findById(RegNum);

				if (ei == null || ei.getQusNum1() == null) {
					throw new Exception("Error RegNum"); // 未找到该ID
				} else if (ei.getExaminerName1() != null) {
					throw new Exception("Scores Exist"); // 已经录入了分数
				} else {
					QuestionBankId id = new QuestionBankId(ei.getQusNum1(), "1");
					QuestionBank question = qDao.findById(id);
					if (question == null
							|| "".equals(question.getQustionContent()))
						throw new Exception("Error QusNum");
					msg = question.getQustionContent();

					id = new QuestionBankId(ei.getQusNum2(), "2");
					question = qDao.findById(id);
					if (question == null
							|| "".equals(question.getQustionContent()))
						throw new Exception("Error QusNum");
					msg += ";" + question.getQustionContent();

					id = new QuestionBankId(ei.getQusNum3(), "3");
					question = qDao.findById(id);
					if (question == null
							|| "".equals(question.getQustionContent()))
						throw new Exception("Error QusNum");
					msg += ";" + question.getQustionContent();
				}

			} catch (Exception e) {
				// TODO: handle exception
				msg = e.getMessage();
				e.printStackTrace();
			} finally {
				session.close();
				if (msg.equals("")) {
					msg = "fail";
				}
			}
		}
		PrintWriter out = response.getWriter();
		out.print(msg);
	}
}
