package com.artistic_exam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import com.artistic_exam.ExaminationInfor_Outside.ExaminationInforOutside;
import com.artistic_exam.ExaminationInfor_Outside.ExaminationInforOutsideDAO;
import com.artistic_exam.ScoreSumma_Outside.ScoreSummaOutside;
import com.artistic_exam.ScoreSumma_Outside.ScoreSummaOutsideDAO;
import com.artistic_exam.sessionFactory.HibernateSessionFactory;

/**
 * Servlet implementation class InsertQuestionNum_Outside
 */
@WebServlet("/InsertQuestionNum_Outside")
public class InsertQuestionNum_Outside extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertQuestionNum_Outside() {
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
		String QusNum1 = request.getParameter("QusNum1");
		String QusNum2 = request.getParameter("QusNum2");
		String QusNum3 = request.getParameter("QusNum3");

		String msg = null;
		Session session = null;
		Transaction tran = null;

		if (RegNum == null || "".equals(RegNum) || QusNum1 == null
				|| "".equals(QusNum1) || QusNum2 == null || "".equals(QusNum2)
				|| QusNum3 == null || "".equals(QusNum3)) {
			msg = "fail";
		} else {
			try {
				session = HibernateSessionFactory.getSession();
				tran = session.beginTransaction();

				// ScoreSummaOutsideDAO sDao = new ScoreSummaOutsideDAO();
				// ScoreSummaOutside so = sDao.findById(RegNum);
				// if(so == null || so.getHeight() == null){
				// throw new Exception("Enter Height First!");
				// }

				QuestionBankDAO qDao = new QuestionBankDAO();
				QuestionBankId id = new QuestionBankId(QusNum1, "1");
				QuestionBank question1 = qDao.findById(id);
				id = new QuestionBankId(QusNum2, "2");
				QuestionBank question2 = qDao.findById(id);
				id = new QuestionBankId(QusNum3, "3");
				QuestionBank question3 = qDao.findById(id);
				if (question1 == null
						|| "".equals(question1.getQustionContent())
						|| question2 == null
						|| "".equals(question2.getQustionContent())
						|| question3 == null
						|| "".equals(question3.getQustionContent())) {
					throw new Exception("Error Question");
				}

				ExaminationInforOutsideDAO dao = new ExaminationInforOutsideDAO();
				ExaminationInforOutside ei = dao.findById(RegNum);
				//添加此处注释将允许题号修改覆盖
//				if (ei == null || ei.getQusNum1() != null
//						|| ei.getQusNum2() != null || ei.getQusNum3() != null) {
//					throw new Exception("Error RegNum");
//				} else {
					ei.setQusNum1(QusNum1);
					ei.setQusNum2(QusNum2);
					ei.setQusNum3(QusNum3);
					ei.setExamTime(getCurrentTime());

					dao.attachDirty(ei);
					tran.commit();
					msg = "success";
//				}

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

	private String getCurrentTime() {
		String date = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date curDate = new Date(System.currentTimeMillis());
		date = format.format(curDate);
		return date;
	}
}
