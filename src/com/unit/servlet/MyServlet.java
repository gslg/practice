package com.unit.servlet;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet(urlPatterns="/MyServlet",initParams={})
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		ServletContext sc = getServletContext();
		
		String contextpath = sc.getContextPath();
		String servletPath = request.getServletPath();
		String pathInfo = request.getPathInfo();
		System.out.println("index="+sc.getResource("/index.jsp"));
		System.out.println("servletPath="+servletPath);
		System.out.println("pathInfo="+pathInfo);
		System.out.println("contextpath="+request.getContextPath());
		System.out.println(sc.getRealPath(servletPath));
		System.out.println(sc.getInitParameter("name"));
		System.out.println("bufferedSize="+response.getBufferSize());
		InputStream is =  sc.getResourceAsStream("/index.jsp");
		
		
		HttpSession session = request.getSession();
		request.setAttribute("path", contextpath);
		
		response.sendRedirect(contextpath+"/login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
