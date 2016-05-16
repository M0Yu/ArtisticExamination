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
 * Servlet implementation class InsertHeight_Outside
 */
@WebServlet("/InsertHeight_Outside")
public class InsertHeight_Outside extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertHeight_Outside() {
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
		String Height = request.getParameter("Height");

		String msg = null;
		Session session = null;
		Transaction tran = null;

		if (RegNum == null || "".equals(RegNum) || Height == null
				|| "".equals(Height)) {
			msg = "fail";
		} else {
			try {
				Boolean flag = false;
				session = HibernateSessionFactory.getSession();
				tran = session.beginTransaction();

				ExaminationInforOutsideDAO oDao = new ExaminationInforOutsideDAO();
				ScoreSummaOutsideDAO dao = new ScoreSummaOutsideDAO();

				ExaminationInforOutside ei = oDao.findById(RegNum);
				if (ei == null) {
					throw new Exception("Error RegNum");
				} else {
					ScoreSummaOutside ss = new ScoreSummaOutside(RegNum);
					if(ss.getHeight() != null)
						throw new Exception("Height Exist");
					ss.setHeight(Height);
					dao.save(ss);

					tran.commit();
					msg = "success";
				}
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
