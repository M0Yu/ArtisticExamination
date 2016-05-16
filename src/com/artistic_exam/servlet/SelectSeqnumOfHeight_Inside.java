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

import com.artistic_exam.ExaminationInfor_Inside.ExaminationInforInside;
import com.artistic_exam.ExaminationInfor_Inside.ExaminationInforInsideDAO;
import com.artistic_exam.ScoreSumma_Inside.ScoreSummaInsideDAO;
import com.artistic_exam.sessionFactory.HibernateSessionFactory;

/**
 * Servlet implementation class SelectSeqnumOfHeight_Inside
 */
@WebServlet("/SelectSeqnumOfHeight_Inside")
public class SelectSeqnumOfHeight_Inside extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectSeqnumOfHeight_Inside() {
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

		String msg = "";
		Session session = null;

		try {
			session = HibernateSessionFactory.getSession();
			ExaminationInforInsideDAO eDao = new ExaminationInforInsideDAO();
			ScoreSummaInsideDAO sDao = new ScoreSummaInsideDAO();
			List<ExaminationInforInside> list = eDao.findAll();
			if (list.isEmpty()) {
				throw new Exception();
			}
			for (ExaminationInforInside ei : list) {
				String seqnum = ei.getId().getSeqNum();
				if (msg != null && msg.contains(seqnum)) {
					continue;
				}
				if (sDao.findById(seqnum) == null
						|| sDao.findById(seqnum).getHeight() == null) {
					if (!msg.equals("")) {
						msg += ";";
					}
					msg += seqnum;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			msg = "fail";
		} finally {
			session.close();
		}
		if (msg.equals("")) {
			msg = "fail";
		}
		PrintWriter out = response.getWriter();
		out.print(msg);
	}

}
