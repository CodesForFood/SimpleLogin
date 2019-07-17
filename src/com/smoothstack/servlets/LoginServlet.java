package com.smoothstack.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smoothstack.models.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	List<User> userList = new ArrayList<User>();
	
  
    public LoginServlet() {
       super();
       userList.add(new User("eman", "12345"));
       userList.add(new User("Eli", "password"));        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.append("<html><body><h1>You have logged in succesfully</h1></body></html>");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		User loginUser = new User(userName, password);
		
		User checkedUser = userList.stream()
			.filter(user -> user.getUserName().equals(loginUser.getUserName()) && user.getPassword().equals(loginUser.getPassword()))
			.findAny()
			.orElse(null);
		
		if(checkedUser == null) {
			request.setAttribute("errMsg", "Invalid credential");
		    RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/index.jsp");
	    	dispatcher.forward(request, response);
		}
		else {
			doGet(request, response);
		}				
	}

}
