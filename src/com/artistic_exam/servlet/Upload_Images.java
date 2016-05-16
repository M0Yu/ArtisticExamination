package com.artistic_exam.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class Upload_Images
 */
@WebServlet("/Upload_Images")
public class Upload_Images extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Upload_Images() {
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
		return;
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

		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(8192);

		String Path = request.getSession().getServletContext().getRealPath("/")
				+ "/Photo";

		File file = new File(Path);
		if (!file.isDirectory()) {
			file.mkdirs();
		}

		factory.setRepository(file);
		ServletFileUpload upload = new ServletFileUpload(factory);

		List<FileItem> items;
		try {
			items = upload.parseRequest(request);
			for (FileItem item : items) {
				if (!item.isFormField()) {
					if (item.getName().contains(".jpg")
							|| item.getName().contains(".jpeg")
							|| item.getName().contains(".png")
							|| item.getName().contains(".bmp")) {
						File saveFile = new File(Path, item.getName());
						item.write(saveFile);
					}
				}
				/*
				 * else { System.out.print(""); //为表单控件时的操作 }
				 */
			}
			response.sendRedirect("result_success.jsp?url=uploadphotoes.jsp");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.sendRedirect("result_fail.jsp?url=uploadphotoes.jsp");
		}
	}

}
