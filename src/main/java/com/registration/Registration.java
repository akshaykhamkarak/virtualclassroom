package com.registration;

import java.io.IOException;


import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.doa.REgistrationDoa;
import com.entity.UserData;

//@WebServlet("/Registration")
public class Registration extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private REgistrationDoa registrationdoa;

    public void init() {
    	registrationdoa = new REgistrationDoa();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String name = request.getParameter("rname");
        String city = request.getParameter("rcity");
       String citypin=request.getParameter("rcitypin");
        String email = request.getParameter("remail");
        String address = request.getParameter("raddress");
        String phone = request.getParameter("rnumber");
        String username = request.getParameter("rusername");
        String password = request.getParameter("rpassword");
        int postid=Integer.parseInt(request.getParameter("category"));

        UserData udata = new UserData();
       udata.setName(name);
       udata.setCity(city);
       udata.setPincode(citypin);
       udata.setAddress(address);
       udata.setPhonenum(phone);
       udata.setEmail(email);
       udata.setUsername(username);
       udata.setPassword(password);
       udata.setPostid(postid);
      
       
       
        try {
        	registrationdoa.registerUser(udata);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        response.sendRedirect("index.jsp");
    }
}