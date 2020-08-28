package net.todoapp.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.todoapp.dao.LoginDao;
import net.todoapp.model.LoginBean;

@WebServlet("/login")	
public class LoginController extends HttpServlet {
	private LoginDao loginDao;
	
	public void init() {
		loginDao = new LoginDao();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp){
		try {
			resp.sendRedirect("login/login.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp){
		authenticate(req,resp);
	}

	private void authenticate(HttpServletRequest req, HttpServletResponse resp){
		//params from request
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		LoginBean login = new LoginBean();
		login.setUsername(username);
		login.setPassword(password);

		try{
			if(loginDao.validate(login)){
				//redirect
				RequestDispatcher dispatcher = req.getRequestDispatcher("todo/todo-list.jsp");
				dispatcher.forward(req,resp);
			}else{
				resp.sendRedirect("login.jsp");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
