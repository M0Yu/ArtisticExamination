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

import com.artisitc_exam.Question_Bank.QuestionBank;
import com.artisitc_exam.Question_Bank.QuestionBankDAO;
import com.artisitc_exam.Question_Bank.QuestionBankId;
import com.artistic_exam.ExaminationInfor_Inside.ExaminationInforInside;
import com.artistic_exam.ExaminationInfor_Inside.ExaminationInforInsideDAO;
import com.artistic_exam.ExaminationInfor_Inside.ExaminationInforInsideId;
import com.artistic_exam.sessionFactory.HibernateSessionFactory;

/**
 * Servlet implementation class InsertQuesionNum
 */
@WebServlet("/InsertQuestionNum_Inside")
public class InsertQuestionNum_Inside extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertQuestionNum_Inside() {
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
		String QusNum = request.getParameter("QusNum");

		String msg = null;
		Session session = null;
		Transaction tran = null;

		if (SeqNum == null || "".equals(SeqNum) || QusType == null
				|| "".equals(QusType) || QusNum == null || "".equals(QusNum)) {
			msg = "fail";
		} else {
			try {
				session = HibernateSessionFactory.getSession();
				tran = session.beginTransaction();

				// 对题库的搜索，不需要事务
				QuestionBankDAO qDao = new QuestionBankDAO();
				QuestionBankId id = new QuestionBankId(QusNum, QusType);
				QuestionBank question = qDao.findById(id);
				if (question == null || "".equals(question.getQustionContent())) {
					throw new Exception("Error Question");
				}

				ExaminationInforInsideDAO dao = new ExaminationInforInsideDAO();
				ExaminationInforInsideId eid = new ExaminationInforInsideId(
						SeqNum, QusType);
				ExaminationInforInside ei = dao.findById(eid);
				if (ei == null ){//|| ei.getQusNum() != null) {		添加此处注释将允许题号修改覆盖
					throw new Exception("Error SeqNum");
				}
				ei.setQusNum(QusNum);
				dao.attachDirty(ei);

				tran.commit();
				msg = "success";
			} catch (Exception e) {
				// TODO: handle exception
				msg = e.getMessage();
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
