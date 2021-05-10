package  com.registration;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

public class Addvalue implements Servlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Inside the init method------");
		
	}


	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String str = req.getParameter("name");
		 System.out.println("value is: ");
//		RequestDispatcher rd = req.getRequestDispatcher("another");
//		rd.forward(req, res);

	PrintWriter out=res.getWriter();
	out.print("Hello");
		
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("inside the destroy");
		
	}
}
