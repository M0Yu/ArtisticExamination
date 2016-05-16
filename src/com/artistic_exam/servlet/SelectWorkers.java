package com.artistic_exam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.artistic_exam.Workers.Workers;
import com.artistic_exam.Workers.WorkersDAO;

/**
 * Servlet implementation class SelectWorkers
 */
@WebServlet("/SelectWorkers")
public class SelectWorkers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectWorkers() {
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
		response.setContentType("text/htm;charset=utf-8");

		String name = request.getParameter("Name");
		String identype = request.getParameter("IdenType");
		String msg = null;

		WorkersDAO dao = new WorkersDAO();
		Workers worker = dao.findById(name);

		if (worker == null) {
			msg = "fail";
		} else if (!identype.equals(worker.getIdenType())) {
			msg = "fail";
		} else {
			// ��ʾ�û��������ƥ�䣬�жϷ�����Ϣ
			if (identype.equals("����")) // ������Ϊ���٣��򷵻ؿ��ٶ�Ӧ�Ŀ�����
				msg = worker.getQusType();
			else
				msg = "success"; // ���򷵻سɹ�����
		}

		PrintWriter out = response.getWriter();
		out.print(msg);
	}
}
