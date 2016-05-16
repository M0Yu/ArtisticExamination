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
import org.hibernate.Transaction;

import com.artistic_exam.ExaminationInfor_Outside.ExaminationInforOutside;
import com.artistic_exam.ExaminationInfor_Outside.ExaminationInforOutsideDAO;
import com.artistic_exam.ScoreSumma_Outside.ScoreSummaOutside;
import com.artistic_exam.ScoreSumma_Outside.ScoreSummaOutsideDAO;
import com.artistic_exam.sessionFactory.HibernateSessionFactory;

/**
 * Servlet implementation class GetSumScore_Outside
 */
@WebServlet("/GetSumScore_Outside")
public class GetSumScore_Outside extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetSumScore_Outside() {
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
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String msg = null;
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();

		ExaminationInforOutsideDAO dao = new ExaminationInforOutsideDAO();
		ScoreSummaOutsideDAO sDao = new ScoreSummaOutsideDAO();

		try {
			ScoreSummaOutside so = null;
			List<ExaminationInforOutside> list = dao.findAll();
			for (ExaminationInforOutside ei : list) {
				so = sDao.findById(ei.getRegNum());
				if (getAvgScore(ei) != -1) {
					if (so == null) {
						so = new ScoreSummaOutside(ei.getRegNum());
					}
					so.setSumScore(getAvgScore(ei));
				}

				sDao.attachDirty(so);
			}

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

		response.sendRedirect("outside/checkscores.jsp");
	}

	private double getAvgScore(ExaminationInforOutside ei) {
		int p = 0;
		int sum = 0;
		double avg = 0;
		if (ei.getExaminerScore1() != null) {
			sum += ei.getExaminerScore1();
			p++;
		}
		if (ei.getExaminerScore2() != null) {
			sum += ei.getExaminerScore2();
			p++;
		}
		if (ei.getExaminerScore3() != null) {
			sum += ei.getExaminerScore3();
			p++;
		}
		if (ei.getExaminerScore4() != null) {
			sum += ei.getExaminerScore4();
			p++;
		}
		if (ei.getExaminerScore5() != null) {
			sum += ei.getExaminerScore5();
			p++;
		}
		if (p == 0) {
			return -1;
		}
		avg = (double) ((sum + 0.0) / p);
		return avg;
	}
}
