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

import com.artistic_exam.ExaminationInfor_Outside.ExaminationInforOutside;
import com.artistic_exam.ExaminationInfor_Outside.ExaminationInforOutsideDAO;
import com.artistic_exam.sessionFactory.HibernateSessionFactory;

/**
 * Servlet implementation class SelectSeqnum_Outside
 */
@WebServlet("/SelectSeqnum_Outside")
public class SelectSeqnum_Outside extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectSeqnum_Outside() {
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

		ExaminationInforOutsideDAO dao = new ExaminationInforOutsideDAO();
		List<ExaminationInforOutside> list = dao.findAll();
		if (list.isEmpty()) {
			msg = "fail";
		} else {
			for (ExaminationInforOutside ei : list) {
				if (msg.contains(ei.getRegNum())) {
					continue;
				}
				if (ei.getQusNum1() != null && ei.getExaminerName1() == null) {
					if (!msg.equals("")) {
						msg += ";";
					}
					msg += ei.getRegNum();
				}
			}

		}
		if (msg.equals("")) {
			msg = "fail";
		}
		PrintWriter out = response.getWriter();
		out.print(msg);
	}

}
