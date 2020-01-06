package com.deloitte.ecommerce.ui;


import com.deloitte.ecommerce.service.*;
import com.deloitte.ecommerce.dao.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(value = "/first")

	public class LoginServlet extends HttpServlet {

	  private CustomerWalletService service = new CustomerWalletServiceImpl(new CustomerWalletDaoImpl());

	    @Override
	    protected void doGet(HttpServletRequest req,
	                         HttpServletResponse resp)
	            throws ServletException, IOException {
	        resp.setContentType("text/html");
	        resp.setCharacterEncoding("UTF-8");
	        String mobileNo = req.getParameter("mobileNo");
	        String password = req.getParameter("password");
	        boolean correct=service.credentialsCorrect(mobileNo,password);
	        if (correct) {
	            HttpSession session=req.getSession();
	            session.setAttribute("mobileNo",mobileNo);
	            resp.sendRedirect("/second");
	        }else {
	            resp.sendRedirect("html/form.html");
	        }
	    }


	}









