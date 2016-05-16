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
import com.artistic_exam.sessionFactory.HibernateSessionFactory;

/**
 * Servlet implementation class SelectSeqnum_Inside
 */
@WebServlet("/SelectSeqnum_Inside")
public class SelectSeqnum_Inside extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectSeqnum_Inside() {
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

		String QusType = request.getParameter("QusType");
		String msg = "";

		Session session = HibernateSessionFactory.getSession();
		ExaminationInforInsideDAO dao = new ExaminationInforInsideDAO();
		List<ExaminationInforInside> list = dao.findAll();
		if (list.isEmpty()) {
			msg = "fail";
		} else {
			for (ExaminationInforInside ei : list) {
				if (ei.getId().getQusType().equals(QusType)) {
					if (msg.contains(ei.getId().getSeqNum())) {
						continue;
					}
					if (ei.getQusNum() != null && ei.getExaminerName1() == null) {
						if (msg.equals("")) {
							msg = ei.getId().getSeqNum();
						} else {
							msg += ";" + ei.getId().getSeqNum();
						}
					}
				}
			}
		}

		if (msg.equals("")) {
			msg = "fail";
		}

		session.close();

		PrintWriter out = response.getWriter();
		out.print(msg);
	}
}
