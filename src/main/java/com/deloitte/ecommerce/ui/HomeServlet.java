package com.deloitte.ecommerce.ui;

import com.deloitte.ecommerce.entities.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deloitte.ecommerce.service.*;
import com.deloitte.ecommerce.dao.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/second")
public class HomeServlet extends HttpServlet {

	 private CustomerWalletService service = new CustomerWalletServiceImpl(new CustomerWalletDaoImpl());

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession();
        String signedOutVal = req.getParameter("signout");
        boolean sessionDestroyed = false;
        if (signedOutVal != null && signedOutVal.equals("true")) {
            session.invalidate();
            sessionDestroyed = true;
        }
        Object mobileObj=null;
        if (!sessionDestroyed) {
            mobileObj = session.getAttribute("mobileNo");
        }

        if (mobileObj == null || mobileObj.toString().isEmpty()) {
            resp.getWriter().println("you are not signed in yet");
            String signInLink = "<a href='/html/form.html'>Sign In </a> ";
            writer.println(signInLink);
            return;
        }
        
        String mobileNo=mobileObj.toString();
        CustomerWallet user=service.getUserByUserMobile(mobileNo);
        String username=user.getName();
        writer.println("Welcome " + mobileNo +" user="+username);
        String signoutLink = "<a href='/second?signout=true'>Sign out </a> ";
        writer.println(signoutLink);

    }


}







