package com.neuedu.business.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.business.entity.User;
import com.neuedu.business.service.UserService;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String msg = "";
		if("checkUser".equals(action)){
			msg = checkUserName(request,response);
		}
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println(msg);
		out.close();
	}

	private String checkUserName(HttpServletRequest request,HttpServletResponse response){
		String userName = request.getParameter("userName");
		User user = new User();
		user.setUsername(userName);
		UserService userService = UserService.getInstance();
		User checkedUser = userService.checkUser(user);
		String msg = "";
		if(checkedUser.getUsername()!=null){
			msg = "用户名已存在";
		}
		return msg;
	}
}
