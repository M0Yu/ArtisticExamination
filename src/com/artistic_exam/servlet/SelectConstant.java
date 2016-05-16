package com.artistic_exam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.artistic_exam.Constant.ConstantDate;
import com.artistic_exam.Constant.ConstantDateDAO;

/**
 * Servlet implementation class SelectConstat
 */
@WebServlet("/SelectConstant")
public class SelectConstant extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectConstant() {
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

		String constantName = request.getParameter("ConstantName");
		String msg = "fail";

		try {
			ConstantDateDAO dao = new ConstantDateDAO();
			ConstantDate constant = dao.findById(constantName);
			if (constant == null) {
				throw new Exception("Error Constant");
			}
			msg = constant.getConstantValue();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			msg = e.getMessage();
		}

		PrintWriter out = response.getWriter();
		out.print(msg);

	}

}
