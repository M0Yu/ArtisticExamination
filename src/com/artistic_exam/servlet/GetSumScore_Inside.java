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

import com.artistic_exam.ExaminationInfor_Inside.ExaminationInforInside;
import com.artistic_exam.ExaminationInfor_Inside.ExaminationInforInsideDAO;
import com.artistic_exam.ScoreSumma_Inside.ScoreSummaInside;
import com.artistic_exam.ScoreSumma_Inside.ScoreSummaInsideDAO;
import com.artistic_exam.sessionFactory.HibernateSessionFactory;

/**
 * Servlet implementation class GetSumScore_Inside
 */
@WebServlet("/GetSumScore_Inside")
public class GetSumScore_Inside extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetSumScore_Inside() {
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

		//String msg = null;
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();

		ExaminationInforInsideDAO dao = new ExaminationInforInsideDAO();
		ScoreSummaInsideDAO sDao = new ScoreSummaInsideDAO();

		try {
			ScoreSummaInside si = null;
			List<ExaminationInforInside> list = dao.findAll();
			for (ExaminationInforInside ei : list) {
				si = sDao.findById(ei.getId().getSeqNum());
				if (si == null) {
					si = new ScoreSummaInside(ei.getId().getSeqNum());
				}
				if ("1".equals(ei.getId().getQusType())) {
					if (getAvgScore(ei) != -1) {
						si.setQusType1score(getAvgScore(ei));
					} else {
						continue;
					}
				} else if ("2".equals(ei.getId().getQusType())) {
					if (getAvgScore(ei) != -1) {
						si.setQusType2score(getAvgScore(ei));
					} else {
						continue;
					}
				} else if ("3".equals(ei.getId().getQusType())) {
					if (getAvgScore(ei) != -1) {
						si.setQusType3score(getAvgScore(ei));
					} else {
						continue;
					}
				}
				sDao.attachDirty(si);
			}
			setSumScore(sDao);

			tran.commit();
			//msg = "success";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tran.rollback();
			//msg = "fail";
		} finally {
			session.close();
		}

		response.sendRedirect("inside/checkscores.jsp");
		//PrintWriter out = response.getWriter();
		//out.print(msg);
	}

	@SuppressWarnings("unchecked")
	private void setSumScore(ScoreSummaInsideDAO dao) {
		List<ScoreSummaInside> list = dao.findAll();
		for (ScoreSummaInside si : list) {
			if (si.getQusType1score() != null && si.getQusType2score() != null
					&& si.getQusType3score() != null) {
				double sumScore = si.getQusType1score() * 0.3
						+ si.getQusType2score() * 0.3 + si.getQusType3score()
						* 0.4;
				si.setSumScore(sumScore);
			}
			dao.attachDirty(si);
		}
	}

	private double getAvgScore(ExaminationInforInside ei) {
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
