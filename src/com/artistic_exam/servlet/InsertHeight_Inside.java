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
import com.artistic_exam.ExaminationInfor_Inside.ExaminationInforInsideId;
import com.artistic_exam.ScoreSumma_Inside.ScoreSummaInside;
import com.artistic_exam.ScoreSumma_Inside.ScoreSummaInsideDAO;
import com.artistic_exam.sessionFactory.HibernateSessionFactory;

/**
 * Servlet implementation class InsertHeight_Inside
 */
@WebServlet("/InsertHeight_Inside")
public class InsertHeight_Inside extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertHeight_Inside() {
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
		String Height = request.getParameter("Height");

		String msg = null;
		Session session = null;
		Transaction tran = null;

		if (SeqNum == null || "".equals(SeqNum) || Height == null
				|| "".equals(Height)) {
			msg = "fail";
		} else {
			try {
				session = HibernateSessionFactory.getSession();
				tran = session.beginTransaction();

				ScoreSummaInsideDAO dao = new ScoreSummaInsideDAO();
				ExaminationInforInsideDAO iDao = new ExaminationInforInsideDAO();

				ExaminationInforInsideId id = new ExaminationInforInsideId(
						SeqNum, "1");
				ExaminationInforInside ei = iDao.findById(id);

				if (ei == null) {
					throw new Exception("Error SeqNum");
				} else {
					ScoreSummaInside ss = new ScoreSummaInside(SeqNum);
					if(ss.getHeight() != null)
						throw new Exception("Height Exist");
					
					ss.setHeight(Height);
					dao.save(ss);
					
					tran.commit();
					msg = "success";
				}
				// List<ExaminationInforInside> list = iDao.findAll();
				// for (ExaminationInforInside ei : list) {
				// if (SeqNum.equals(ei.getId().getSeqNum())) {
				// flag = true;
				// break;
				// }
				// }
				// if (flag) {
				// ScoreSummaInside ss = new ScoreSummaInside(SeqNum);
				// ss.setHeight(Height);
				// dao.attachDirty(ss);
				// tran.commit();
				// msg = "success";
				// } else {
				// msg = "fail";
				// }
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
