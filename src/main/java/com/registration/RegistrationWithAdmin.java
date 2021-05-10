package com.registration;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.doa.REgistrationDoa;
import com.entity.DummyUser;
import com.entity.UserData;

public class RegistrationWithAdmin extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private REgistrationDoa registrationdoa;
public RegistrationWithAdmin() {
	// TODO Auto-generated constructor stub
	this.registrationdoa=new REgistrationDoa();
}
    public void init() {
    	registrationdoa = new REgistrationDoa();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				//showNewForm(request, response);
				break;
			case "/insert":
				//insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				//showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException {
		List<DummyUser> listUser = registrationdoa.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("admin/studentlist.jsp");
		dispatcher.forward(request, response);
	}

//	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
//		dispatcher.forward(request, response);
//	}

//	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
//			throws SQLException, ServletException, IOException {
//		int id = Integer.parseInt(request.getParameter("id"));
//		User existingUser = userDAO.selectUser(id);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
//		request.setAttribute("user", existingUser);
//		dispatcher.forward(request, response);
//
//	}

//	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
//			throws SQLException, IOException {
//		String name = request.getParameter("name");
//		String email = request.getParameter("email");
//		String country = request.getParameter("country");
//		User newUser = new User(name, email, country);
//		userDAO.insertUser(newUser);
//		response.sendRedirect("list");
//	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ClassNotFoundException {
		
		String name = request.getParameter("rname");
		String email = request.getParameter("remail");
		String city = request.getParameter("rcity");
		String address = request.getParameter("raddress");
		String pincode = request.getParameter("rpincode");
		String mobile = request.getParameter("rnumber");
		String username = request.getParameter("rusername");
		String password = request.getParameter("rpassword");
		int postid=Integer.parseInt(request.getParameter("category"));
		
		

		UserData udata = new UserData(name,email,city,address,username,password,mobile,pincode,postid);
		//userDAO.updateUser(book);
		REgistrationDoa.updateUser(udata);
		response.sendRedirect("list");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ClassNotFoundException {
		String id = request.getParameter("id");
		REgistrationDoa.deleteUser(id);
		response.sendRedirect("list");

	}
}

