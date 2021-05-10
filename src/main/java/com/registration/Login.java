package com.registration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.doa.LoginDao;
import com.entity.UserData;

public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private LoginDao loginDao;

	public void init() {
		loginDao = new LoginDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserData loginBean = new UserData();
		loginBean.setUsername(username);
		loginBean.setPassword(password);

		try {
			
			if (loginDao.validate(loginBean)) {
				if(loginDao.getPost(loginBean)==1) {
				HttpSession session = request.getSession();
				 session.setAttribute("username",username);
				response.sendRedirect("./admin/index.html");
				}
				else if(loginDao.getPost(loginBean)==2) {
					response.sendRedirect("./staff/index.html");
				}
				else
					response.sendRedirect("./student/index.html");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("user", username);
				response.sendRedirect("index.jsp");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
